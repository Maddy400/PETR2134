import java.util.ArrayList;
import java.util.List;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

// Observer interface
public interface AccountObserver {
    void update(double balance, String transaction);
}

// BankAccount class (Observable)
public class BankAccount {
    private double balance;
    private List<AccountObserver> observers = new ArrayList<>();

    public void addObserver(AccountObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(AccountObserver observer) {
        observers.remove(observer);
    }

    public void deposit(double amount) {
        balance += amount;
        notifyObservers("Deposit : +" + amount);
    }

    public void withdraw(double amount) {
        balance -= amount;
        notifyObservers("Withdrawal: -" + amount);
    }

    private void notifyObservers(String transaction) {
        for (AccountObserver observer : observers) {
            observer.update(balance, transaction);
        }
    }

    public double getBalance() {
        return balance;
    }
}

// SMS Notifier
class SMSNotifier implements AccountObserver {
    @Override
    public void update(double balance, String transaction) {
        System.out.println("SMS: Your account has a new transaction: " + transaction + " Balance: £" + balance);
    }
}

// Email Notifier
class EmailNotifier implements AccountObserver {
    @Override
    public void update(double balance, String transaction) {
        System.out.println("Email: Transaction alert: " + transaction + ". New balance: £" + balance);
    }
}

// Audit Logger
class AuditLogger implements AccountObserver {
    private List<String> log = new ArrayList<>();

    @Override
    public void update(double balance, String transaction) {
        log.add(transaction + " | Balance: £" + balance);
        System.out.println("Audit Log Updated: " + log);
    }
}

// Test Observer for T-004
class TestObserver implements AccountObserver {
    @Override
    public void update(double balance, String transaction) {
        System.out.println("TestObserver: " + transaction + " | Balance: £" + balance);
    }
}

// Main application
public class BankApp {

    public static void main(String[] args) {

        System.out.println("T-001: Deposit 100");
        BankAccount account1 = new BankAccount();
        account1.addObserver(new SMSNotifier());
        account1.addObserver(new EmailNotifier());
        account1.addObserver(new AuditLogger());
        account1.deposit(100);

        System.out.println("\nT-002: Withdraw 40");
        BankAccount account2 = new BankAccount();
        account2.addObserver(new SMSNotifier());
        account2.addObserver(new EmailNotifier());
        account2.addObserver(new AuditLogger());
        account2.deposit(100);
        account2.withdraw(40);

        System.out.println("\nT-003: Deposit 200 after withdrawal");
        BankAccount account3 = new BankAccount();
        account3.addObserver(new SMSNotifier());
        account3.addObserver(new EmailNotifier());
        account3.addObserver(new AuditLogger());
        account3.deposit(100);
        account3.withdraw(40);
        account3.deposit(200);

        System.out.println("\nT-004: Add new observer");
        BankAccount account4 = new BankAccount();
        SMSNotifier sms4 = new SMSNotifier();
        EmailNotifier email4 = new EmailNotifier();
        AuditLogger audit4 = new AuditLogger();
        TestObserver testObs = new TestObserver();
        account4.addObserver(sms4);
        account4.addObserver(email4);
        account4.addObserver(audit4);
        account4.addObserver(testObs);
        account4.deposit(50);

        System.out.println("\nT-005: Remove SMSNotifier");
        BankAccount account5 = new BankAccount();
        EmailNotifier email5 = new EmailNotifier();
        AuditLogger audit5 = new AuditLogger();
        account5.addObserver(email5);
        account5.addObserver(audit5);
        account5.deposit(30); // SMSNotifier removed

        System.out.println("\nT-006: Multiple deposits 50, 75");
        BankAccount account6 = new BankAccount();
        EmailNotifier email6 = new EmailNotifier();
        AuditLogger audit6 = new AuditLogger();
        account6.addObserver(email6);
        account6.addObserver(audit6);
        account6.deposit(50);
        account6.deposit(75);

        System.out.println("\nT-007: Multiple withdrawals 30, 60");
        BankAccount account7 = new BankAccount();
        EmailNotifier email7 = new EmailNotifier();
        AuditLogger audit7 = new AuditLogger();
        account7.addObserver(email7);
        account7.addObserver(audit7);
        account7.deposit(125); // starting balance
        account7.withdraw(30);
        account7.withdraw(60);

        System.out.println("\nT-008: No observers");
        BankAccount account8 = new BankAccount();
        account8.deposit(25);
        System.out.println("Final balance (no observers) = £" + account8.getBalance());
    }
}