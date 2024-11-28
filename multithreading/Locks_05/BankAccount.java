// public class BankAccount {

//     private int balance;

//     BankAccount(int balance) {

//         this.balance = balance;

//     }

//     public synchronized void withdraw(int amount) {

//         System.out.println(Thread.currentThread().getName() + " attempting to withdraw money " + amount);

//         if (balance < amount) {
//             System.out.println(Thread.currentThread().getName() + "insufficeint balance " + balance);
//             System.out.println();
//         } else {
//             System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal " + amount);

//             try {

//                 Thread.sleep(4000); // db queries

//             } catch (InterruptedException e) {

//                 System.out.println(e);

//             }

//             balance -= amount;

//             System.out.println(Thread.currentThread().getName() + " withdrawal successfull " + balance);
//             System.out.println();
//         }

//     }

// }








// Below is using explicit locks

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance;

    private static final Lock lock = new ReentrantLock();

    BankAccount(int balance) {

        this.balance = balance;

    }

    public void withdraw(int amount) {

        System.out.println(Thread.currentThread().getName() + " attempting to withdraw money " + amount);

        if (balance < amount) {
            System.out.println(Thread.currentThread().getName() + " insufficient balance " + balance);
        } else {
            try {

                if (lock.tryLock(5000, TimeUnit.MILLISECONDS)) {

                    try {

                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal " + amount);
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " withdrawal successfull " + balance);

                    } catch (Exception e) {

                        Thread.currentThread().interrupt();


                    } finally {
                        lock.unlock();
                    }

                } else {

                    System.out.println(Thread.currentThread().getName() + " could not acqurie lock. Try again later.");

                }

            } catch (Exception e) {

                Thread.currentThread().interrupt();

            }

        }

    }

}