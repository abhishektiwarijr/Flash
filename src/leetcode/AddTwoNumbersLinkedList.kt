package leetcode

data class ListNode(var value: Int, var next: ListNode? = null)

fun main() {
    val l1 = ListNode(2, ListNode(4, ListNode(3)))
    val l2 = ListNode(5, ListNode(6, ListNode(4)))
    var l3 = addTwoNumbers(l1, l2)


    while (l3 != null) {
        print(l3.value)
        l3 = l3.next
    }
}



fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    //Keep adding and go forward
    //Save the carry

    var resultHead : ListNode? = null
    var p : ListNode? = null

    var head1 = l1
    var head2 = l2
    var carry = 0

    while (head1 != null || head2 != null) {
        val v1 = head1?.value ?: 0
        val v2 = head2?.value ?: 0

        var sum = v1 + v2 + carry
        if(sum > 9) {
            carry = sum / 10
            sum %= 10
        } else {
            carry = 0
        }

        if(resultHead == null) {
            resultHead = ListNode(sum)
            p = resultHead
        } else {
            p?.next = ListNode(sum)
            p = p?.next
        }

        head1 = head1?.next
        head2 = head2?.next
    }

    if(carry > 0) {
        p?.next = ListNode(carry)
    }

    return resultHead
}