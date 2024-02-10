package flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

sealed class Enchantment {
    class Alohamora() : Enchantment()
}
sealed class Weapon {
    class Sword : Weapon()
    class Staff : Weapon()
    class SpellBook : Weapon()
    class Grenade : Weapon()
}

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking {
    val weaponProducer: Flow<Weapon> = flowOf()

    val weaponBox = mutableListOf<Weapon>()
    weaponProducer.collect { weapon ->
        weaponBox.add(weapon)
    }

    // Intermediary Operator : Filter
    // The filter operator is used to select elements from the Flow
    // that meet a specific condition.
    weaponProducer.filter {
        it is Weapon.Sword
    }.collect {

    }

    // Intermediary Operator : DistinctUntilChanged
    // The distinctUntilChanged operator filters out consecutive
    // duplicate elements.
    // It allows a value to be emitted only if it’s different
    // from the previous value.
    weaponProducer
        .distinctUntilChanged()
        .collect {

        }

    // Intermediary Operator : Map
    // The Map operator is used to transform each input element into
    // a different output element. It does not change the original
    // Flow or collection, it creates a new one
    // with the transformed value.
    weaponProducer.map { weapon ->
        mapToEnhancedWeapon(weapon)
    }.collect {

    }

    // Intermediary Operator : FlatMap
    // Map transforms each element individually while flatMap
    // transforms each element into another Flow and then
    // merges those two flows into one.
    val weaponTypes: Flow<WeaponType> = queryWeaponTypes()
    weaponTypes.flatMapConcat {type ->
        produceWeapons(type)
    }.collect()

    // Intermediary Operator : Zip
    // Zip combines two flows together,
    // it takes corresponding elements from each flow and
    // pairs them into a single element.
    // This happens sequentially: the first element of Flow A
    // is paired with the first element of Flow B,
    // the second with the second, and so on.
    val enchantments: Flow<Enchantment> = queryEnchantments()
    val weapons: Flow<Weapon> = queryWeapons()

    enchantments.zip(weapons) { enchantment, weapon ->
        createMagicWeapon(enchantment, weapon)
    }.collect()
}

data class MagicWeaponX(val enchantment : Enchantment, val weapon: Weapon)
fun createMagicWeapon(enchantment: Enchantment, weapon: Weapon): MagicWeaponX {
    return MagicWeaponX(enchantment, weapon)
}

fun queryEnchantments() : Flow<Enchantment> = flow { emit(Enchantment.Alohamora()) }
fun queryWeapons() : Flow<Weapon> = flow { emit(Weapon.Sword()) }

fun queryWeaponTypes(): Flow<WeaponType> = flow {
    emit(WeaponType.ExplosiveWeapons())
}

sealed class WeaponType {
    class ImpactWeapons() : WeaponType()
    class ProjectileWeapons() : WeaponType()
    class BladedWeapons() : WeaponType()
    class FirearmWeapons() : WeaponType()
    class ExplosiveWeapons() : WeaponType()
    class FlamethrowerWeapons() : WeaponType()
    class ArtilleryWeapons() : WeaponType()
}

/**
 * Emit weapons of the specified type
 */
private fun produceWeapons(weaponType: WeaponType): Flow<Weapon> {
    return flow {
        if(weaponType is WeaponType.ExplosiveWeapons) {
            emit(Weapon.Grenade())
        } else {
            emit(Weapon.Sword())
        }
    }
}


class Enhanced<T>

inline fun <reified T> mapToEnhancedWeapon(weapon: T) : Enhanced<T> {
    return Enhanced<T>()
}
