package ds2;

public class ATM {

    private String accountNumber;

    public ATM(){
    }

    public ATMConnection createATMConnection(String accountNumber) {
        return new ATMConnection(accountNumber);
    }
}
