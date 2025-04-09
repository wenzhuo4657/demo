package visitor;

import composite.Directory;
import composite.File;

/**
 * @className: ListVisitor
 * @author: wenzhuo4657
 * @date: 2024/9/11 20:09
 * @Version: 1.0
 * @description:  访问的具体实现
 * 这里需要注意的是，在文件对象中接受的参数实例是在此处设定，其内部更像是定了模范方法一样，但是并非是通过继承抽象类实现模版，
 * 而是通过传递参数实例，其内部通过动态链接执行该方法实例内部，实际上是java多态的作用体现。
 */
public class ListVisitor extends  Visitor{
    @Override
    public void visit(File file) {
        System.out.println(file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(directory);
    }
}