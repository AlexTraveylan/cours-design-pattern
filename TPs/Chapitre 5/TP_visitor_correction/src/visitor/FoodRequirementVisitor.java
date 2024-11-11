package visitor;

import animal.Elephant;
import animal.Lion;
import animal.Monkey;

public class FoodRequirementVisitor implements Visitor {
    @Override
    public void visitLion(Lion lion) {
        System.out.println("Food requirement for Lion " + lion.getName() + ": 10 kg of meat per day");
    }

    @Override
    public void visitElephant(Elephant elephant) {
        System.out.println("Food requirement for Elephant " + elephant.getName() + ": 50 kg of vegetation per day");
    }

    @Override
    public void visitMonkey(Monkey monkey) {
        System.out
                .println("Food requirement for Monkey " + monkey.getName() + ": 2 kg of fruits and vegetables per day");
    }
}