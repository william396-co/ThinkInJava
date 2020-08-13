package Enumerated;

import com.thinkinjava.util.Generator;
import com.thinkinjava.util.RandomGenerator;
import com.thinkinjava.util.TextFile;
import nu.xom.jaxen.expr.iter.IterableAncestorOrSelfAxis;
import typeinfo.pets.Cat;

import java.util.EnumMap;
import java.util.Iterator;

import static com.thinkinjava.util.Print.*;
import static Enumerated.Input.*;

enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELCTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private Input[] values;

    Category(Input... types) {
        values = types;
    }

    private static EnumMap<Input, Category> categoryEnumMap =
            new EnumMap<Input, Category>(Input.class);

    static {
        for (Category c : Category.class.getEnumConstants())
            for (Input type : c.values)
                categoryEnumMap.put(type, c);
    }

    public static Category categorize(Input input) {
        return categoryEnumMap.get(input);
    }
}

public class VendingMachine {

    private static State state = State.RESTING;

    private static int amount = 0;
    private static Input selection = null;

    enum StateDuration {TRANSIENT}//tagging enum

    enum State {
        RESTING {
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELCTION:
                        selection = input;
                        if (amount < selection.amount())
                            println("Insufficient money for " + selection);
                        else
                            state = DISPENDING;
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        DISPENDING(StateDuration.TRANSIENT) {
            void next() {
                println("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            void next() {
                if (amount > 0) {
                    println("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }

        },
        TERMINAL {
            void output() {
                println("Halted");
            }
        };

        private boolean isTransient = false;

        State() {
        }

        State(StateDuration aTransient) {
            isTransient = true;
        }

        void next(Input input) {
            throw new RuntimeException("Only call next(Input input) for non-transient states");
        }

        void next() {
            throw new RuntimeException("Only call next() for " + "StateDuration.TRANSITENT states");
        }

        void output() {
            println(amount);
        }
    }

    static void run(Generator<Input> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.next());
            while (state.isTransient)
                state.next();
            state.output();
        }
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        if (args.length == 1)
            gen = new FileInputGenerator(args[0]);
        run(gen);
    }
}

class RandomInputGenerator implements Generator<Input> {
    public Input next() {
        return Input.randomSelection();
    }
}

class FileInputGenerator implements Generator<Input> {
    private Iterator<String> input;

    public FileInputGenerator(String fileName) {
        input = new TextFile(fileName, ";").iterator();
    }

    @Override
    public Input next() {
        if (!input.hasNext())
            return null;
        return Enum.valueOf(Input.class, input.next().trim());
    }
}
