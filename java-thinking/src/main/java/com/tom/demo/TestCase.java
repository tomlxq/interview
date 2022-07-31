package com.tom.demo;


import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
class Solution {
    //上下左右
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {-1, 0}, {1, 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int cols = maze[0].length;
        int rows = maze.length;
        if (cols == 0) {
            return false;
        }
        if (rows == 0) {
            return false;
        }
        return bfs(maze, start, destination, rows, cols);
    }

    private boolean bfs(int[][] maze, int[] start, int[] destination, int rows, int cols) {
        //1.广度优先需要1个队列用于存下一次广播的点节，一个hash列表用来存访问的节点
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] curNode = queue.poll();
            int x = curNode[0];
            int y = curNode[1];
            if (destination[0] == x && destination[1] == y) {
                return true;
            }
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                //如果是空格，就要一直往前面走
                while (newX >= 0 && newX < rows & newY >= 0 && newY < cols && maze[newX][newY] == 0) {
                    newX += dir[0];
                    newY += dir[1];
                }
                //当为while时，说明当前节点是墙壁或超出边界，需要回退一步
                newX -= dir[0];
                newY -= dir[1];
                //如果这个停止点，没有被记问点，则加入队列，并设置为已访问节点
                if (!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return false;
    }

    /**
     * 题目：有一种简易压缩算法，针对全部为小写英文字母组成的字符串，将其中连续超过两个相同字母的部分压缩为连续个数加该字母，其他部分保持原样不变。例如字符串aaabbccccd 经过压缩变成字符串 3abb4cd。请您编写解压函数,根据输入的字符串,判断其是否为合法压缩过的字符串，若输入合法则输出解压缩后的字符串，否则输出字符串"!error"来报告错误
     * <p>
     * 输入描述
     * 输入一行，为一个ASCII字符串，长度不超过100字符
     * 用例保证输出的字符串长度也不会超过100字符串
     * <p>
     * 输出描述
     * 若判断输入为合法的经过压缩后的字符串，则输出压缩前的字符串
     * 若输入不合法 则输出字符串"!error"
     *
     * @param s
     * @return
     */
    public String decompressString3(String s) {
        //1.先对不符合的字符串进行判断返!error 以数据开头的
        // /^[0-9a-z]+/ 匹配非0-9，a-z的非法字符
        // /[0-9]([a-z])\1/ 3aa
        // /([a-z])\1{2,} aaa
        // /[0-9]+$/ 匹配以数据结尾的情况
        if (find(s, "[^0-9a-z]+") || find(s, "[0-9]([a-z])\\1") || find(s, "([a-z])\\1{2,}") || find(s, "[0-9]+$")) {
            return "!error";
        }
        char[] chars = s.toCharArray();
        int start = 0, len = chars.length;
        StringBuffer sb = new StringBuffer();
        //2.循环字符串，如是字母则放在新字串里，若非字母，则记录当前read值为start，循环至非字符时结束,接取从start-read的字符串解析出来，表标循环的次，将后面一位的字符写入
        for (int read = 0; read < len; read++) {
            if (Character.isLetter(s.charAt(read))) {
                sb.append(s.charAt(read));
            } else {
                start = read;
                while (Character.isDigit(++read)) {
                }
                int n = Integer.parseInt(s.substring(start, read));
                //基本执行不到 2aa
                if (n == 2) {
                    return "!error";
                }
                for (int i = 0; i < n; i++) {
                    sb.append(s.charAt(read));
                }
            }
        }
        return sb.toString();
    }

    private boolean find(String s, String regex) {
        return Pattern.compile(regex).matcher(s).find();
    }

    /**
     * 特定大小的停车场，数组cars[ ]表示，其中1代表有车，0代表无车，车辆大小不一，统计停车场最少可以停多少辆车，返回具体的数字。长度小于1000
     * 输入：小车占一个车位（长度1），中车占两个车位（长度2），大车占三个车位（长度3）
     * 输出：整形数字字符串，表示最少停车数目
     * eg:
     * 输入：1，1，0，0，1，1，1，0，1
     * 输出：3
     * 输入：1,0,1
     * 输出：2
     */
    public int sumStopBus1(char[] chars) {
        char[] c = String.valueOf(chars).replaceAll("111", "3").replaceAll("11", "2").toCharArray();
        return (int) IntStream.range(0, c.length).map(i -> c[i]).filter(i -> i != '0').count();
        /*int count = 0;
        for (char i : c) {
            if (i == '3' || i == '2' || i == '1') {
                count++;
            }
        }
        return count;*/
    }

    public int sumStopBus(char[] chars) {
        int left = 0, len = chars.length;
        int total = 0;
        for (int read = 0; read < len; read++) {
            if (read == len - 1 || chars[read] != chars[read + 1]) {
                if (chars[read] == '0') {
                    left = read + 1;
                    continue;
                }
                int num = read - left + 1;
                int big = num / 3;
                int mid = (num - big * 3) / 2;
                int small = num - big * 3 - mid * 2;
                total += (big + mid + small);
                left = read + 1;
            }
        }
        return total;
    }

    public String compressString2(String s) {
        //利用双指针 i,j分别指向首字母，j表示相同字段长度
        // 当i小于总长度时，进行循环，相同字符j进行叠加，直到遇到不同
        //在java中不能用String为不可变对应，每次需要叠加
        StringBuffer res = new StringBuffer();
        int i = 0, j = 0, len = s.length();
        while (i < len) {
            while (j < len && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            res.append(s.charAt(i));
            res.append(j - i);
            i = j;
        }
        return res.toString().length() >= len ? s : res.toString();
    }

    public String compressString(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int len = chars.length;
        StringBuffer sb = new StringBuffer();
        for (int read = 0; read < len; read++) {
            if (read == len - 1 || chars[read] != chars[read + 1]) {
                sb.append(chars[read]);
                int num = read - left + 1;
                sb.append(num);
                left = read + 1;
            }
        }
        return sb.toString().length() >= s.length() ? s : sb.toString();
    }

    public int[] decompressRLElist(int[] nums) {
        int count = IntStream.range(0, nums.length).filter(i -> i % 2 == 0).map(i -> nums[i]).sum();
        int[] res = new int[count];
        int idx = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                res[idx++] = nums[i + 1];
            }
        }
        return res;
    }

    public int lastRemaining5(int n, int m) {
        int value = 0;
        for (int i = 1; i <= n; i++) {
            value = (value + m) % i;
        }
        return value;
    }

    public int lastRemaining4(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (lastRemaining4(n - 1, m) + m) % n;
    }

    public int lastRemaining3(int n, int m) {
        if (m == 1) {
            return n - 1;
        }
        List<Integer> list = IntStream.range(0, n).boxed().collect(Collectors.toList());
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % (list.size());
            list.remove(index);
        }
        return list.get(0);
    }


    public int lastRemaining2(int n, int m) {
        //1.若m=1,则返回n节点的数字
        //2.模拟链表，首尾相接
        //3.设置报数为index,依次遍历至到m时，进行删除操作
        if (m == 1) {
            return n - 1;
        }
        SimpleNode head = new SimpleNode(0);
        SimpleNode team = head;
        for (int i = 1; i < n; i++) {
            team.next = new SimpleNode(i);
            team = team.next;
        }
        //首尾相接
        team.next = head;
        int index = 0;
        //int len=n;
        //3.设置报数为index初始值0,
        //4.当有多余的节点时
        // ①依次遍历至到m-2时，进行后一个节点删除操作，将报数归0
        // ②否则报数index+1
        // ③将下一个节点给当前节点，继续遍历
        while (head.next != head) {
            //若m远大于n,会导致多次转圈，造成时间超时，此时间  (m-2)%n 为实际次数，找到删除节点的前一个元素，len-1
            if (index == (m - 2) % n) {
                head.next = head.next.next;
                index = 0;
                n--;
            } else {
                index++;
            }
            head = head.next;
        }
        return head.val;
    }

    public int lastRemaining(int n, int m) {
        //1.若m=1,则返回n节点的数字
        //2.模拟链表，首尾相接
        //3.设置报数为index,依次遍历至到m时，进行删除操作
        if (m == 1) {
            return n - 1;
        }
        SimpleNode head = new SimpleNode(0);
        SimpleNode team = head;
        for (int i = 1; i < n; i++) {
            team.next = new SimpleNode(i);
            team = team.next;
        }
        //首尾相接
        team.next = head;
        int index = 0;
        //4.设置报数为index初始值0,
        //5.当有多余的节点时
        // ①依次遍历至到m-2时，进行后一个节点删除操作，将报数归0
        // ②否则报数index+1
        // ③将下一个节点给当前节点，继续遍历
        while (head.next != head) {
            if (index == m - 2) {
                head.next = head.next.next;
                index = 0;
            } else {
                index++;
            }
            head = head.next;
        }
        return head.val;
    }

    public int compress(char[] chars) {
        int len = chars.length;
        //1.定义三个变量分别为read位，write位，最左边left位为上一次不重复位置,初始均为0
        //2.仅当读指针等于最长字符n-1或当前字符与下一字符不一样时才写入
        //3.字母后面的长度num确定read-left+1,当
        //①num若位数为1，且为1，不占用write位
        //②否则，将写入num，依次占用写入位write
        int write = 0, left = 0;
        for (int read = 0; read < len; read++) {
            if (read == len - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    char[] numChars = String.valueOf(num).toCharArray();
                    for (char c : numChars) {
                        chars[write++] = c;
                    }
                }
                //write要点用的位数 507    7 0 5
                left = read + 1;
            }
        }
        log.info("{} {}", chars, write);
        return write;
    }

    public int computeArea2(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a = area(ax1, ay1, ax2, ay2);
        int b = area(bx1, by1, bx2, by2);
        int c = area(Math.max(ax1, bx1), Math.max(ay1, by1), Math.min(ax2, bx2), Math.min(ay2, by2));
        return a + b - c;
    }

    private int area(int x1, int y1, int x2, int y2) {
        if (x2 <= x1 || y2 <= y1) {
            return 0;
        }
        return (x2 - x1) * (y2 - y1);
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a = (ax2 - ax1) * (ay2 - ay1);
        int b = (bx2 - bx1) * (by2 - by1);
        int c = (Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1))) * (Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1)));
        return a + b - c;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        //1.wordList放在hash表中wordSet，并且判断是否为空
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        //2.建立三个hash表，1个用于begin的Hash列表，1个用end的Hash列表，1个用于标识访问的hash列表visitSet
        HashSet<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        HashSet<String> endSet = new HashSet<>();
        endSet.add(endWord);
        HashSet<String> visitSet = new HashSet<>();
        visitSet.add(beginWord);
        int step = 1;
        //3.操作过程：
        // ①首先判断beginSet,endSet不为空
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // ②考虑小的hash表作为扩展, beginSet,endSet大小比较，小于用于扩散的计算,考虑的情况更少
            if (beginSet.size() > endSet.size()) {
                HashSet temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            // ③循环遍历beginSet,针对每个单词的位置，用26个字每替换，若原本字母，则进行下一个循环
            HashSet<String> nextLevelVisits = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char originalChar = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (originalChar == j) {
                            continue;
                        }
                        chars[i] = j;
                        String nextWord = String.valueOf(chars);
                        // ④判断在wordSet存在
                        if (wordSet.contains(nextWord)) {
                            // ⑥判断在endSet存在，则返回step+1
                            if (endSet.contains(nextWord)) {
                                return step + 1;
                            }
                            // ⑥否则判断在visitSet不存在，则beginSet加入单词，visitSet加入单词
                            if (!visitSet.contains(nextWord)) {
                                nextLevelVisits.add(nextWord);
                                visitSet.add(nextWord);
                            }
                        }
                    }
                    // ⑦灰复单词，继续对剩下的位置处理
                    chars[i] = originalChar;
                }
            }
            // ⑧处理beginSet所有单词，step+1，继续下一软循环
            beginSet = nextLevelVisits;
            step++;
        }
        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //1.把List转化成hash表并判断是否为空
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0) {
            return 0;
        }
        wordSet.remove(beginWord);
        //2.广度优先算法，要有一个队列、一个访问标记hash列表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        HashSet<String> visited = new HashSet<>();
        //visited.add(beginWord);
        //广度优先算法第一层扩散为1
        int step = 1;
        //3.循环队列，并取个单词，把A-Z替换单词位置
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int k = 0; k < n; k++) {
                String curWord = queue.poll();
                char[] curChars = curWord.toCharArray();
                for (int i = 0; i < endWord.length(); i++) {
                    //对单词的每个位置进行a-z的替换
                    char originChar = curChars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        //不是单词本身，继续循环
                        if (originChar == j) {
                            continue;
                        }
                        curChars[i] = j;
                        //被替了的新单词
                        String newWord = String.valueOf(curChars);
                        //若单词在hash表
                        if (wordSet.contains(newWord)) {
                            //若刚好为结束单词，则返加扩展+1, 直接返回
                            if (newWord.equals(endWord)) {
                                return step + 1;
                            }
                            //否则判断是否在被访问标记hash表中，不在的话，将单词加到队列中，并把单词标记为已访问
                            if (!visited.contains(newWord)) {
                                queue.add(newWord);
                                visited.add(newWord);
                            }
                        }
                        //恢复原始单词
                        curChars[i] = originChar;
                    }

                }
            }
            //处理完成后，水波纹扩展1
            step++;
        }
        return 0;
    }

    public boolean checkRecord1(String s) {
        int n = s.length();
        int aCount = 0;
        boolean ret1 = true;
        boolean ret2 = true;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //按 总出勤 计，学生缺勤（'A'）严格 少于两天
            if (c == 'A') {
                aCount++;
            }
            if (aCount > 1) {
                ret1 = false;
                //break;
            }
            //学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
            if (c == 'L') {
                if (i + 2 < n && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                    ret2 = false;
                    //break;
                }
            }
        }
        return ret1 && ret2;
    }

    public boolean checkRecord2(String s) {
        int n = s.length();
        int absent = 0;
        int late = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //按 总出勤 计，学生缺勤（'A'）严格 少于两天
            if (c == 'A') {
                absent++;
                if (absent > 1) {
                    return false;
                }
            }

            //学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
            if (c == 'L') {
                late++;
                if (late > 2) {
                    return false;
                }
            } else {
                late = 0;
            }
        }
        return true;
    }

    public boolean checkRecord3(String s) {
        return !s.contains("LLL") && s.indexOf('A') == s.lastIndexOf('A');
    }

    /**
     * 例如，
     * 0、1、2、3、4这5个数字组成一个圆圈，
     * 从数字0开始每次删除第3个数字，
     * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     * 0、1、2、3、4 删第三个数 m=3 index=1 因下一个数要删除
     * 3、4，0，1 删第三个数 m=3 index=1 因下一个数要删除
     * 1 3 4 删第三个数 m=3 index=1 因下一个数要删除
     * 1 3 删第三个数 m=3 index=1 因下一个数要删除
     * 3 删第三个数 m=3 index=1 因下一个数要删除
     */
    class SimpleNode {
        int val;
        SimpleNode next;

        public SimpleNode(int val) {
            this.val = val;
        }
    }
}