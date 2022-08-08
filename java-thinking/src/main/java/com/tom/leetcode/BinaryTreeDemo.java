package com.tom.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;

import java.util.*;

@Slf4j
public class BinaryTreeDemo {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
       /* treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode tmp = treeNodes.pop();
            if (tmp == null) {
                return res;
            }
            res.add(tmp.val);
            treeNodes.add(tmp.right);
            treeNodes.add(tmp.left);
        }*/
        while (root != null || treeNodes.size() > 0) {
            while (root != null) {
                res.add(root.val);
                treeNodes.add(root);
                root = root.left;
            }
            root = treeNodes.pop();
            root = root.right;
        }
        return res;
    }

    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        if (cur == null) {
            return res;
        }
        while (cur != null) {
            TreeNode mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {//建议morris链接
                    mostRight.right = cur;
                    res.add(cur.val);
                    cur = cur.left;
                    continue;
                } else {//删除morris链接
                    mostRight.right = null;
                }
            } else {
                res.add(cur.val);
            }
            cur = cur.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        if (cur == null) {
            return res;
        }
        while (cur != null) {
            TreeNode mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {//建议morris链接
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {//删除morris链接
                    mostRight.right = null;
                }
            }
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                res.add(root.val);
                root = root.right;
            }
            root = stk.pop();
            root = root.left;
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stk.isEmpty()) {
            //找到最左边的节点
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {//不为空，把右边节点压缩栈中，继续处理
                stk.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> postorderTraversal4(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        while (cur != null) {
            TreeNode mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    processRes(cur.left, res);
                }
            } else {
            }
            cur = cur.right;
        }
        processRes(root, res);
        return res;

    }

    private void processRes(TreeNode head, List<Integer> res) {
        TreeNode tail = reverseNode(head);
        while (tail != null) {
            res.add(tail.val);
            tail = tail.right;
        }
        reverseNode(tail);
    }

    @Nullable
    private TreeNode reverseNode(TreeNode head) {
        TreeNode cur = head, next, prev = null;
        while (cur != null) {
            next = cur.right;
            cur.right = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, 0, res);
        return res;
    }

    private void levelOrder(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(level, new ArrayList<Integer>());
        }
        List<Integer> integers = res.get(level);
        integers.add(root.val);
        levelOrder(root.left, level + 1, res);
        levelOrder(root.right, level + 1, res);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp != null) {
                    if (res.size() <= level) {
                        res.add(level, new ArrayList<Integer>());
                    }
                    List<Integer> integers = res.get(level);
                    integers.add(tmp.val);
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }
            }
            level++;
        }
        return res;
    }
}
