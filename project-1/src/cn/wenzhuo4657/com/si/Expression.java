package cn.wenzhuo4657.com.si;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static cn.wenzhuo4657.com.si.StackArray_plus.OperatorLevel;

public class Expression {
    String s;//储存表达式的字符串
    int i;
    /*
    * 表示s存储的字符串是何种表达式
    * 0：前缀表达式
    * 1：中缀表达式
    * 2：后缀表达式
    * */
    List<String>  u=new ArrayList<>();//分割字符串s的链表


    public Expression(String s, int i) {
        this.s = s;
        this.i = i;
    }

    /*
     * @Author wenzhuo4657
     * @Description
     * @Date
     * @Param
     * @return
     **/
    public   int Compute_2(){


        Stack_Array t=new Stack_Array(10);
        for (String i:u){
            if (i.matches("\\d+")){//正则表达式：判断字符串数据i是否为一个多位数
                t.push(Integer.parseInt(i));
            }else {
                int num1=t.pop();
                int num2=t.pop();
                int res=0;
                switch (i.charAt(0)){
                    case '+':res=num1+num2;break;
                    case '-':res=num2-num1;break;
                    case '*':res=num1*num2;break;
                    case '/':res=num2/num1;break;
                    default:throw new RuntimeException("计算逆波兰表达式时出现了不能解析的运算符");
                }
                t.push(res);
            }

        }
        return t.pop();
    }


    /*
     * @Author wenzhuo4657
     * @Description  传入一个逆波兰表达式，返回一个根据空格字符串将其分割进行存储的Arraylist链表
     * @Date
     * @Param
     * s:一个逆波兰表达式
     * @return 将表达式中每个元素依次存储的链表
     **/

    public   void split_2(){
        String[] a=s.split(" ");
        for (String i:a){
            u.add(i);
        }

    }
    /*
     * @Author wenzhuo4657
     * @Description  将存入中缀表达式的字符串按一定规则转入Arraylist链表中
     * @Date
     * @Param
     * @return
     **/
    public  void split_1(){
        int i=0;
        String str=" ";
        char a=' ';
        do {
            if ((a=s.charAt(i))<48||a>57){
                u.add(a+"");
                i++;
            }else {
                str="";
                //此时表示需要存入的是一个数字，且不确定是否为一个多位数
                while (i<s.length()&&(a=s.charAt(i))>=48&&a<=57){
                    i++;
                    str+=a;
                }
                u.add(str);
            }

        }while (i<s.length());

    }

    /*
     * @Author wenzhuo4657
     * @Description  将中缀表达分割得到的list，转换为后缀表达式的list，
     * 也就是改变改变u链表
     * @Date
     * @Param
     * @return
     **/
    public  void Conversion(){
        Stack_Array temp=new Stack_Array(10);//临时符号栈
        List<String> u1=new ArrayList<>();
        for (String a:u){
            if (a.matches("\\d+")){//正则表达式，如果a是一个数，返回true
                u1.add(a);
            }else if (a.equals("(")){
                temp.push(a.charAt(0));
            }else if (a.equals(")")){
                while (!temp.isEmpty()&&temp.View()!='(' ){
                    u1.add((char)temp.pop()+"");
                }
                temp.pop();
            }else {
                while (!temp.isEmpty()&&OperatorLevel(a.charAt(0))<=OperatorLevel(temp.View())&&(char)temp.View()!='('){
                    u1.add((char)temp.pop()+"");
                }
                //注意：此时判断运算符优先级的函数无法判断"("和“）”，可进行优化
                //问题：会导致将这两个运算符添加到u1中，
                temp.push(a.charAt(0));

            }

        }

        while (!temp.isEmpty()){
            u1.add((char)temp.pop()+"");
        }
        u=u1;

    }

    public  void ShowType (){
        switch (i){
            case 0: System.out.println("字符串存储的是前缀表达式");break;
            case 1: System.out.println("字符串存储的是中缀表达式");break;
            case 2: System.out.println("字符串存储的是后缀表达式");break;
            default:
                System.out.println("类型变量出现未知错误");
        }
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public List<String> getU() {
        return u;
    }

    public void setU(List<String> u) {
        this.u = u;
    }
}


class Main{
    public static void main(String[] args) {
        Expression hid=new Expression("1+4-5*1+(5+1*12)",1);
        hid.split_1();
        System.out.println(hid.getU());
        hid.Conversion();
        System.out.println("_____________");
        System.out.println(hid.getU());
        System.out.println("_____________");
        System.out.println(hid.Compute_2());
    }
}



