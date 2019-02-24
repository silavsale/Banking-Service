class CheckingAccount extends Account {
    String CheckingAccountClassInfo = "This is CheckingAccount Class";

    CheckingAccount() {

    }

    CheckingAccount(double balance, double interest){
        super(balance, interest);
    }

    public void makeWithdraw(double withdrawal) {
        if ((balance - withdrawal) < 0) {
            balance -= 15;
        } else {
            super.makeWithdraw(withdrawal);
        }
    }

    public void doMonthlyReport() {
        serviceCharge += 15;
        serviceCharge += (numWithDrawThMth *= 0.1);
        super.doMonthlyReport();
    }

}


