import java.util.Arrays;
import java.util.concurrent.atomic.LongAdder;

public class Account {

    LongAdder totalIncome = new LongAdder();

    public int calculateShopIncome(int[] shopChecks) {
        return Arrays.stream(shopChecks).reduce(0, Integer::sum);
    }

    public void accumulateTotalIncome(int[] allChecks) {
        Arrays.stream(allChecks).forEach(totalIncome::add);
    }

    public long getTotalIncome() {
        return totalIncome.sum();
    }
}
