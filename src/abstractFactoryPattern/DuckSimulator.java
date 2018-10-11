package abstractFactoryPattern;

import adapterPattern.GooseAdapter;
import decoratorPattern.QuackCounter;
import duck.Goose;
import duck.Quackable;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countDuckFactory = new CountingDuckFactory();
        AbstractDuckFactory echoDuckFactory = new EchoDuckFactory();
        simulator.simulate(duckFactory);
        simulator.simulate(countDuckFactory);
        simulator.simulate(echoDuckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(rubberDuck);
        simulate(gooseDuck);

        System.out.println("The ducks quacked " + QuackCounter.getNumberOfQuack() + " times");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
