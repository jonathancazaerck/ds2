package ds2;

import java.rmi.RemoteException;

public class ATMConnection {
    String accountNumber;
    Operations operations;

    ATMConnection(String accountNumber, Operations operations) {
        this.accountNumber = accountNumber;
        this.operations = operations;
    }

    public void getBalance() throws RemoteException {
        System.out.println("Your balance is: " + operations.getBalance(accountNumber));
    }

    public void deposit(double amount) throws RemoteException {
        System.out.println("Depositing " + amount);

        operations.deposit(accountNumber, amount);

        getBalance();
    }

    public void withdraw(double amount) throws RemoteException {
        System.out.println("Withdrawing " + amount);

        operations.withdraw(accountNumber, amount);

        getBalance();
    }

}
