package Kotlin

import LeetCode.Models.ListNode

class LeetCodeQuestions {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val head = ListNode(1)
            head.next = ListNode(2)
//            head.next.next = ListNode(3)
//            head.next.next.next = ListNode(4)
//            head.next.next.next.next = ListNode(5)
          removeNthFromEnd(head,1)
        }
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            // Create a dummy node to handle the case where head needs to be removed
            val dummy = ListNode(0)
            dummy.next = head
            var fast: ListNode? = dummy
            var slow: ListNode? = dummy

            // Move fast pointer n+1 steps ahead
            for (i in 0..n) {
                fast = fast?.next
            }

            // Move both pointers until fast reaches the end means slow will be just before the node which has to be removed
            while (fast?.next != null) {
                fast = fast?.next
                slow = slow?.next
            }

            // Remove the nth node from the end
            slow?.next = slow?.next?.next

            return dummy.next
        }
    }
}