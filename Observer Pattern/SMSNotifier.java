//Sends a SMS notification when changes are detected
public class SMSNotifier implements AccountObserver{
    @Override
    public void update(double balance, String transaction){
        System.out.println("SMS: Your account has a new transaction: " + transaction + "Balance: £" + balance);
    }
}