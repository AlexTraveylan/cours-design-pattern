package animal;

import visitor.Visitor;

public class Elephant implements Animal {
    private String name;

    public Elephant(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitElephant(this);
    }

    @Override
    public String getName() {
        return name;
    }
}