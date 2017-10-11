package ds2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Operations extends Remote {
    double getBalance(String AccountNumber) throws RemoteException, Exception;
    void deposit(String AccountNumber,double amount) throws Exception;
    void withdraw(String AccountNumber,double amount) throws RemoteException, Exception;
    void newBankAccount(String AccountNumber, double balance) throws RemoteException;
}
