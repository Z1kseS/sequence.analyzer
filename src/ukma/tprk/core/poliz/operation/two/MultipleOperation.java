package ukma.tprk.core.poliz.operation.two;

import java.util.List;

import ukma.tprk.core.poliz.operation.Operation;

public class MultipleOperation extends Operation {

    public MultipleOperation() {
        this.name = "MULTIPLE";
        this.value = "*";
        this.priority = 2;
        this.pattern = "[\\*]";
        this.isFunction = false;
        this.numberOfArguments = 1;
    }

    @Override
    public double performAction(List<Double> arguments) {
        return arguments.get(0) * arguments.get(1);
    }

}
