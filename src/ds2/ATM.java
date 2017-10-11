package ds2;

public class ATM {

    private String accountNumber;

    public ATM(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public void getBalance(){
        System.out.println("Your balance is: ");
    }

    public void deposit(){
        System.out.println("Deposit: ");
    }

    public void withdraw(){
        System.out.println("Withdraw: ");
    }

}
