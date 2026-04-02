public class BudgetApp{

    public static void main(String[] args){

        //Creates a basic expense of 70
        Expense expense1 = new BasicExpense(70);

        //Prints base expense
        System.out.println(expense1.getDescription() + "= £" + expense1.getCost());

        //Expense with tax applied
        Expense expense2 = new TaxDecorator(new BasicExpense(70));

        //Prints expense with tax
        System.out.println(expense2.getDescription() + " = £" + expense2.getCost());

        //Expense with service fee, tax and discount
        Expense expense3 = new DiscountDecorator(
            new TaxDecorator(
                new ServiceFeeDecorator(
                    new BasicExpense(70)
                )
            )
         );

        //Print the fully decorated expense
         System.out.println(expense3.getDescription() + " = £" + expense3.getCost());
    }
}