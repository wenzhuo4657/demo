package visitor;

import composite.Directory;
import composite.File;

/**
 * @className: visitor
 * @author: wenzhuo4657
 * @date: 2024/9/11 20:06
 * @Version: 1.0
 * @description:
 */
public abstract class Visitor {
    public  abstract  void visit(File file);
    public  abstract  void visit(Directory directory);
}