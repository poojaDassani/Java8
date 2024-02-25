package LeetCode;


import LeetCode.Models.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Arrays;

public class TreeEasyExampleQuestions {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        int[] nums = new int[]{0};

        //Maximum Depth of Binary Tree
        //System.out.println(maxDepth(root));

        //Validate Binary Search Tree
        //.out.println(isValidBST(root));

        //Convert Sorted Array to Binary Search Tree
        printTree(sortedArrayToBST(nums));
    }

    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int leftTraverse = maxDepth(root.left);
        int rightTraverse = maxDepth(root.right);

        return Math.max(leftTraverse,rightTraverse) +1;
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        System.out.println("node"+node.val+" min val"+min+" max val"+max);

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return constructBST(nums, 0, nums.length - 1);
    }

    private static TreeNode constructBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructBST(nums, start, mid - 1);
        node.right = constructBST(nums, mid + 1, end);
        return node;
    }
    public static void printTree(TreeNode root) {
        printTree(root, 0);
    }

    private static void printTree(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        // Print the current node's value with appropriate indentation
        for (int i = 0; i < depth; i++) {
            System.out.print("  "); // Adjust the number of spaces for indentation
        }
        System.out.println(node.val);

        // Recursively print the left and right subtrees with increased depth
        printTree(node.left, depth + 1);
        printTree(node.right, depth + 1);
    }
}
