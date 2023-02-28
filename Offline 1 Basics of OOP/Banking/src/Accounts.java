public class Accounts {

    private String name;
    private String type;
    private double balance;
    private int year;
    private double loan;
    final double loan_interest_rate = 0.1;

    public Accounts(String name, String type, double balance) {
        this.name = name;
        this.type = type;
        this.balance = balance;
        this.year = 0;
        this.loan = 0;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public boolean deposit(double balance)
    {
        if(balance < 0)
        {
            System.out.println("Error");
            return false;
        }
        setBalance(this.balance + balance);
        return true;
    }


    public boolean withdraw(double amount)
    {
        double new_balance = this.balance - amount;

        if(new_balance < 0)
        {
            System.out.println("Transaction Error, Not enough balance");
            return false;
        }
        setBalance(new_balance);
        return true;
    }

    public void loan_approve(double loan)
    {
        this.loan += loan;
        this.balance += loan;
    }

    public void yearly_update()
    {
        year +=1;
    }
}

class Student extends Accounts{

    static double account_interest_rate = 5.0;

    public Student(String name, double balance) {
        super(name, "Student", balance);
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount > 10000)
        {
            System.out.println("Invalid transaction; current balance " + getBalance() + "$");
            return false;
        }

        return super.withdraw(amount);
    }

    @Override
    public void yearly_update() {
        double bal = getBalance();
        bal = bal+ bal*(account_interest_rate/100) - getLoan()*loan_interest_rate;
        setBalance(bal);
        super.yearly_update();
    }
}

class FixedDeposit extends Accounts{

    static double account_interest_rate = 15.0;

    public FixedDeposit(String name, double balance) {
        super(name, "FixedDeposit", balance);
    }

    @Override
    public boolean deposit(double amount) {

        if(amount < 50000)
        {
            System.out.println("Error. Deposit amount less than 50,000 $");
            return false;
        }

        return super.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if(getYear() < 1){
            System.out.println("Transaction Error, Maturity not reached");
            return false;
        }
        return super.withdraw(amount);
    }

    @Override
    public void yearly_update() {
        double bal = getBalance();
        bal = bal + bal*(account_interest_rate/100) - getLoan()*loan_interest_rate - 500;
        setBalance(bal);
        super.yearly_update();

    }
}


class Savings extends Accounts{

    static double account_interest_rate = 10.0;

    public Savings(String name,  double balance) {
        super(name, "Savings", balance);
    }

    public void setAccount_interest_rate(double account_interest_rate) {
        this.account_interest_rate = account_interest_rate;
    }

    @Override
    public boolean withdraw(double amount) {
        double new_bal = getBalance() - amount;
        if(new_bal < 1000)
        {
            System.out.println("Invalid transaction; current balance " + getBalance() + "$");
            return false;
        }
        return super.withdraw(amount);
    }

    @Override
    public void yearly_update() {
        double bal = getBalance();
        bal = bal + bal*(account_interest_rate/100) - getLoan()*loan_interest_rate - 500;
        setBalance(bal);
        super.yearly_update();
    }
}
