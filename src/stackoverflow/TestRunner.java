package stackoverflow;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class TestRunner {
    public static void main(String[] args) {
        ProductSettings settings = new ProductSettings()
                .setIsTreasuryInfoEnabled(true)
                .setIsTreasurySwiftInfoEnabled(true)
                .setIsTreasuryExecutionControlEnabled(true)
                .setIsAcceptEnabled(true);

        Map<ProductType, Predicate<ProductSettings>> mapGetter = new HashMap<>();
        Map<ProductType, BiConsumer<ProductSettings, Boolean>> mapSetter = new HashMap<>();

        mapGetter.put(ProductType.ACCEPT, ProductSettings::getIsAcceptEnabled);
        mapGetter.put(ProductType.INFO,ProductSettings::getIsTreasuryInfoEnabled);

        mapSetter.put(ProductType.ACCEPT, ProductSettings::setIsAcceptEnabled);
        mapSetter.put(ProductType.INFO, ProductSettings::setIsTreasuryInfoEnabled);

        Set<ProductType> enabledProductTypes = EnumSet.allOf(ProductType.class);

    }
}
