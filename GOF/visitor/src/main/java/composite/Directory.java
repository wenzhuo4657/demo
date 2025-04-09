package composite;

import visitor.Visitor;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @className: Directory
 * @author: wenzhuo4657
 * @date: 2024/9/8 17:43
 * @Version: 1.0
 * @description:
 */
public class Directory extends Entry {
    List<Entry> entries;


    public Directory(String name,Directory ifparent,List<Entry> entries) throws FileExcetion {
        super(name,ifparent);
        this.entries = entries;
        if (!Objects.isNull(ifparent)){
            ifparent.add(this);
        }
    }

    @Override
    public Integer size() {
        this.size=0;
        Iterator<Entry> iterator = entries.iterator();
        while (iterator.hasNext()){
            Entry next = iterator.next();
            size+=next.size();
        }
        return size;
    }

    @Override
    public void printList() {

    }

    @Override
    public String getNow() {
        return "/"+name;
    }

    @Override
    public void add(Entry entry) throws FileExcetion {
        Entry ifparent1 = entry.ifparent;
        if (ifparent1!=null){
            ((Directory) ifparent1).entries.remove(entry);
        }
        entry.ifparent=this;
        entries.add(entry);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}