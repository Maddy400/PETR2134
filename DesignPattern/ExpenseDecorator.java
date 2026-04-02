public abstract class ExpenseDecorator implements Expense{

    //References the Expense object the code is wrapped in
    protected Expense expense;

    //Initialises the wrapped expense object
    public ExpenseDecorator(Expense expense){
        this.expense = expense;
    }

    //Gives the wrapped expense object a description
    @Override 
    public String getDescription(){
        return expense.getDescription();
    }

    //Gives the wrapped expense object a cost
    @Override 
    public double getCost(){
        return expense.getCost();
    }
}