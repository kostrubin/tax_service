import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] shop1 = generateIncome(20);
        int[] shop2 = generateIncome(15);
        int[] shop3 = generateIncome(25);

        Account acc = new Account();

        Thread firstIncome = new Thread(null, () -> acc.accumulateTotalIncome(shop1), "Магазин 1");
        Thread secondIncome = new Thread(null, () -> acc.accumulateTotalIncome(shop2), "Магазин 2");
        Thread thirdIncome = new Thread(null, () -> acc.accumulateTotalIncome(shop3), "Магазин 3");

        firstIncome.start();
        secondIncome.start();
        thirdIncome.start();

        firstIncome.join();
        secondIncome.join();
        thirdIncome.join();

        System.out.printf("Прибыль первого магазина составила: %d р.\n", acc.calculateShopIncome(shop1));
        System.out.printf("Прибыль второго магазина составила: %d р.\n", acc.calculateShopIncome(shop2));
        System.out.printf("Прибыль третьего магазина составила: %d р.\n", acc.calculateShopIncome(shop3));
        System.out.printf("Прибыль всех магазинов составила: %d р.\n", acc.getTotalIncome());
    }

    public static int[] generateIncome(int numberOfChecks) {
        Random random = new Random();
        int min = 1000;
        int max = 100000;
        int[] shopDayIncome = new int[numberOfChecks];

        for (int i = 0; i < numberOfChecks; i++) {
            shopDayIncome[i] = random.nextInt((max - min) + 1) + min;
        }

        return shopDayIncome;
    }
}
