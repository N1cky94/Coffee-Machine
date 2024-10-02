package machine;

import static java.lang.System.exit;

public class CoffeeMenu {
    private final CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

    public void runMainMenu() {
        while(true) {

            String action = KeyboardUtil.askForString("Write action (buy, fill, take, clean, remaining, exit):");

            switch (action) {
                case "buy" -> buyCoffeeMenu();
                case "fill" -> fillMachineMenu();
                case "take" -> takeMoneyMenu();
                case "clean" -> cleanMachineMenu();
                case "exit" -> exit(0);
                case "remaining" -> System.out.println(machine);
                default -> System.out.println("Invalid action");
            }
        }
    }

    private void buyCoffeeMenu() {
        if (machine.needsCleaning()) {
            System.out.println("I need cleaning!");
            return;
        }

        String coffeeType = KeyboardUtil.askForString("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

        switch (coffeeType) {
            case "1" -> machine.serveEspresso();
            case "2" -> machine.serveLatte();
            case "3" -> machine.serveCappuccino();
            case "back" -> {return;}
            default -> System.out.println("Invalid coffee type");
        }
    }

    private void fillMachineMenu() {
        int mlOfWater = KeyboardUtil.askForInteger("Write how many ml of water you want to add:");
        int mlOfMilk = KeyboardUtil.askForInteger("Write how many ml of milk you want to add:");
        int gOfCoffeeBeans = KeyboardUtil.askForInteger("Write how many grams of coffee beans you want to add:");
        int disposableCups = KeyboardUtil.askForInteger("Write how many disposable cups you want to add:");
        System.out.println();

        machine.fillMachine(mlOfWater, mlOfMilk, gOfCoffeeBeans, disposableCups);
    }

    private void takeMoneyMenu() {
        System.out.println("I gave you $" + machine.takeAllMoney() + "\n");
    }

    private void cleanMachineMenu() {
        machine.clean();
    }
}
