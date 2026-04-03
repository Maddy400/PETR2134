import java.util.ArrayList;
import java.util.List;

public class BankAccount{
    private double balance;
    private List<AccountObserver> observers = new ArrayList<>();

    //Adds an observer
    public void addObserver(AccountObserver observer){
        observers.add(observer);
    }

    //Removes an observe
    public void removeObserver(AccountObserver observer){
        observers.remove(observer);
    }

    //Deposits money into an account and notifies the user
    public void deposit(double amount){
        balance += amount;
        notifyObservers("Deposit : +" + amount);
    }

    //Withdraws money from an account and notifies the user
    public void withdraw(double amount){
        balance -= amount;
        notifyObservers("Withdrawal: -" + amount);
    }

    //Notifies all observers of changes
    public void notifyObservers(String transaction){
        for(AccountObserver observer : observers){
            observer.update(balance, transaction);
        }
    }

    //Retrives the current balance
    public double getBalance(){
        return balance;
    }
}