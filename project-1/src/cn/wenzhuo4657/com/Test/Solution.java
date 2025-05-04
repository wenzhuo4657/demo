package cn.wenzhuo4657.com.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @className: test
 * @author: wenzhuo4657
 * @date: 2024/6/16 18:45
 * @Version: 1.0
 * @description:
 */
public class Solution {
    // 字符串长度最大，且要求不能是对方的子序列，所以其校验需要得到对方子串的最大序列，可以采用字符串哈希的做法，由于涉及到大量字符串比对
    // 很显然，需要将不同长度的子串分割开来，且不需要将两个字符串都加载出来，仅加载一个，同等长度下，只要找不到相等长度的字符串哈希，就可以返回
    HashMap col=new HashMap<Integer, Set>();
    char []  arr;
    int base=499;
    public int findLUSlength(String a, String b) {
        // 由于是删除任意长度的字符串，对应到字符串哈希中，即是不同数字的组合，涉及到选择问题，
        arr=a.toCharArray();
        for(int i=1;i<=a.length();i++){
            HashSet set=new HashSet();
            col.put(i,set);
            dfs(0,i,0L,set);
        }
        arr=b.toCharArray();
        for(int i=b.length();i>0;i--){
            if(sfb(0,i,0L,(HashSet)col.get(i))){
                return i;
            }

        }

        return -1;



    }
    public void dfs(int index,int target,long num,HashSet set){
        if(target==0&&num!=0){
            set.add(num);
            return;
        }
        if(index<arr.length){
            num=num+499*(arr[index]-'a'+1);
            dfs(index+1,target-1,num,set);
            dfs(index+1,target,num,set);
        }

    }

    public boolean sfb(int index,int target,long num,HashSet set){
        if(target==0&&num!=0){
            if(!set.contains(num)){
                return true;
            }
        }
        if(index<arr.length){
            num=num+499*(arr[index]-'a'+1);
            if( sfb(index+1,target-1,num,set) ){
                return true;
            }
            if( sfb(index+1,target,num,set)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findLUSlength("aba","cbc");
    }
}