package ds2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class Bank implements Operations {

    HashMap<String,Bankaccount> bankAccounts;

    public Bank(){
        bankAccounts = new HashMap<String,Bankaccount>();
    }

    public void start() {
        try {
            Operations stub = (Operations) UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("operations", stub);

            System.out.println("Bank ready");
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void newBankAccount(String accountnumber, double balance) throws RemoteException{
        bankAccounts.put(accountnumber, new Bankaccount(balance));
    }

    @Override
    public double getBalance(String AccountNumber) throws RemoteException {
        Bankaccount b1 = getBankAccount(AccountNumber);
        return b1.getBalance();
    }

    private void setBalance(String AccountNumber,double newBalance) throws RemoteException {
        try {
            Bankaccount b1 = getBankAccount(AccountNumber);
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

    private Bankaccount getBankAccount(String AccountNumber) throws RemoteException {
        if(bankAccounts.containsKey(AccountNumber))
            return bankAccounts.get(AccountNumber);
        else {
            throw new RemoteException("Bank account not found in hashmap!");
        }
    }
}
