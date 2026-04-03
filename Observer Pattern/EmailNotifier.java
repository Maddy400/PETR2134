//Sends an email when any changes are detected
public class EmailNotifier implements AccountObserver {
    @Override
    public void update(double balance, String transaction) {
        System.out.println("Email: Transaction alert -> " + transaction + ". New balance: £" + balance);
    }
}