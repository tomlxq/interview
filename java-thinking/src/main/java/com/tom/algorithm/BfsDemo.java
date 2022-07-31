package com.tom.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class BfsDemo {
    int start = 0, end = 0;

    public boolean hasPath2(int[][] maze, int[] start, int[] destination) {
        //定义访问的列表
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visit = new boolean[cols][rows];
        //定义方向
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        return dfs(maze, start, destination, directions, visit);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination, int[][] directions, boolean[][] visit) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        int rows = maze.length;
        int cols = maze[0].length;
        //在墙体内，而且当前节点不是强
        for (int[] dir : directions) {
            int tmpX = start[0];
            int tmpY = start[1];
            //方向上不是墙，就继续走
            while (0 <= (tmpX += dir[0]) && tmpX < cols && (tmpY += dir[1]) >= 0 && tmpY < rows && maze[tmpX][tmpY] == 0) {
            }
            tmpX -= dir[0];
            tmpY -= dir[1];
            if (!visit[tmpX][tmpY]) {
                visit[tmpX][tmpY] = true;
                if (dfs(maze, new int[]{tmpX, tmpY}, destination, directions, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 题目描述:
     * 由空地和墙组成的迷宫中有一个球。球可以向上下左右四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。
     * <p>
     * 给定球的起始位置，目的地和迷宫，判断球能否在目的地停下。
     * <p>
     * 迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。
     * <p>
     * 示例:
     * 示例 1:
     * <p>
     * 输入 1: 迷宫由以下二维数组表示
     * <p>
     * 0 0 1 0 0
     * 0 0 0 0 0
     * 0 0 0 1 0
     * 1 1 0 1 1
     * 0 0 0 0 0
     * <p>
     * 输入 2: 起始位置坐标 (rowStart, colStart) = (0, 4)
     * 输入 3: 目的地坐标 (rowDest, colDest) = (4, 4)
     * <p>
     * 输出: true
     * <p>
     * 解析: 一个可能的路径是 : 左 -> 下 -> 左 -> 下 -> 右 -> 下 -> 右。
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 示例 2:
     * <p>
     * 输入 1: 迷宫由以下二维数组表示
     * <p>
     * 0 0 1 0 0
     * 0 0 0 0 0
     * 0 0 0 1 0
     * 1 1 0 1 1
     * 0 0 0 0 0
     * <p>
     * 输入 2: 起始位置坐标 (rowStart, colStart) = (0, 4)
     * 输入 3: 目的地坐标 (rowDest, colDest) = (3, 2)
     * <p>
     * 输出: false
     * <p>
     * 解析: 没有能够使球停在目的地的路径。
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 注意:
     * <p>
     * 迷宫中只有一个球和一个目的地。
     * 球和目的地都在空地上，且初始时它们不在同一位置。
     * 给定的迷宫不包括边界 (如图中的红色矩形), 但你可以假设迷宫的边缘都是墙壁。
     * 迷宫至少包括2块空地，行数和列数均不超过100。
     */

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //定义方向
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //定义访问的列表
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visit = new boolean[cols][rows];
        visit[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == destination[0] && cur[1] == destination[1]) {
                    return true;
                }
                //在墙体内，而且当前节点不是强
                for (int[] dir : directions) {
                    int tmpX = cur[0];
                    int tmpY = cur[1];
                    //方向上不是墙，就继续走
                    while (0 <= (tmpX += dir[0]) && tmpX < cols && (tmpY += dir[1]) >= 0 && tmpY < rows && maze[tmpX][tmpY] == 0) {
                    }
                    tmpX -= dir[0];
                    tmpY -= dir[1];
                    if (!visit[tmpX][tmpY]) {
                        visit[tmpX][tmpY] = true;
                        queue.add(new int[]{tmpX, tmpY});
                    }
                }
            }
        }
        return false;
    }

    /**
     * 127. 单词接龙
     * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
     * <p>
     * 每一对相邻的单词只差一个字母。
     * 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
     * sk == endWord
     * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
     * 输出：5
     * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
     * 示例 2：
     * <p>
     * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
     * 输出：0
     * 解释：endWord "cog" 不在字典中，所以无法进行转换。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= beginWord.length <= 10
     * endWord.length == beginWord.length
     * 1 <= wordList.length <= 5000
     * wordList[i].length == beginWord.length
     * beginWord、endWord 和 wordList[i] 由小写英文字母组成
     * beginWord != endWord
     * wordList 中的所有字符串 互不相同
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //1. 提高效率把 wordList放hash表中
        //2.判断列表是否为空或不包括target返回为空
        //3.广度优先需要一个hash表用于存储访问过的节点，一个队列用于存储搜索的层的节点
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        //4.返回最短路径，初始路径为1
        //5.处理逻辑
        //①将队列中的单词逐个取出
        //②比较每个单词是否每一对相邻的单词只差一个字母
        //为了提高效率，把取出的词，每个位置用a-z替换，然后判断在wordSet是否存在
        //③在wordSet存在,若与endWord相同则返回step+1
        //④在wordSet存在,判断在visited列表中存在，存在继续
        //⑤完成后，将此单词加入到访问列表，也加入到队列
        //⑥待队列处理完成，step+1
        int step = 1, len = endWord.length();
        while (!queue.isEmpty()) {
            //要存一下size，不然每次取都在变
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();
                for (int i = 0; i < len; i++) {
                    char originalChar = chars[i];
                    for (char curChar = 'a'; curChar <= 'z'; curChar++) {
                        if (originalChar == curChar) {
                            continue;
                        }
                        chars[i] = curChar;
                        String nextWord = String.valueOf(chars);
                        if (wordList.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(nextWord)) {
                                queue.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    //灰复单词，进行后续位置的比较
                    chars[i] = originalChar;
                }
            }
            step++;
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        int step = 1, len = endWord.length();
        Set<String> nextLevelVisit = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            for (String cur : beginSet) {
                char[] chars = cur.toCharArray();
                for (int i = 0; i < len; i++) {
                    char originalChar = chars[i];
                    for (char curChar = 'a'; curChar <= 'z'; curChar++) {
                        if (originalChar == curChar) {
                            continue;
                        }
                        chars[i] = curChar;
                        String nextWord = String.valueOf(chars);
                        if (wordList.contains(nextWord)) {
                            if (endSet.contains(nextWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(nextWord)) {
                                nextLevelVisit.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    //灰复单词，进行后续位置的比较
                    chars[i] = originalChar;
                }
            }
            step++;
            beginSet = nextLevelVisit;
        }
        return 0;
    }

    boolean check(int x, int y, int step, int targetX, int targetY, boolean[][] visited, LinkedList<int[]> stack) {
        if (x == targetX && y == targetY) {
            return true;
        }
        if (visited[x][y]) {
            return false;
        }
        visited[x][y] = true;
        end++;
        stack.add(new int[]{x, y, step + 1});
        return false;
    }

    public int minimumMoves(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        //二维数组记录被访问点的坐标
        boolean[][] visited = new boolean[row * col][row * col];
        //蛇头、蛇尾的目标
        int targetX = row * col - 2, targetY = row * col - 1;
        //蛇每次走位的坐标存到队列stack(用来记蛇头、蛇尾、初始步子)中，先进先出（FIFO），只要和目标坐标相等，即可返回
        LinkedList<int[]> stack = new LinkedList<>();
        stack.offer(new int[]{0, 1, 0});
        while (start <= end) {
            int[] tmp = stack.poll();//先进先出（FIFO）
            //蛇头、蛇尾所在格子、步子
            int a = tmp[0], b = tmp[1], step = tmp[2];
            start++;
            //蛇头的横坐标，纵坐标
            //所在格子/列数表明是第几排 数组的第几行数据
            //所在格子%列数表明是这一排的第几个位置  数组对应的该行的第几列数据
            int x0 = a / col, y0 = a % col;
            int x1 = b / col, y1 = b % col;
            // 向右
            //y0 + 1 < col 不能超过边界
            //grid[x0][y0 + 1] 新的蛇头位置 是0表示是空的
            //grid[x1][y1 + 1] 新的蛇尾位置 是0表示是空的
            //如果（x1 + 1) 和 （x2 + 1) 没有障碍物，向右平移，如果是竖直状态，还可以旋转
            if (y0 + 1 < col && grid[x0][y0 + 1] == 0 && y1 + 1 < col && grid[x1][y1 + 1] == 0) {
                if (check(col * x0 + y0 + 1, col * x1 + y1 + 1, step, targetX, targetY, visited, stack)) {
                    return step + 1;
                }
                if (y0 == y1) { // 竖直状态
                    if (check(a, col * x0 + y0 + 1, step, targetX, targetY, visited, stack)) {
                        return step + 1;
                    }
                }
            }

            // 如果（x1 + n) 和 （x2 + n) 没有障碍物，向下平移，如果是水平状态，还可以旋转
            if (x0 + 1 < row && grid[x0 + 1][y0] == 0 && x1 + 1 < row && grid[x1 + 1][y1] == 0) {
                if (check(col * x0 + y0 + col, col * x1 + y1 + col, step, targetX, targetY, visited, stack)) {
                    return step + 1;
                }
                if (x0 == x1) { // 水平状态
                    if (check(a, col * x0 + y0 + col, step, targetX, targetY, visited, stack)) {
                        return step + 1;
                    }
                }
            }
        }
        return -1;
    }


    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public int findCircleNum(int[][] isConnected) {
        //int[][] isConnected 是无向图的邻接矩阵，n 为无向图的顶点数量
        int cities = isConnected.length;
        //定义 boolean 数组标识顶点是否被访问
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            //若当前顶点 i 未被访问，说明又是一个新的连通域，则遍历新的连通域且provinces+=1.
            if (!visited[i]) {
                dfs(i, visited, cities, isConnected);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int i, boolean[] visited, int cities, int[][] isConnected) {
        //对当前顶点 j 进行访问标记
        visited[i] = true;
        for (int j = 0; j < cities; j++) {
            //继续遍历与顶点 i 相邻的顶点（使用 visited 数组防止重复访问）
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(j, visited, cities, isConnected);
            }
        }
    }

    public int findCircleNum2(int[][] isConnected) {
        //int[][] isConnected 是无向图的邻接矩阵，n 为无向图的顶点数量
        int cities = isConnected.length;
        LinkedList<Integer> queue = new LinkedList<>();
        // 定义 boolean 数组标识顶点是否被访问
        boolean[] visited = new boolean[cities];
        // 定义 provinces 来累计遍历过的连通域的数量
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            // 若当前顶点 i 未被访问，说明又是一个新的连通域，则bfs新的连通域且provinces+=1.
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int k = queue.poll();
                    visited[k] = true;
                    for (int j = 0; j < cities; j++) {
                        if (isConnected[k][j] == 1 && !visited[j]) {
                            queue.add(j);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }

    public int findCircleNum3(int[][] isConnected) {
        int cities = isConnected.length;
        // 初始化并查集
        int[] head = new int[cities];
        int[] level = new int[cities];
        for (int i = 0; i < cities; i++) {
            head[i] = i;
            level[i] = 1;
        }
        // 遍历每个顶点，将当前顶点与其邻接点进行合并
        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {
                if (isConnected[i][j] == 1) {
                    merge(i, j, head, level);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < cities; i++) {
            if (i == head[i]) {
                count++;
            }
        }
        return count;
    }

    private void merge(int x, int y, int[] head, int[] level) {
        int i = find(x, head);
        int j = find(y, head);
        if (i == j) {
            return;
        }

        if (level[i] <= level[j]) {
            head[i] = j;
        } else {
            head[j] = i;
        }
        if (level[i] == level[j]) {
            level[i]++;
            level[j]++;
        }
    }

    private int find(int i, int[] head) {
        if (i == head[i]) {
            return i;
        }
        head[i] = find(head[i], head);
        return head[i];
    }
}
