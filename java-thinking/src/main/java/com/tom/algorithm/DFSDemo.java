package com.tom.algorithm;

import java.util.LinkedList;

public class DFSDemo {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(min, minDepth(root.left));
        }
        if (root.right != null) {
            min = Math.min(min, minDepth(root.right));
        }
        return min + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        int deep = 0;
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            deep += 1;
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = treeNodes.poll();
                if (temp.left == null && temp.right == null) {
                    return deep;
                }
                if (temp.left != null) {
                    treeNodes.add(temp.left);
                }
                if (temp.right != null) {
                    treeNodes.add(temp.right);
                }
            }
        }
        return 0;
    }

}
