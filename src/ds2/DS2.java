package ds2;

public class DS2 {

    public static void main(String args[]) {
        if (args[0].equals("bank")) {
            new Bank().start();
        } else if (args[0].equals("atm")) {
            ATM atm = new ATM();
            if (args[1].equals("deposit")) {
                ATMConnection connection = atm.createATMConnection(args[2]);
                connection.deposit(Double.parseDouble(args[3]));
            } else if (args[1].equals("withdraw")) {
                ATMConnection connection = atm.createATMConnection(args[2]);
                connection.withdraw(Double.parseDouble(args[3]));
            } else {
                printUsage();
            }
        } else {
            printUsage();
        }
    }

    public static void printUsage() {
        System.out.println("ds2 bank");
        System.out.println("ds2 atm deposit BE123 10");
        System.out.println("ds2 atm withdraw BE123 10");
    }
}
