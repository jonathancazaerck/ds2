package ds2;

public class Bankaccount {

    private double balance;



    public Bankaccount(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double newBalance){
        balance = newBalance;
    }

}
