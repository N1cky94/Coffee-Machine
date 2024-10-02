package machine;

public class CoffeeMachine {
    private int availableWater;
    private int availableMilk;
    private int availableCoffeeBeans;
    private int availableDisposableCups;
    private int availableMoney;
    private int servingsWithoutCleaning;

    public CoffeeMachine(int availableWater, int availableMilk, int availableCoffeeBeans) {
        this.availableWater = availableWater;
        this.availableMilk = availableMilk;
        this.availableCoffeeBeans = availableCoffeeBeans;
        this.servingsWithoutCleaning = 0;
    }

    public CoffeeMachine(int availableWater, int availableMilk, int availableCoffeeBeans, int availableDisposableCups, int availableMoney) {
        this(availableWater, availableMilk, availableCoffeeBeans);
        this.availableDisposableCups = availableDisposableCups;
        this.availableMoney = availableMoney;
    }

    public void serveEspresso() {
        if (
                !hasEnoughAvailableDisposableCups(1) ||
                !hasEnoughAvailableWater(250) ||
                !hasEnoughAvailableBeans(16)
        ) {
            return;
        }

        this.availableDisposableCups--;
        this.availableWater -= 250;
        this.availableCoffeeBeans -= 16;
        this.availableMoney += 4;

        serveSuccess();
    }

    public void serveLatte() {
        if (
                !hasEnoughAvailableDisposableCups(1) ||
                !hasEnoughAvailableWater(350) ||
                !hasEnoughMilk(75) ||
                !hasEnoughAvailableBeans(20)
        ) {
            return;
        }

        this.availableDisposableCups--;
        this.availableWater -= 350;
        this.availableMilk -= 75;
        this.availableCoffeeBeans -= 20;
        this.availableMoney += 7;

        serveSuccess();
    }

    public void serveCappuccino() {
        if (
                !hasEnoughAvailableDisposableCups(1) ||
                !hasEnoughAvailableWater(200) ||
                !hasEnoughMilk(100) ||
                !hasEnoughAvailableBeans(12)
        ) {
            return;
        }

        this.availableDisposableCups--;
        this.availableWater -= 200;
        this.availableMilk -= 100;
        this.availableCoffeeBeans -= 12;
        this.availableMoney += 6;

        serveSuccess();
    }

    private boolean hasEnoughAvailableWater(int check) {
        if (this.availableWater < check) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else {
            return true;
        }
    }

    private boolean hasEnoughAvailableDisposableCups(int check) {
        if (this.availableDisposableCups < check) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            return true;
        }
    }

    private boolean hasEnoughAvailableBeans(int check) {
        if (this.availableCoffeeBeans < check) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else {
            return true;
        }
    }

    private boolean hasEnoughMilk(int check) {
        if (this.availableMilk < check) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else {
            return true;
        }
    }

    private void serveSuccess() {
        servingsWithoutCleaning++;
        System.out.println("I have enough resources, making you a coffee!");
    }

    public void fillMachine(int mlOfWater, int mlOfMilk, int gOfCoffeeBeans, int disposableCups) {
        this.availableWater += mlOfWater;
        this.availableMilk += mlOfMilk;
        this.availableCoffeeBeans += gOfCoffeeBeans;
        this.availableDisposableCups += disposableCups;
    }

    public int takeAllMoney() {
        int amountRetrieved = this.availableMoney;
        this.availableMoney = 0;

        return amountRetrieved;
    }

    public boolean needsCleaning() {
        return servingsWithoutCleaning >= 10;
    }

    public void clean() {
        servingsWithoutCleaning = 0;
        System.out.println("I have been cleaned!");
    }

    public String toString() {
        return """
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """.formatted(
                    this.availableWater,
                    this.availableMilk,
                    this.availableCoffeeBeans,
                    this.availableDisposableCups,
                    this.availableMoney
        );
    }
}
