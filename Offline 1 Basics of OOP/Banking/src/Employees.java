public class Employees {

    private String name;
    private String type;

    public Employees(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void Lookup(Accounts acc)
    {
        System.out.println(acc.getName() + "'s current balance " + acc.getBalance() + "$");;
    }

    public boolean ApproveLoan(Accounts accounts, double loan_amount)
    {
        System.out.println("You don't have permission for this operation ");
        return false;
    }

    public void changeInterestRate(String type, double new_rate)
    {
        System.out.println("You don't have permission for this operation");
    }
    public void seeFund(double fund)
    {
        System.out.println("You don't have permission for this operation ");
    }


}

class Cashier extends Employees{

    public Cashier(String name, String type) {
        super(name, type);
    }


}

class Officer extends Cashier{
    public Officer(String name, String type) {
        super(name, type);
    }

    @Override
    public boolean ApproveLoan(Accounts accounts, double loan_amount) {
        accounts.loan_approve(loan_amount);
        return true;
    }
}

class ManagingDirector extends Officer{
    public ManagingDirector(String name, String type){
        super(name, type);
    }
    @Override
    public boolean ApproveLoan(Accounts accounts, double loan_amount) {
        accounts.loan_approve(loan_amount);
        return true;
    }

    @Override
    public void seeFund(double fund) {
        System.out.println("Bank fund: " + fund +"$");
    }

    @Override
    public void changeInterestRate(String type, double new_rate) {
        if(type.equalsIgnoreCase("Student"))Student.account_interest_rate = new_rate;
        else if(type.equalsIgnoreCase("Savings"))Savings.account_interest_rate = new_rate;
        else if(type.equalsIgnoreCase("fixeddeposit"))FixedDeposit.account_interest_rate = new_rate;
        System.out.println("New interest rate for " + type + " Accounts: " + new_rate + "%");
    }
}


