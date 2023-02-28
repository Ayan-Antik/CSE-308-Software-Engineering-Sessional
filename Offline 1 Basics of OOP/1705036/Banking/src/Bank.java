import java.util.HashMap;
import java.util.Scanner;

public class Bank{
    private double fund;

    private static HashMap<String, Accounts> accounts;
    private static HashMap<String, Employees> employees;


    public Bank(){
        fund = 1000000;
        accounts = new HashMap<>();
        employees = new HashMap<>();
        for (int i = 0; i<5; i++)
        {
            String name = "C" + (i+1);
            Cashier cashier = new Cashier(name, "Cashier");
            employees.put(name, cashier);
        }

        for (int i = 0; i<2; i++)
        {
            String name = "O" + (i+1);
            Officer officer= new Officer(name, "Officer");
            employees.put(name, officer);
        }

        ManagingDirector managingDirector = new ManagingDirector("MD", "ManagingDirector");
        employees.put("MD", managingDirector);


        System.out.println("Bank Created; MD; O1; O2;C1;C2;C3;C4;C5 created");

    }

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public boolean createAccount(String name, String type, double balance){

        //Search in Map
            if(accounts.containsKey(name))
            {
                System.out.println("Error, Account already exists with this name...");
                return false;
            }


        if(type.equalsIgnoreCase("student")){

            Student student = new Student(name, balance);
            //System.out.println(student);
            accounts.put(name, student);
            return true;
        }

        else if(type.equalsIgnoreCase("fixeddeposit"))
        {
            if(balance < 100000){
                System.out.println("Initial Balance < 100000. Account not created.");
                return false;
            }
            FixedDeposit fixedDeposit = new FixedDeposit(name, balance);
            accounts.put(name, fixedDeposit);
            return true;
        }

        else if(type.equalsIgnoreCase("savings"))
        {
            Savings savings = new Savings(name, balance);
            accounts.put(name, savings);
            //System.out.println("");
            return true;
        }

        else {
            System.out.println("Account Create Error!");
            return false;
        }


    }

    public boolean loan_request(double amount, String type) {

        if(fund > amount) {
            if (type.equalsIgnoreCase("savings")) {
                if (amount <= 10000) return true;
            }
            else if (type.equalsIgnoreCase("student")) {
                if (amount <= 1000) return true;
            }
            else if (type.equalsIgnoreCase("fixeddeposit")) {
                if (amount <= 100000) return true;
            }
        }

            System.out.println("Invalid Loan Request");
            return false;
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        Scanner ip = new Scanner(System.in);
        String line = ip.nextLine();
        String curr_user = null;
        String curr_employee = null;
        HashMap<Accounts, Double> loan_user = new HashMap<>();
        while (!line.equalsIgnoreCase("exit")) {

            String[] words = line.split(" ");
            try {


                if (words[0].equalsIgnoreCase("create")) {
                    boolean created = bank.createAccount(words[1], words[2], Integer.parseInt(words[3]));
                    if (created) {
                        curr_user = words[1];
                        System.out.println(words[2] + " account for " + words[1] + " created; initial balance " + words[3] + "$");
                    }
                }

                if (words[0].equalsIgnoreCase("deposit") && accounts.containsKey(curr_user)) {
                    double amount = Double.parseDouble(words[1]);
                    boolean dep = accounts.get(curr_user).deposit(amount);
                    if (dep) {
                        System.out.println(amount + "$ deposited; current balance " + accounts.get(curr_user).getBalance() + "$");
                    }


                }

                if (words[0].equalsIgnoreCase("withdraw") && accounts.containsKey(curr_user)) {
                    double amount = Double.parseDouble(words[1]);
                    boolean wd = accounts.get(curr_user).withdraw(amount);
                    if (wd) {
                        System.out.println(amount + "$ withdrawn; current balance " + accounts.get(curr_user).getBalance() + "$");
                    }

                }

                if (words[0].equalsIgnoreCase("query") && accounts.containsKey(curr_user)) {
                    System.out.println("Current Balance: " + accounts.get(curr_user).getBalance() + "$, loan " + accounts.get(curr_user).getLoan() + "$");
                }

                if (words[0].equalsIgnoreCase("open")) {

                    if (accounts.containsKey(words[1])) {
                        if (curr_user == null && curr_employee == null) {
                            System.out.println("Welcome back, " + words[1]);
                            curr_user = words[1];
                        } else {
                            System.out.println("System in use");
                        }


                    } else if (employees.containsKey(words[1])) {
                        if (curr_user == null && curr_employee == null) {
                            System.out.print(words[1] + " active");
                            if (!loan_user.isEmpty()) {
                                System.out.println(", there are loan approvals pending");
                            } else {
                                System.out.println();
                            }
                            curr_employee = words[1];
                        } else {
                            System.out.println("System in use");
                        }
                    }


                }

                if (words[0].equalsIgnoreCase("inc")) {

                    if(curr_user == null && curr_employee == null) {
                        boolean flag = true;
                        for (Accounts a : accounts.values()) {
                            a.yearly_update();
                            if (flag) System.out.println(a.getYear() + " years passed");
                            flag = false;
                        }
                    }
                    else {
                        System.out.println("Invalid Input");
                    }

                }

                if (words[0].equalsIgnoreCase("request") && accounts.containsKey(curr_user)) {
                    double loan_amount = Double.parseDouble(words[1]);
                    boolean request_valid = bank.loan_request(loan_amount, accounts.get(curr_user).getType());
                    if (request_valid) {
                        System.out.println("Loan request successful, sent for approval");
                        loan_user.put(accounts.get(curr_user), loan_amount);

                    }

                }

                if (words[0].equalsIgnoreCase("Lookup") && employees.containsKey(curr_employee)) {
                    if (accounts.containsKey(words[1])) {
                        employees.get(curr_employee).Lookup(accounts.get(words[1]));
                    }
                }

                if (line.equalsIgnoreCase("approve loan") && employees.containsKey(curr_employee)) {
                    boolean approved = false;
                    boolean flag = true;
                    int val_cnt = loan_user.size();

                    for (Accounts a : loan_user.keySet()) {
                        approved = employees.get(curr_employee).ApproveLoan(a, loan_user.get(a));
                        if (!approved) break;
                        else {

                            bank.setFund(bank.getFund() - loan_user.get(a));

                            val_cnt--;
                            if (flag) {
                                System.out.print("Loan for ");
                                flag = false;
                            }
                            System.out.print(a.getName());
                            if (val_cnt > 0) System.out.print(", ");
                            else {
                                System.out.println(" approved");
                            }
                        }
                    }

                    if (approved) loan_user.clear();

                }

                if (words[0].equalsIgnoreCase("change") && employees.containsKey(curr_employee)) {
                    employees.get(curr_employee).changeInterestRate(words[1], Double.parseDouble(words[2]));
                }

                if (words[0].equalsIgnoreCase("see") && employees.containsKey(curr_employee)) {
                    employees.get(curr_employee).seeFund(bank.getFund());
                }


                if (words[0].equalsIgnoreCase("close")) {
                /*System.out.println("Operations for " + curr_user +" closed");
                curr_user = null;*/

                    if (accounts.containsKey(curr_user)) {
                        System.out.println("Operations for " + curr_user + " closed");
                        curr_user = null;
                    } else if (employees.containsKey(curr_employee)) {
                        System.out.println("Operations for " + curr_employee + " closed");
                        curr_employee = null;
                    } else {
                        System.out.println("No one currently in system");
                    }
                }

            }
            catch (Exception e){
                System.out.println(e);
                System.out.println("Invalid Input Command");
            }
            line = ip.nextLine();
        }



    }
}
