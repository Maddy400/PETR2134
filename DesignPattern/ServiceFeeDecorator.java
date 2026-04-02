public class ServiceFeeDecorator extends ExpenseDecorator{

    //Passes expense to the parent
    public ServiceFeeDecorator(Expense expense){
        super(expense);
    }

    //Adds a service fee label to the description
    @Override
    public String getDescription(){
        return super.getDescription() + "+ Service Fee";
    }

    //Adds service fee
    @Override
    public double getCost(){
        return super.getCost() + 1;
    }
}