package animal;

import visitor.Visitor;

public class Lion implements Animal {
    private String name;

    public Lion(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitLion(this);
    }

    @Override
    public String getName() {
        return name;
    }
}