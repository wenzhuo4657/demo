package composite;


import visitor.Visitor;

/**
 * @className: Element
 * @author: wenzhuo4657
 * @date: 2024/9/11 20:05
 * @Version: 1.0
 * @description:
 */
public interface Element {
    public  abstract  void accept(Visitor v);
}