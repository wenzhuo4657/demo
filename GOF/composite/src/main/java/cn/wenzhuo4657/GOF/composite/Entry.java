package cn.wenzhuo4657.GOF.composite;

import java.util.Objects;

/**
 * @className: Entry
 * @author: wenzhuo4657
 * @date: 2024/9/8 17:32
 * @Version: 1.0
 * @description:
 */
public abstract class Entry {
    public String name;
    public  Integer size;
    public Entry ifparent;

    public Entry(String name, Entry ifparent) {
        this.name = name;
        this.ifparent = ifparent;
    }

    public Entry(String name) {
        this.name = name;

    }

    public  void add(Entry entry) throws FileExcetion {
        throw  new FileExcetion();
    }

    public abstract Integer size();

    public abstract void printList();

    public abstract  String getNow();
    public  String getPath(Entry entry){
        if (!Objects.isNull(entry.ifparent)){
            return getPath(entry.ifparent)+entry.getNow();
        }
        return entry.getNow();
    };


}