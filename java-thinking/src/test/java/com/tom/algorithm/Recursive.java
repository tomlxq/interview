package com.tom.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Recursive {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = 0; i < row && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < col && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i - 1][j] + dp[i][j - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[] dp = new int[col];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[col - 1];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int[] r = new int[n];
        Arrays.fill(r, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                r[j] = r[j - 1] + r[j];
            }
        }
        return r[n - 1];
    }

    /*
    示例 1：

    输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    输出：11
    解释：如下面简图所示：
       2
      3 4
     6 5 7
    4 1 8 3
    自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
    示例 2：

    输入：triangle = [[-10]]
    输出：-10

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/triangle
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.get(0) == null) {
            return -1;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int h = triangle.size();
        //初始化dp
        int[][] dp = new int[h][];
        for (int i = 0; i < h; i++) {
            dp[i] = new int[triangle.get(i).size()];
        }

        for (int i = h - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == h - 1) {
                    dp[i][j] = triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return dp[0][0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.get(0) == null) {
            return -1;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int h = triangle.size();
        int[] dp = new int[h];
        for (int i = h - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == h - 1) {
                    dp[j] = triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return dp[0];
    }

}