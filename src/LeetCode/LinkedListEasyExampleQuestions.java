package LeetCode;

import LeetCode.Models.ListNode;

import java.util.List;

public class LinkedListEasyExampleQuestions {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);

//        ListNode nodeToDelete = head.next.next;

        //Delete Node in a Linked List
        //deleteNode(nodeToDelete);
        //printLinkedList(head);

        //Remove Nth Node From End of List
       // printLinkedList(removeNthFromEnd(head,2));
        //printLinkedList(removeNthFromEndOptimal(head,2));

        //Reverse Linked List
        //printLinkedList(reverseList(head));

        //Palindrome Linked List
        System.out.println((isPalindrome(head)));

    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode node = head;
        while (node.next != null){
           size++;
           node = node.next;
        }
        node = head;
        int found = size - n;
        if(size == n)
            return head.next;
        else
            for (int i = 1; i <= found; i++) {
                if(i == found){
                    node.next = node.next.next;
                }else{
                    node = node.next;
                }
            }
        return head;
    }

    // second way
    public static ListNode removeNthFromEndOptimal(ListNode head, int n) {
        // creating dummy with 0 for case when head needs to be removed
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    //Recursive way to reverse list
    public static ListNode reverseListRecursive(ListNode head) {
        // Base case: If the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the rest of the list
        ListNode reversedHead = reverseListRecursive(head.next);

        // Reverse the current node
        head.next.next = head;
        head.next = null;

        return reversedHead;
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        if(head.next == null)
            return true;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        while (slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        while (prev != null){
            if(prev.val != head.val)
                return false;
            else{
                prev = prev.next;
                head = head.next;
            }
        }

        return  true;
    }
}

