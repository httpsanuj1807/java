// public class Test {

//     public static void main(String[] args) {

//         BankAccount sbiAccount = new BankAccount(500);

//         // The technique you are using in the below code is called Anonymous Inner
//         // Class.

//         Runnable thread_task = new Runnable() {

//             @Override
//             public void run() {

//                 sbiAccount.withdraw(50);

//             }

//         };

//         Thread t1 = new Thread(thread_task, "Thread1");
//         Thread t2 = new Thread(thread_task, "Thread2");

//         t1.start();
//         t2.start();

//     }

// }








// Below is using explicit locks
public class Test {

    public static void main(String[] args) {

        BankAccount sbiAccount = new BankAccount(500);

        // The technique you are using in the below code is called Anonymous Inner
        // Class.

        Runnable thread_task = new Runnable() {

            @Override
            public void run() {

                sbiAccount.withdraw(50);

            }

        };

        Thread t1 = new Thread(thread_task, "Thread1");
        Thread t2 = new Thread(thread_task, "Thread2");

        t1.start();
        t2.start();

    }

}