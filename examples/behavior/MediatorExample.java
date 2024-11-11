// Classe abstraite Colleague
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void send(String event);

    public abstract void receive(String event);
}

// Classe ConcreteColleague1
class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String event) {
        System.out.println("Colleague1 sends: " + event);
        mediator.notify(this, event);
    }

    @Override
    public void receive(String event) {
        System.out.println("Colleague1 received: " + event);
    }
}

// Classe ConcreteColleague2
class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String event) {
        System.out.println("Colleague2 sends: " + event);
        mediator.notify(this, event);
    }

    @Override
    public void receive(String event) {
        System.out.println("Colleague2 received: " + event);
    }
}

// Interface Mediator
interface Mediator {
    void notify(Colleague colleague, String event);
}

// Classe ConcreteMediator
class ConcreteMediator implements Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public void setColleague1(ConcreteColleague1 colleague) {
        this.colleague1 = colleague;
    }

    public void setColleague2(ConcreteColleague2 colleague) {
        this.colleague2 = colleague;
    }

    @Override
    public void notify(Colleague sender, String event) {
        if (sender == colleague1) {
            colleague2.receive(event);
        } else if (sender == colleague2) {
            colleague1.receive(event);
        }
    }
}

// Exemple d'utilisation
public class MediatorExample {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.send("Hello from Colleague1");
        colleague2.send("Hello from Colleague2");
    }
}