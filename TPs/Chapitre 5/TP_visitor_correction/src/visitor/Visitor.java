package visitor;

import animal.Elephant;
import animal.Lion;
import animal.Monkey;

public interface Visitor {
    void visitLion(Lion lion);

    void visitElephant(Elephant elephant);

    void visitMonkey(Monkey monkey);
}