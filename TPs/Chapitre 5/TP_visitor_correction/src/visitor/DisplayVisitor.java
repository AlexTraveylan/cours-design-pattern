package visitor;

import animal.Elephant;
import animal.Lion;
import animal.Monkey;

public class DisplayVisitor implements Visitor {
    @Override
    public void visitLion(Lion lion) {
        System.out.println("Displaying information for Lion: " + lion.getName());
    }

    @Override
    public void visitElephant(Elephant elephant) {
        System.out.println("Displaying information for Elephant: " + elephant.getName());
    }

    @Override
    public void visitMonkey(Monkey monkey) {
        System.out.println("Displaying information for Monkey: " + monkey.getName());
    }
}