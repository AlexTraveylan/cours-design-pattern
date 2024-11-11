package animal;

import visitor.Visitor;

public class Monkey implements Animal {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMonkey(this);
    }

    @Override
    public String getName() {
        return name;
    }
}