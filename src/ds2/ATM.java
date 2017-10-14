package ds2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ATM {
    private String accountNumber;

    public ATMConnection createATMConnection(String accountNumber, Operations vOperations) {
        return new ATMConnection(accountNumber, vOperations);
    }

    public static void main(String args[]) {
        if (args[0] == null || args[1] == null) {
            printUsage();
            return;
        }

        String operationType = args[0];
        String accountNumber = args[1];

        try {
            Registry vRegistry = LocateRegistry.getRegistry();

            Operations vOperations = (Operations) vRegistry.lookup(Operations.class.getName());

            ATMConnection vConnection = new ATM().createATMConnection(accountNumber, vOperations);

            if (operationType.equals("deposit")) {
                if (args[2] == null) {
                    printUsage();
                    return;
                }
                double amount = Double.parseDouble(args[2]);
                vConnection.deposit(amount);
            } else if (operationType.equals("withdraw")) {
                if (args[2] == null) {
                    printUsage();
                    return;
                }
                double amount = Double.parseDouble(args[2]);
                vConnection.withdraw(amount);
            } else if (operationType.equals("balance")) {
                vConnection.getBalance();
            } else {
                printUsage();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public static void printUsage() {
        System.out.println("atm deposit BE123 10");
        System.out.println("atm withdraw BE123 10");
        System.out.println("atm balance BE123");
    }
}
