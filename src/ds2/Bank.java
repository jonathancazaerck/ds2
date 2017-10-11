package ds2;

import java.rmi.RemoteException;
import java.util.HashMap;

public class Bank implements Operations {

    HashMap<String,Bankaccount> Bankaccounts;

    public Bank(){
        Bankaccounts = new HashMap<String,Bankaccount>();
    }

    @Override
    public void newBankAccount(String accountnumber, double balance) throws RemoteException{
        Bankaccounts.put(accountnumber, new Bankaccount(balance));
    }

    @Override
    public double getBalance(String AccountNumber) throws RemoteException, Exception {
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
    public void deposit(String AccountNumber, double amount) throws RemoteException, Exception {
        double newBalance = getBalance(AccountNumber) - amount;
        setBalance(AccountNumber,amount);
    }

    @Override
    public void withdraw(String AccountNumber, double amount) throws RemoteException, Exception {
        double newBalance = getBalance(AccountNumber) + amount;
        setBalance(AccountNumber,amount);
    }

    private Bankaccount getBankAccount(String AccountNumber) throws Exception{
        if(Bankaccounts.containsKey(AccountNumber))
            return Bankaccounts.get(AccountNumber);
        else {
            throw new Exception ("Bank account not found in hashmap!");
        }
    }
}
