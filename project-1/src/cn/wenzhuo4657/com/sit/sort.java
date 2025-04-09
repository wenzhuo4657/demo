package cn.wenzhuo4657.com.sit;

import java.io.*;
import java.util.ArrayList;

public class sort {
    public static void main(String[] args) throws IOException {
        File  file=new File("D:\\学习\\编译\\idea——java\\project-1\\src\\cn.wenzhuo4657.com\\sit\\stu.txt");
        file.createNewFile();
        FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line;
        ArrayList<stu> arrayList=new ArrayList<>();
        while ((line=bufferedReader.readLine())!=null ){
            arrayList.add(parse(line));
        }
        printStus(arrayList);
        System.out.println("================");
//        2,姓名递增，递增规则为：首字符编码比较
        System.out.println("姓名递增，递增规则为：首字符编码比较");
        shellsort(arrayList);
        printStus(arrayList);

        System.out.println("=======");
//        3，得到前k个学生并根据成绩进行排序
        System.out.println("得到前k个学生并根据成绩进行排序");
        ArrayList<stu> stus1=new ArrayList<>(arrayList.subList(0,3));
        shellsort_plus(stus1);
        printStus(stus1);
        System.out.println("最高成绩为"+stus1.get(0).sore);
        System.out.println("=========");
//        4,对整体进行排序，得到成绩排名为第k的学生
        System.out.println("对整体进行排序，得到成绩排名为第3的学生");
        shellsort_plus(arrayList);
        System.out.println("成绩排名为第k的学生");
        System.out.println(arrayList.get(3));






        fileReader.close();

    }

    public  static  stu parse(String stu){
        String[]  args=stu.split(" ");

        stu stu1=new stu(Integer.parseInt(args[0]),args[1],Integer.parseInt(args[2]));
        return  stu1;
    }


    public  static  void shellsort(ArrayList<stu> stus){
        int h=stus.size();
        while (true){
            h=h/2;
            if (h<=0){
                break;
            }
            for(int i=0; i<stus.size();i++){
                int j=i;
                stu m=stus.get(j);
                while(j-h>=0&&is(m.name,stus.get(j-h).name)){
                    //交换位置
                    stus.set(j,stus.get(j-h));
                    j-=h;
                }
                stus.set(j,m);
            }
        }
    }

    public  static  void shellsort_plus(ArrayList<stu> stus){
        int h=stus.size();
        while (true){
            h=h/2;
            if (h<=0){
                break;
            }
            for(int i=0; i<stus.size();i++){
                int j=i;
                stu m=stus.get(j);
                while(j-h>=0&&m.sore>stus.get(j-h).sore){
                    //交换位置
                    stus.set(j,stus.get(j-h));
                    j-=h;
                }
                stus.set(j,m);
            }
        }
    }

    public static  boolean is(String name1,String name2){
        char na1=name1.charAt(0);
        char na2=name2.charAt(0);
        if(na2>na1){
            return true;
        }else{
            return  false;
        }
    }


    public static  void printStus(ArrayList<stu> stus){
        for(stu stu: stus ){
            System.out.println(stu.toString());
        }
    }
}

class   stu{
    int id;
    String name;
    int sore;

    public stu(int id, String name, int sore) {
        this.id = id;
        this.name = name;
        this.sore = sore;
    }

    @Override
    public String toString() {
        return "stu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sore='" + sore + '\'' +
                '}';
    }
}
