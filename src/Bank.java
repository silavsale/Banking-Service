public class Bank {
    public static void main(String[] args) {

        System.out.println("\n--- Welcome to WebBank Application! ---\n");

        CheckingAccount myCheckAcc = new CheckingAccount();
        SavingAccount mySaveAcc = new SavingAccount();

        System.out.println("myCheckAcc obj: " + myCheckAcc.CheckingAccountClassInfo);
        System.out.println("mySaveAcc obj: " + mySaveAcc.SavingsAccountClassInfo);

//        myCheckAcc.makeWithdraw(1000);

        System.out.println("myCheckAcc.balance: " + myCheckAcc.balance);

        mySaveAcc.makeDeposit(25);

        System.out.println("myCheckAcc.balance: " + myCheckAcc.balance);

    }

}
