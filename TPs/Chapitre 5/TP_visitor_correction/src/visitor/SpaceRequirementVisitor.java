package visitor;

import animal.Elephant;
import animal.Lion;
import animal.Monkey;

public class SpaceRequirementVisitor implements Visitor {
    @Override
    public void visitLion(Lion lion) {
        System.out.println("Space requirement for Lion " + lion.getName() + ": 100 square meters");
    }

    @Override
    public void visitElephant(Elephant elephant) {
        System.out.println("Space requirement for Elephant " + elephant.getName() + ": 500 square meters");
    }

    @Override
    public void visitMonkey(Monkey monkey) {
        System.out.println("Space requirement for Monkey " + monkey.getName() + ": 50 square meters");
    }
}