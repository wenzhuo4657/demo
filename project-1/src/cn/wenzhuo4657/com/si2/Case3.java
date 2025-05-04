package cn.wenzhuo4657.com.si2;

public class Case3 {
    public static void main(String[] args) {
        TowerofHanoi(5,'a','b','c');

    }
/*
 * @Author wenzhuo4657
 * @Description
 * num 当前盘子数量
 * a:当前盘子位置
 * b：暂时搁置盘子的位置
 * c：需要将盘子移向的位置
 *
 * 递归的重复操：将两个圆盘通过中转位置放置到目标位置
 * 三种位置互换的规则：
 * 重点在于，三种位置的选取，即汉诺塔游戏的规则，大块不能放置到小块上，
 * @return
 **/
    public static void  TowerofHanoi(int num,char a,char b,char c){
        if (num==1){
            System.out.println(num+":"+a+"=>"+c);
        }else {
            TowerofHanoi(num-1,a,c,b);
            System.out.println(num+":"+a+"=>"+c);
            TowerofHanoi(num-1,b,a,c);
        }

    }
}
