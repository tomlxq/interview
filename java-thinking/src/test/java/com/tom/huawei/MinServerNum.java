package com.tom.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MinServerNum {
    int count = 0;

/*    public int func(int[][] connects) {
        int row = connects.length;
        boolean[] visited = new boolean[row];
        for (int i = 0; i < row; i++) {
            if (!visited[i]) {
                dfs(connects, visited, i);
            }
        }
        return count;
    }

    private void dfs(int[][] connects, boolean[] visited, int idx) {
        visited[idx] = true;
        boolean flag = true;
        for (int i = idx+1; i < connects.length; i++) {
            if (connects[idx][i] == 1) {
                flag = false;
                dfs(connects, visited, i);
            }
        }
        if (flag) {
            count++;
        }
    }*/


    //public static int count = 0;
    public int func(int[][] connects) {
        int n = connects.length;
        //Scanner in = new Scanner(System.in);
        //String[] str = in.nextLine().split(" ");
        //  int n = str.length;
        int[][] arr = new int[n][n];
        //for(int i = 0; i < n; i++) {  // 把第一行加入arr
        //     arr[0][i] = Integer.parseInt(str[i]);
        /// }
        //  for(int i = 1; i < n; i++) {  // 把剩下的行加入arr
        //      String[] s = in.nextLine().split(" ");
        //     for(int j = 0; j < n; j++) {
        //        arr[i][j] = Integer.parseInt(s[j]);
        //    }
        // }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(arr, visited, i);
            }
        }
        return count;
    }

    public void dfs(int[][] arr, boolean[] visited, int index) {
        visited[index] = true;
        boolean flag = true;
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[index][i] == 1) {
                flag = false;
                dfs(arr, visited, i);
            }
        }
        if (flag) {
            count++;
        }
    }

    public int func2(int[][] connects) {
        int N = connects.length;
        List<List<Integer>> res = new ArrayList<>(); // 存储需要广播的服务器
        for (int i = 0; i < N; i++) {
            // 每一行
            if (isContainer(res, i)) {
                // 判断某个服务器是否已经存在其连通的服务器集合中
                continue;
            }
            List<Integer> newList = new ArrayList<>();
            newList.add(i);
            int lastLength = 0;
            while (lastLength != newList.size()) {
                // 判断当前集合可以联通的服务器
                for (int k = 0; k < newList.size(); k++) {

                    int x = newList.get(k);
                    int[] tmp = connects[x];
                    for (int j = 0; j < N; j++) {
                        if (tmp[j] == 1) {

                            if (!newList.contains(j)) {

                                newList.add(j);
                            }
                        }
                    }
                }
                lastLength = newList.size();
            }
            res.add(newList);
        }
        return res.size();

    }

    public static Boolean isContainer(List<List<Integer>> res, int x) {

        for (List<Integer> integers : res) {

            if (integers.contains(x)) {

                return true;
            }
        }
        return false;
    }

}
