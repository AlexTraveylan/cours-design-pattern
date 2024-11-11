import animal.*;
import visitor.*;

public class Main {

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.addAnimal(new Lion("Simba"));
        zoo.addAnimal(new Elephant("Dumbo"));
        zoo.addAnimal(new Monkey("Curious George"));

        zoo.acceptVisitor(new DisplayVisitor());
        zoo.acceptVisitor(new FoodRequirementVisitor());
        zoo.acceptVisitor(new SpaceRequirementVisitor());
    }
}
