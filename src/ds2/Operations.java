package ds2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Operations extends Remote {
    double getBalance(String accountNumber) throws RemoteException;
    void deposit(String accountNumber, double amount) throws RemoteException;
    void withdraw(String accountNumber, double amount) throws RemoteException;
    void newBankAccount(String accountNumber, double balance) throws RemoteException;
}
