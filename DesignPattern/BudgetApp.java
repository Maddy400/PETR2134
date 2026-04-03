public class BudgetApp{

    public static void main(String[] args){

        //T-001
        Expense test1 = new BasicExpense(70);
        System.out.printf("T1: %s = £%.2f\n", test1.getDescription(), test1.getCost());

        //T-002
        Expense test2 = new TaxDecorator(new BasicExpense(70));
        System.out.printf("T2: %s = £%.2f\n", test2.getDescription(), test2.getCost());

        //T-003
        Expense test3 = new ServiceFeeDecorator(new BasicExpense(70));
        System.out.printf("T3: %s = £%.2f\n", test3.getDescription(), test3.getCost());

        //T-004
        Expense test4 = new DiscountDecorator(new BasicExpense(70));
        System.out.printf("T4: %s = £%.2f\n", test4.getDescription(), test4.getCost());

        //T-005
        Expense test5 = new TaxDecorator(new ServiceFeeDecorator(new BasicExpense(70)));
        System.out.printf("T5: %s = £%.2f\n", test5.getDescription(), test5.getCost());

        //T-006
        Expense test6 = new DiscountDecorator(new TaxDecorator(new ServiceFeeDecorator(new BasicExpense(70))));
        System.out.printf("T6: %s = £%.2f\n", test6.getDescription(), test6.getCost());

        //T-007
        Expense test7 = new BasicExpense(0);
        System.out.printf("T7: %s = £%.2f\n", test7.getDescription(), test7.getCost());

        //T-008
        Expense test8 = new BasicExpense(-10);
        System.out.printf("T8: %s = £%.2f\n", test8.getDescription(), test8.getCost());
    }
}