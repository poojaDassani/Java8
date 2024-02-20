package LeetCode;

import LeetCode.Models.ListNode;

public class LinkedListEasyExampleQuestions {
    public static void main(String[] args) {

    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

