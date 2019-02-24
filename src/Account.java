abstract class Account {

    public String AccountClassInfo = "This is Account Class";
    protected double strBlThMth;   //    Starting balance this month
    protected double balance;   //    Current balance this month
    protected double totDepsThMth;   //    Total of deposits this month
    protected int numDepsThMth;   //    Number of deposits this month
    protected double totWithDrawThMth;   //    Total of withdrawals this month
    protected int numWithDrawThMth;   //    Number of withdrawals this month
    protected double annualIntRate;   //    Annual interest rate
    protected double mntInterRate;  // monthly interest rate = annual rate / 12
    protected double monthlyInterest; // monthly interest earned by the account
    protected double serviceCharge; //    This month’s service charge
    protected boolean curAccStatus = false;   //    Current account status (to represent an active or inactive account)

    //    Superclass default (empty) constructor:
    Account() {

    }

    // Create a class constructor for the Account class
    // superclass parameterized constructor:
    Account(double constrBalance, double constrAnnualInterestRate) {
        this.balance = constrBalance;
        this.annualIntRate = constrAnnualInterestRate;
    }


    // A method that accepts an argument for the amount of the deposit.
    public void makeDeposit(double deposit) {
        balance += deposit;
        totDepsThMth += deposit;
        numDepsThMth++;
    }

    // A method that accepts an argument for the amount of the withdrawal.
    public void makeWithdraw(double withdrawal) {
        balance -= withdrawal;
        totWithDrawThMth += withdrawal;
        numWithDrawThMth++;
    }

    // A method that updates the balance by calculating the monthly interest
    // earned by the account, and adding the interest to the balance.
    public double calculateInterest() {
        mntInterRate = (annualIntRate / 12);
        monthlyInterest = balance * mntInterRate;
        balance += mntInterRate;

        return balance;
    }

    //    A method that
    //      1) subtracts the monthly service charges from the balance
    //      2) calls the calculateInterest method
    //      3) sets the number of withdrawals, number of deposits, monthly service charges to zero.
    public void doMonthlyReport() {
        System.out.println(getClass().toString());
        System.out.println("The starting balance this month was: $" + strBlThMth);
        System.out.println("The total amount of deposits: $" + totDepsThMth);
        System.out.println("The total amount of withdrawals: $" + totWithDrawThMth);
        System.out.println("The total amount of service charge: $" + serviceCharge);
        System.out.println("The current balance: $" + balance);
        if (curAccStatus) {
            System.out.println("The account is active.");
        } else {
            System.out.println("The account is inactive.");
        }

        balance -= serviceCharge;
        strBlThMth += balance;
        calculateInterest();
        numWithDrawThMth = 0;
        numDepsThMth = 0;
        serviceCharge = 0;
    }


}
