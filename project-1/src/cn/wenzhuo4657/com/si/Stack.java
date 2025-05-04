package cn.wenzhuo4657.com.si;

public class Stack {
    public static void main(String[] args) {
       String s="50+4*12-1";
       StackArray_plus c=new StackArray_plus(10);
       c.start(s);


    }
}


/*
*
* 数组实现栈
* */

class  Stack_Array{
    private  int max;//表示栈的的最大内存数量
    private  int [] stacks;
    private  int top=-1;//表示栈顶

    public Stack_Array(int max) {
        if (max<1){
            throw new RuntimeException("栈的初始化出错");
        }
        this.max = max;
        stacks =new int[this.max];
    }
 /*
  * @Author wenzhuo4657
  * @Description 判断栈是否满了
  * @Date
  * @Param
  * @return true或false
  **/
    public  boolean isFull(){
        return  top==max-1;
    }
/*
 * @Author wenzhuo4657
 * @Description  判断栈是否为空
 * @Date
 * @Param
 * @return true或false
 **/

    public boolean isEmpty(){
        return  top==-1;
    }
    /*
     * @Author wenzhuo4657
     * @Description  入栈
     * @Date
     * @Param n表示入栈成员
     * @return
     **/

    public void push(int n){
        if (isFull()){
            throw new RuntimeException("该栈已经满了，不能继续入栈");
        }
        top++;
        stacks[top]=n;
    }

    public  int  pop(){
        int n;
        if (isEmpty()){
            throw new RuntimeException("该栈已经为空，不能继续出栈");
        }
        n=stacks[top];
        top--;
        return  n;
    }
    public  int View(){
        int n;
        if (isEmpty()){
            throw new RuntimeException("该栈已经为空，不能继续出栈");
        }
        n=stacks[top];
        return  n;

    }


    /*
     * @Author wenzhuo4657
     * @Description  打印栈，遵循FLIO原则
     * @Date
     * @Param
     * @return
     **/
    public  void print(){
        if (isEmpty()){
            throw new RuntimeException("该栈为空，无法进行打印");
        }
        int top1=top;

        while (true){
            if (isEmpty()){
                break;
            }
            System.out.printf(" stacks[%d]=%d\n",top,stacks[top]);
            top--;

        }
        top=top1;
    }

}


class  StackArray_plus  extends  Stack_Array{


    public StackArray_plus(int max) {
        super(max);
    }


    /*

    计算器实现思路分析(仅支持十位以内的计算)
    1.将字符串中的数字和二元运算符分别存入两个栈中
    2.在存入过程中进行运算，
    （1）假定当前运算符的优先级小于或等于上一个运算符的优先级，
    则将第一个运算符和两个数的从对应栈中取出进行运算，并将计算结果和当前运算符存入对应栈中
    （2）假定当前存入运算符的优先级大于上一个运算符，则直接存入
    3.当字符串下一个位置没有运算符时，将数字和运算符取出进行运算，
    4.当栈中只剩一个数字时，运算结束
    相关方法的：
    1.给定两个数和一个运算符进行运算
     2.判断一个字符是数字还是运算符
     3.返回运算符的优先级（自定义）
    * */

/*
 * @Author wenzhuo4657
 * @Description  返回0或1，表示运算符的优先级。且需要注意的是，该方法只能判断加减乘除运算符
 * 传入其他运算符不会报错，返回0
 * @Date
 * @Param
 * @return
 **/
    public  static   int OperatorLevel(int a){
        if (a=='/'||a=='*'){
            return 1;
        }else {
            return 0;
        }
    }

    public boolean isNumber(int a){
        if ( !(a=='+'||a=='-'||a=='*'||a=='/') ){
            return true;
        } else {
          return false;
        }
    }

    public int Compute(int b1,int b2,int $){
        switch ($){
            case '+':return b1+b2;
            case '-':return b2-b1;
            case '*':return b1*b2;
            case '/':return b2/b1;
            default: throw new RuntimeException("计算器中输入流非法运算符");
        }

    }


    private Stack_Array Stack_number=new Stack_Array(20);
    private  Stack_Array Stack_operator=new Stack_Array(20);


    public  void start(String s){
        int num1;
        int num2;
        int operator=' ';//将要存入的运算符
        int index=0;//表示扫描到字符串数组的哪个位置
        int res;//表示计算结果
        char[] arr=s.toCharArray();
        while (true){

                if (isNumber(arr[index])) {
                    System.out.printf("arr[%d]=%c\n", index, arr[index]);
                    int temp = index;
                    int ex = 0;
                    while (temp < arr.length && isNumber(arr[temp])) {
                        ex = ex * 10 + Character.getNumericValue(arr[temp]);
                        temp++;
                    }
                    index = temp - 1;
                    Stack_number.push(ex);
                } else {

                operator=arr[index];
                if (Stack_operator.isEmpty()){
                    Stack_operator.push(operator);
                }else if (OperatorLevel(Stack_operator.View())>=OperatorLevel(operator)){
//                    这里的运算符优先级保证了*号一定优先计算，也就说，如果第一个入栈的运算符是*号，
//                    我们在入栈第二个运算符会优先计算乘号，如果第二个运算符是*号，我们会先将运算符入栈，等下一次入栈的时候进行计算
//                    其实现效果为，一般情况下，存储栈中一定会有一个运算符，乘号在栈中和加号在栈中一样，都会在第二个运算符入栈时被计算、出栈，
//                    不同的是，如果乘号在第二个入栈的位置，则会直接入栈，等待下一次计算，也就是乘号运算符比加号运算符优先计算
                    num1= Stack_number.pop();
                    num2= Stack_number.pop();
                    res=Compute(num1,num2, Stack_operator.pop());
                    Stack_operator.push(operator);
                    Stack_number.push(res);
                    System.out.println("res="+res+",num1="+num1+",num2="+num2+"\n");
                }else{
                    Stack_operator.push(operator);
                }
            }
            index++;
            if (index>= arr.length){
                while (true){
//                    到该操作时，仅仅保证运算符栈中顺序和计算顺序一致，可以直接出栈，此时栈中可以有很多运算符
                    if (Stack_operator.isEmpty()){
                        System.out.printf("%s=%d",s,Stack_number.pop());
                        break;
                    }
                    num1=Stack_number.pop();
                    num2=Stack_number.pop();
                    res=Compute(num1,num2,Stack_operator.pop());
                    System.out.println("res="+res+",num1="+num1+",num2="+num2+"\n");
                    Stack_number.push(res);
                }
                break;
            }
        }




    }




}
