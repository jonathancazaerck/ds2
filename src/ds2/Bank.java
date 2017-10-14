package ds2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class Bank extends UnicastRemoteObject implements Operations {

    HashMap<String, BankAccount> bankAccounts;

    public Bank() throws RemoteException {
        super();
        bankAccounts = new HashMap<String, BankAccount>();
    }

    public static void main(String[] args) {
        try {
            Registry vRegistry = LocateRegistry.getRegistry();
            vRegistry.bind(Operations.class.getName(), new Bank());
            System.out.println("Bank ready");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void newBankAccount(String accountnumber, double balance) throws RemoteException {
        bankAccounts.put(accountnumber, new BankAccount(balance));
    }

    @Override
    public double getBalance(String AccountNumber) throws RemoteException {
        BankAccount b1 = getBankAccount(AccountNumber);
        return b1.getBalance();
    }

    private void setBalance(String AccountNumber, double newBalance) throws RemoteException {
        try {
            BankAccount b1 = getBankAccount(AccountNumber);
            b1.setBalance(newBalance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deposit(String AccountNumber, double amount) throws RemoteException {
        double newBalance = getBalance(AccountNumber) - amount;
        setBalance(AccountNumber,amount);
    }

    @Override
    public void withdraw(String AccountNumber, double amount) throws RemoteException {
        double newBalance = getBalance(AccountNumber) + amount;
        setBalance(AccountNumber,amount);
    }

    private BankAccount getBankAccount(String AccountNumber) throws RemoteException {
        if(bankAccounts.containsKey(AccountNumber))
            return bankAccounts.get(AccountNumber);
        else {
            throw new RemoteException("Bank account not found in hashmap!");
        }
    }
}
