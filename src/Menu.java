import java.util.Scanner;
import java.lang.*;

public class Menu extends Account {

    CheckingAccount myCheckAcc = new CheckingAccount(1000, 2);
    SavingAccount mySaveAcc = new SavingAccount(1000, 2.5);

    Scanner scanner = new Scanner(System.in);

    void savingMenu() {
        System.out.println("Savings Menu");
        System.out.println("A: Deposit");
        System.out.println("B: Withdrawal");
        System.out.println("C: Report");
        System.out.println("D: Return to Bank Menu");

        char inputSaving = scanner.next().charAt(0);
        inputSaving = Character.toUpperCase(inputSaving);

        if (inputSaving == 'A') {
            System.out.println("Please enter your deposit amount:");
            double depo = scanner.nextDouble();
            mySaveAcc.makeDeposit(depo);
            System.out.println("Deposit of $" + depo + " was added to your balance.");
            System.out.println("Your Saving Account balance is $" + mySaveAcc.balance);
            savingMenu();
        } else if (inputSaving == 'B') {
            System.out.println("Please enter amount of withdraw:");
            double whidr = scanner.nextDouble();
            mySaveAcc.makeWithdraw(whidr);
            if (mySaveAcc.curAccStatus) {
                System.out.println("Your successively withdraw $" + whidr + " from your balance.");
                System.out.println("Your Saving Account balance is $" + mySaveAcc.balance);
                savingMenu();
            } else {
                double depozitte = 25 - balance;
                System.out.println("Your account is inactive, you need to deposit $" + depozitte + " to activate your Saving Account");
                savingMenu();
            }

        } else if (inputSaving == 'C') {
            mySaveAcc.doMonthlyReport();
            savingMenu();
        } else if (inputSaving == 'D') {
            EnterToBank();
        }
    }

    void checkingMenu() {
        System.out.println("Checking Menu");
        System.out.println("A: Deposit");
        System.out.println("B: Withdrawal");
        System.out.println("C: Report");
        System.out.println("D: Return to Bank Menu");

        char inputChecking = scanner.next().charAt(0);
        inputChecking = Character.toUpperCase(inputChecking);

        if (inputChecking == 'A') {
            System.out.println("Please enter your deposit amount:");
            double depoCheck = scanner.nextDouble();
            myCheckAcc.makeDeposit(depoCheck);
            System.out.println("Deposit of $" + depoCheck + " was added to your balance.");
            System.out.println("Your Checking Account balance is $" + myCheckAcc.balance);
            checkingMenu();
        } else if (inputChecking == 'B') {
            System.out.println("Please enter amount of withdraw:");
            double whidrCheck = scanner.nextDouble();
            myCheckAcc.makeWithdraw(whidrCheck);
            if (myCheckAcc.curAccStatus) {
                System.out.println("Your successively withdraw $" + whidrCheck + " from your balance.");
                System.out.println("Your Checking Account balance is $" + myCheckAcc.balance);
                checkingMenu();
            } else {
                double depozitte = 25 - balance;
                System.out.println("Your account is inactive, you need to deposit $" + depozitte + " to activate your Checking Account");
                checkingMenu();
            }

        } else if (inputChecking == 'C') {
            myCheckAcc.doMonthlyReport();
            checkingMenu();
        } else if (inputChecking == 'D') {
            EnterToBank();
        }

    }


    void EnterToBank() {
        System.out.println("BANK MENU");
        System.out.println("Please select on your keyboard one of the options bellow.");
        System.out.println("A: Savings");
        System.out.println("B: Checking");
        System.out.println("C: EXIT");
        char input = scanner.next().charAt(0);
        input = Character.toUpperCase(input);
        if (input == 'A') {
            savingMenu();
        } else if (input == 'B') {
            checkingMenu();
        } else if (input == 'C') {
            System.out.println("EXIT FROM THE BANK");
            System.exit(0);
        } else {
            System.out.println("Operation unknown, please try again.");
            EnterToBank();
        }
    }

}
