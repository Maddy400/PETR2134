import java.util.ArrayList;
import java.util.List;

//Logs all transactions
public class AuditLogger implements AccountObserver {
    private List<String> log = new ArrayList<>();

    @Override
    public void update(double balance, String transaction) {
        log.add(transaction + " | Balance: £" + balance);
        System.out.println("Audit Log Updated: " + log);
    }
}