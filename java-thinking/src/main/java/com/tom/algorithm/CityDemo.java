package com.tom.algorithm;


import javacutils.Pair;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
 * <p>
 * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
 * <p>
 * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
 * 输出：3
 * 解释：城市分布图如上。
 * 每个城市阈值距离 distanceThreshold = 4 内的邻居城市分别是：
 * 城市 0 -> [城市 1, 城市 2] 
 * 城市 1 -> [城市 0, 城市 2, 城市 3] 
 * 城市 2 -> [城市 0, 城市 1, 城市 3] 
 * 城市 3 -> [城市 1, 城市 2] 
 * 城市 0 和 3 在阈值距离 4 以内都有 2 个邻居城市，但是我们必须返回城市 3，因为它的编号最大。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
 * 输出：0
 * 解释：城市分布图如上。 
 * 每个城市阈值距离 distanceThreshold = 2 内的邻居城市分别是：
 * 城市 0 -> [城市 1] 
 * 城市 1 -> [城市 0, 城市 4] 
 * 城市 2 -> [城市 3, 城市 4] 
 * 城市 3 -> [城市 2, 城市 4]
 * 城市 4 -> [城市 1, 城市 2, 城市 3] 
 * 城市 0 在阈值距离 2 以内只有 1 个邻居城市。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 100
 * 1 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 3
 * 0 <= fromi < toi < n
 * 1 <= weighti, distanceThreshold <= 10^4
 * 所有 (fromi, toi) 都是不同的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class CityDemo {
    int cnt = 0;

    public int findTheCity4(int n, int[][] edges, int distanceThreshold) {
        int INF = 0x3f3f3f3f;
        int[][] graph = new int[n][n];
        for (int[] a : graph) {
            Arrays.fill(a, INF);
        }

        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u][v] = graph[v][u] = w;
        }
        int idx = -1, minCnt = INF;
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dist, INF);
            dist[i] = 0; //自身到自身的距离为0
            Arrays.fill(vis, false);
            for (int j = 0; j < n; ++j) {
                int u = -1, minDis = INF;
                for (int k = 0; k < n; ++k) {
                    if (!vis[k] && dist[k] < minDis) {
                        u = k;
                        minDis = dist[k];
                    }
                }
                if (u == -1) {
                    break; //所有点不可达，直接结束，加速代码进程
                }
                vis[u] = true;
                for (int v = 0; v < n; ++v) {
                    if (!vis[v]) {
                        dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
                    }
                }
            }
            int cnt = 0;
            for (int j = 0; j < n; ++j) {
                if (dist[j] <= distanceThreshold && i != j) {
                    cnt++;
                }
            }
            if (cnt <= minCnt) {
                minCnt = cnt;
                idx = i;
            }
        }
        return idx;
    }


    void floyd(int[][] distances, int n) {
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE && distances[i][k] + distances[k][j] < distances[i][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }
    }

    public int findTheCity2(int n, int[][] edges, int distanceThreshold) {
        int[][] distances = new int[n][n]; //全源最短路径矩阵
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            distances[i][i] = 0; //自身到自身的距离为0
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            distances[u][v] = w;
            distances[v][u] = w;
        }
        floyd(distances, n);
        int idx = -1, minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = 0; j < n; ++j) {
                if (distances[i][j] <= distanceThreshold && i != j) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                idx = i;
            }
        }
        return idx;
    }


    void dijkstra(int[][] graph, int[] distances, boolean[] visited, int n, int distanceThreshold, int start) {
        distances[start] = 0; //自身到自身的距离为0
        for (int i = 0; i < n; ++i) {
            int u = -1, minDis = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && distances[j] < minDis) {
                    u = j;
                    minDis = distances[j];
                }
            }
            if (u == -1) {
                return; //所有点不可达
            }
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != Integer.MAX_VALUE) {
                    if (distances[u] + graph[u][v] < distances[v]) {
                        distances[v] = distances[u] + graph[u][v];
                    }
                }
            }
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //Djkstra
        //①Dijkstra处理的是带正权值的有权图，那么就需要一个二维数组（如果空间大用List数组）存储各个点到点之间边的权值大小
        int[][] graph = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        //初始化
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u][v] = graph[v][u] = w;
        }

        int idx = -1, minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] distances = new int[n];
            for (int j = 0; j < distances.length; j++) {
                distances[j] = Integer.MAX_VALUE;
            }
            //②需要一个boolean数组判断哪些点已经确定最短长度路径，那些点没有确定。用一个 int数组记录距离(在算法执行过程有些点最短路径可能被多次更新)。
            boolean[] visited = new boolean[n];
            for (int j = 0; j < visited.length; j++) {
                visited[j] = false;
            }
            dijkstra(graph, distances, visited, n, distanceThreshold, i);
            int count = 0; //小于等于距离阈值的城市个数
            for (int j = 0; j < n; j++) {
                if (distances[j] <= distanceThreshold && i != j) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                idx = i;
            }
        }
        return idx;
    }

    public int findTheCity3(int n, int[][] edges, int distanceThreshold) {
        int INF = 0x3f3f3f3f;
        int[][] dist = new int[n][n];
        for (int[] a : dist) {
            Arrays.fill(a, INF);
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int id = -1, minCnt = INF;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }
            if (cnt <= minCnt) {
                minCnt = cnt;
                id = i;
            }
        }
        return id;
    }

    private void Dijkstra2(Pair<Integer, Integer>[] graph, int[] distances, boolean[] visited, int n, int distanceThreshold, int start) {
        //}
        // void Dijkstra(vector<vector<pair<int, int>>>&graph, vector<int>& distances, vector<bool>& visited, int n, int distanceThreshold, int start) {
        distances[start] = 0; //自身到自身的距离为0
        for (int i = 0; i < n; ++i) {
            int u = -1, minDis = Integer.MAX_VALUE;
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && distances[j] < minDis) {
                    u = j;
                    minDis = distances[j];
                }
            }
            if (u == -1) {
                return; //所有点不可达
            }
            visited[u] = true;

            for (int j = 0; j < graph.length; ++j) {
                int v = graph[u].first;
                int w = graph[u].second;
                if (!visited[v]) {
                    if (distances[u] + w < distances[v]) {
                        distances[v] = distances[u] + w;
                    }
                }
            }
        }
    }

    public int findTheCity5(int n, int[][] edges, int distanceThreshold) {
        // int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        Pair<Integer, Integer>[] graph = new Pair[n];//Pair<int, int> pair1 = Tuples.pair("1", "Porsche");
        //vector<vector<pair<int, int>>>graph(n); //邻接表
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u] = Pair.of(v, w);
            graph[v] = Pair.of(u, w);
        }
        int idx = -1, minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {

            int[] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE); //单源最短路径数组
            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);

            Dijkstra2(graph, distances, visited, n, distanceThreshold, i);
            int count = 0; //小于等于距离阈值的城市个数
            for (int j = 0; j < n; ++j) {
                if (distances[j] <= distanceThreshold && i != j) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                idx = i;
            }
        }
        return idx;
    }

    /**
     * 执行用时：
     * 10 ms
     * , 在所有 Java 提交中击败了
     * 46.00%
     * 的用户
     * 内存消耗：
     * 42.5 MB
     * , 在所有 Java 提交中击败了
     * 8.00%
     * 的用户
     *
     * @param n
     * @param edges
     * @param distanceThreshold
     * @return
     */
    public int findTheCity6(int n, int[][] edges, int distanceThreshold) {
        // ①定义邻接矩阵graph，并初始化各个城市间距离为INT_MAX（无穷）
        int[][] graph = new int[n][n];
        for (int[] a : graph) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        // 根据edges[][]初始化graph[][]
        for (int[] edge : edges) {
            // 无向图两个城市间的两个方向距离相同
            graph[edge[0]][edge[1]] = graph[edge[1]][edge[0]] = edge[2];
        }

        //②使用 Floyd 算法求出各个城市到其它城市的距离，保存在矩阵 graph[n][n] 中。
        for (int k = 0; k < n; k++) {
            // n个顶点依次作为插入点
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        //③遍历 graph[n][n] ，统计各个城市在距离不超过 distanceThreshold  的情况下，能到达的其它城市的数量。
        // 选择出能到达其它城市最少的城市ret
        int ret = 0;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && graph[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }
            if (cnt <= minNum) {
                minNum = cnt;
                ret = i;
            }
        }
        return ret;
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size(), cnt = 0;
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            cnt++;
            for (int i : rooms.get(poll)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        return size == cnt;
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        int size = rooms.size();
        boolean[] visited = new boolean[size];
        visited[0] = true;
        dfs(rooms, visited, 0);
        return size == cnt;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int poll) {
        cnt++;
        for (int i : rooms.get(poll)) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(rooms, visited, i);
            }
        }
    }

    @Data
    class Node {
        int idx;
        int distance;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        public int getIdx() {
            return idx;
        }
    }
}
