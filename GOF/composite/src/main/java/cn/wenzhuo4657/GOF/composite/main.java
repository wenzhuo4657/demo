package cn.wenzhuo4657.GOF.composite;

import java.util.ArrayList;

/**
 * @className: main
 * @author: wenzhuo4657
 * @date: 2024/9/8 18:08
 * @Version: 1.0
 * @description:
 * 创建文件或者目录时必须指明地址，意味着添加文件，
 * 而add实际上是移动文件到另一个目录，
 */
public class main {
    public static void main(String[] args) throws FileExcetion {
        Directory directory=new Directory("root",null,new ArrayList<>());
        File file = new File("filx.txt", 100, directory);
        String path = file.getPath(file);
        System.out.println(path);
        Directory directory1=new Directory("etc",directory,new ArrayList<>());
        File file1 = new File("file.txt", 100, directory1);
        directory1.add(file);
        path = file.getPath(file);
        System.out.println(path);
        String path1 = file1.getPath(file1);
        System.out.println(path1);
    }
}