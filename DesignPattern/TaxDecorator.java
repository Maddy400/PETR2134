public class TaxDecorator extends ExpenseDecorator{

    //Passes expense to the parent
    public TaxDecorator(Expense expense){
        super(expense);
    }

    //Adds tax label to the description
    @Override 
    public String getDescription(){
        return super.getDescription() + "+ Tax";
    }

    //Adds 20% tax to the cost
    @Override 
    public double getCost(){
        return super.getCost() * 1.20;
    }
}

