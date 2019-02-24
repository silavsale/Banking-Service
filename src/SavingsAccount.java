class SavingAccount extends Account {

    String SavingsAccountClassInfo = "This is SavingsAccount Class";
    String msgInactAcc = "The account is inactive, you need to have 25$ on your balance.";

    // subclass constructor:
    SavingAccount() {
    }

    // superclass parameterized constructor:
    SavingAccount(double constrBalance, double constrAnnualInterestRate) {
        super(constrBalance, constrAnnualInterestRate);
    }

    public void makeWithdraw(double withdrawal) {
        if (curAccStatus) {
            super.makeWithdraw(withdrawal);
            if (balance < 25) {
                curAccStatus = false;
            }
        } else {
            System.out.println(msgInactAcc);
        }
    }

    public void makeDeposit(double deposit) {
        if (!curAccStatus && (balance + deposit) >= 25) {
            curAccStatus = true;
            super.makeDeposit(deposit);
            System.out.println("Account active again");
        } else if (curAccStatus) {
            super.makeDeposit(deposit);
        } else {
            System.out.println(msgInactAcc);
        }
    }

    public void doMonthlyReport() {
        //        balance = balance - serviceCharge;
        //        calculateInterest();
        //        numWithDrawThMth = 0;
        //        numDepsThMth = 0;
        //        serviceCharge = 0;
        if (numWithDrawThMth > 4) {
            serviceCharge = serviceCharge + numWithDrawThMth;
            super.doMonthlyReport();

        }
        super.doMonthlyReport();
    }

}
