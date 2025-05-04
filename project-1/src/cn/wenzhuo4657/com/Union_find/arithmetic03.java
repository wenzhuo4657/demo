package cn.wenzhuo4657.com.Union_find;

import java.util.HashMap;

/**
 * @className: arithmetic03
 * @author: wenzhuo4657
 * @date: 2024/6/3 14:00
 * @Version: 1.0
 * @description:
 * 测试链接 : https://leetcode.cn/problems/most-stones-removed-with-same-row-or-column/
 * 重点在于意识到构成集合也就是可通过行、列连接在一起的石头组合，可以沿着边缘消灭到一个。其结果页被优化为石头总数量-集合数量
 */
public class arithmetic03 {
    // key : 某行
    // value : 第一次遇到的石头编号
    public static HashMap<Integer, Integer> rowFirst = new HashMap<Integer, Integer>();

    public static HashMap<Integer, Integer> colFirst = new HashMap<Integer, Integer>();

    public static int MAXN = 1001;

    public static int[] father = new int[MAXN];

    public static int sets;

    public static void build(int n) {
        rowFirst.clear();
        colFirst.clear();
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        sets = n;
    }

    public static int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    public static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            father[fx] = fy;
            sets--;
        }
    }

    public static int removeStones(int[][] stones) {
        int n = stones.length;
        build(n);
        for (int i = 0; i < n; i++) {
            int row = stones[i][0];
            int col = stones[i][1];
            if (!rowFirst.containsKey(row)) {
                rowFirst.put(row, i);
            } else {
                union(i, rowFirst.get(row));
            }
            if (!colFirst.containsKey(col)) {
                colFirst.put(col, i);
            } else {
                union(i, colFirst.get(col));
            }
        }
        return n - sets;
    }

}