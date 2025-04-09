package cn.wenzhuo4657.GOF.composite;

/**
 * @className: File
 * @author: wenzhuo4657
 * @date: 2024/9/8 17:41
 * @Version: 1.0
 * @description:
 */
public class File extends Entry{
    public File(String name, Integer size, Entry ifparent) throws FileExcetion {
        super(name,  ifparent);
        this.size=size;
        ifparent.add(this);
    }



    @Override
    public Integer size() {
        return this.size;
    }

    @Override
    public void printList() {
        System.out.println("/"+name+"/t"+size);
    }

    @Override
    public String getNow() {
        return "/"+name;
    }


}