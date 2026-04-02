public class DiscountDecorator extends ExpenseDecorator{

    //Passes expense to the parent
    public DiscountDecorator(Expense expense){
        super(expense);
    }

    //Adds a dicount label to the description
    @Override
    public String getDescription(){
        return super.getDescription() + "- Discount";
    }

    //Subtracts a fixed discount of 3
    @Override
    public double getCost(){
        return super.getCost() - 3.0;
    }
}