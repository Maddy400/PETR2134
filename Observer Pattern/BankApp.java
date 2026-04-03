public class BankApp {
    public static void main(String[] args) {

        //Creates account
        BankAccount account = new BankAccount();

        //Creates the observers
        SMSNotifier smsNotifier = new SMSNotifier();
        EmailNotifier emailNotifier = new EmailNotifier();
        AuditLogger auditLogger = new AuditLogger();

        //Registers each observer
        account.addObserver(smsNotifier);
        account.addObserver(emailNotifier);
        account.addObserver(auditLogger);

        //Begins a transaction
        System.out.println("----- Depositing £100 -----");
        account.deposit(100);

        System.out.println("----- Withdrawing £40 -----");
        account.withdraw(40);

        System.out.println("----- Depositing £200 -----");
        account.deposit(200);
    }
}