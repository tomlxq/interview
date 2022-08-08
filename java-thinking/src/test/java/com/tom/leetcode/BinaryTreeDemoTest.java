package com.tom.leetcode;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

@Slf4j
public class BinaryTreeDemoTest {
    BinaryTreeDemo btd = null;
    TreeNode node1;

    @Before
    public void setUp() throws Exception {
        btd = new BinaryTreeDemo();
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node5 = new TreeNode(5, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, null, null);
        node1 = new TreeNode(1, node2, node3);
    }

    @Test
    public void preorderTraversal() {

        List<Integer> list = Lists.newArrayList(1, 2, 4, 5, 6, 7, 3);
        assertTrue(btd.preorderTraversal(node1).equals(list));
        assertTrue(btd.preorderTraversal2(node1).equals(list));
        assertTrue(btd.preorderTraversal3(node1).equals(list));
        List<Integer> list2 = Lists.newArrayList(4, 2, 6, 5, 7, 1, 3);
        assertTrue(btd.inorderTraversal(node1).equals(list2));
        assertTrue(btd.inorderTraversal2(node1).equals(list2));
        assertTrue(btd.inorderTraversal3(node1).equals(list2));
        List<Integer> list3 = Lists.newArrayList(4, 6, 7, 5, 2, 3, 1);
        assertTrue(btd.postorderTraversal(node1).equals(list3));
        assertTrue(btd.postorderTraversal2(node1).equals(list3));
        assertTrue(btd.postorderTraversal3(node1).equals(list3));
        //log.info("{}",btd.postorderTraversal4(node1));
        assertTrue(btd.postorderTraversal4(node1).equals(list3));


    }

    @Test
    public void levelOrder() {
        List<List<Integer>> list4 = Lists.newArrayList(Lists.newArrayList(1),
                Lists.newArrayList(2, 3),
                Lists.newArrayList(4, 5),
                Lists.newArrayList(6, 7));
        assertTrue(btd.levelOrder(node1).equals(list4));
        assertTrue(btd.levelOrder2(node1).equals(list4));
        TreeNode node22 = new TreeNode(2, null, null);
        TreeNode node11 = new TreeNode(1, null, node22);
        List<List<Integer>> list5 = Lists.newArrayList(Lists.newArrayList(1),
                Lists.newArrayList(2));
        assertTrue(btd.levelOrder(node11).equals(list5));
    }
}