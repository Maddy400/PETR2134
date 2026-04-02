public class BasicExpense implements Expense{

    //Stores the base amount
    private double amount;

    //Initialises the amount variable
    public BasicExpense(double amount){
        this.amount = amount;
    }

    //Returns the description of the expense
    @Override 
    public String getDescription(){
        return "Base Expense";
    }

    //Returns the base cost
    @Override 
    public double getCost(){
        return amount;
    }
}