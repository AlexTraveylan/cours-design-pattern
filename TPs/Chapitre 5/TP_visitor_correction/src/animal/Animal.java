package animal;

import visitor.Visitor;

public interface Animal {
    void accept(Visitor visitor);

    String getName();
}