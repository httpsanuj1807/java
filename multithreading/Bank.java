import java.util.Random;


public class Bank {

    private String account_name;
    private int balance;

    Bank(String name, int initialBalance){

        this.account_name = name;
        this.balance = initialBalance;
    }

    public synchronized void withdrawAmt(int amt){

        System.out.println(Thread.currentThread().getName() + " is trying to withdraw amount: " + amt);
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if(balance >=  amt){
            balance -= amt;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Current balance: " + balance);

        }
        else{

            System.out.println(Thread.currentThread().getName() + " cannot withdraw " + amt + " due to insufficient balance. Current balance: " + balance);

        }

    }


    public synchronized void depositAmt(int amt){

        System.out.println(Thread.currentThread().getName() + " is depositing: " + amt);
        balance += amt;
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " completed deposit. Current balance: " + balance);

    }
    
    public static void main(String[] args) {
        

        Bank bank = new Bank("HDFC", 0);

        Runnable withdrawTask = new Runnable(){

            @Override

            public void run(){

                
                Random random = new Random();

                for(int i = 0; i < 5; i++){
                    int amt = random.nextInt(100) + 1;
                    bank.withdrawAmt(amt);
                }

            }

        };

        Runnable depositTask = new Runnable(){

            @Override

            public void run(){

                Random random = new Random();

                for(int i = 0; i < 5; i++){

                    int amt = random.nextInt(100) + 1; 
                    bank.depositAmt(amt);

                }

                
            }


        };

        Thread withdraw = new Thread(withdrawTask, "Withdraw Process");
        Thread deposit = new Thread(depositTask, "Deposit Process");

        deposit.start();
        withdraw.start();
        

        try{

            withdraw.join();
            deposit.join();

        }
        catch(InterruptedException e){

            System.out.println("Exception" +  e.getMessage());

        }

        System.out.println("Program Completed");



    }

}
