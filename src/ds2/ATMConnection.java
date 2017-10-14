package ds2;

public class ATMConnection {
    String accountNumber;

    ATMConnection(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void getBalance(){
        System.out.println("Your balance is: ");
    }

    public void deposit(double amount){
        System.out.println("Deposit: ");
    }

    public void withdraw(double amount){
        System.out.println("Withdraw: ");
    }

}
