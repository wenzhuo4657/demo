package cn.wenzhuo4657.com.Union_find;

/**
 * @className: arithmetic02
 * @author: wenzhuo4657
 * @date: 2024/6/3 12:52
 * @Version: 1.0
 * @description:  情侣座问题，默认了最优解决换座方式，即设定情侣座，具有一定相关性情侣号记录在同个集合内，交换次序刚好为情侣对数-1
 * 问题的关键恰好在于观察到这一点，因此可用并查集解决，因为其问题的变为合并情侣对，查看有哪些情侣掺杂在一起，
 * 对于给定数据仅仅用于判断合并哪些情侣对。
 * 测试链接 : https://leetcode.cn/problems/couples-holding-hands/
 */
public class arithmetic02 {
    public static int MAXN = 31;

    public static int[] father = new int[MAXN];

    public static int sets;

    public static void build(int m) {
        for (int i = 0; i < m; i++) {
            father[i] = i;
        }
        sets = m;
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

    public static int min(int[] row) {
        int n=row.length;
        build(n);
        for (int i=0;i<n;i+=2){
            union(row[i]/2,row[i+1]/2);
        }
        return n/2-sets;

    }

}