public class TaxDecorator extends ExpenseDecorator{

    //Passes expense to the parent
    public TaxDecorator(Expense expense){
        super(expense);
    }

    //Adds tax label to the description
    @override 
    public String getDiscription(){
        return super.getDiscription() "+ Tax";
    }

    //Adds 20% tax to the cost
    @override
    public double getCost(){
        return super.getCost() * 1.20;
    }
}

