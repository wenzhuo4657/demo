package cn.wenzhuo4657.com.si2;

public class Case2 {
    public static void main(String[] args) {
        i i1=new i();
        i1.Find(0);
        System.out.println("");
        System.out.println("共有"+i1.cons+"种解决方案");

    }

}
/*
* 八皇后问题的解决
* */
class i{
    int[] a=new int[8];
    int max=8;

     int cons=0;

    /*
     * @Author wenzhuo4657
     * @Description  判断将要添加进的皇后是否会与添加的皇后冲突
     * @Date
     * @Param
     * @return
     **/
    public  boolean isPeace(int n){
            for (int i=0;i<n;i++){
                if (a[i]==a[n]||Math.abs(n-i)==Math.abs(a[i]-a[n])){
                    return false;
                }
            }
        return true;
    }

    public  void Find(int n){
        if (n==max){
            cons++;
            print(a);
            return;
        }
        for (int i=0;i<max;i++){
            a[n]=i;
            if (isPeace(n)){
                Find(n+1);
            }
        }
    }

    public  void print(int[] m ){
        for (int i=0;i<m.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }

}
