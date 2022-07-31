package com.tom.algorithm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DFSDemoTest {
    DFSDemo dfs = null;

    @Before
    public void setUp() throws Exception {
        dfs = new DFSDemo();
    }

    @Test
    public void minDepth() {
        //[3,9,20,null,null,15,7]
        TreeNode left15 = new TreeNode(15, null, null);
        TreeNode right7 = new TreeNode(7, null, null);
        TreeNode right20 = new TreeNode(20, left15, right7);
        TreeNode left9 = new TreeNode(9, null, null);
        TreeNode treeNode = new TreeNode(3, left9, right20);

        assertEquals(2, dfs.minDepth(treeNode));
        assertEquals(2, dfs.minDepth2(treeNode));


    }
}