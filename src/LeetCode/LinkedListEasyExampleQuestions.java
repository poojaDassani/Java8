package LeetCode;

import LeetCode.Models.ListNode;

public class LinkedListEasyExampleQuestions {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode nodeToDelete = head.next.next;

        //Delete Node in a Linked List
        deleteNode(nodeToDelete);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

