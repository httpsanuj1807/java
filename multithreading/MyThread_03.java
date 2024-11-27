/* public class MyThread_03 extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(600);
                System.out.println("Hello");
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {

        MyThread_03 t = new MyThread_03();

        t.start();
        t.join();

        System.out.println("Hello main finish");

    }

}
 */

/* Setting Thread name here 

public class MyThread_03 extends Thread{    

    public MyThread_03(String name){
        super(name);
    }

    @Override
    public void run(){

        System.out.println(Thread.currentThread().getName() + " - " + Thread.currentThread().getPriority());

    }

    public static void main(String[] args) {
    
        MyThread_03 t = new MyThread_03("Cheetah");
        t.start();
        
    }

}

*/

/* Setting threads priority */
/*
Default priority of a thread is 5
MAX priority is 10
MIN priority is 1 
*/

/*

public class MyThread_03 extends Thread{

    public MyThread_03(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("Thread name is " + Thread.currentThread().getName() + " priority is " + Thread.currentThread().getPriority());
    }

    public static void main(String args[]){

        MyThread_03 t1 = new MyThread_03("Low Priority Thread");
        MyThread_03 t2 = new MyThread_03("Normal Priority Thread");
        MyThread_03 t3 = new MyThread_03("High Priority Thread");
        t1.setPriority(MIN_PRIORITY);
        t2.setPriority(NORM_PRIORITY);
        t3.setPriority(MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();


    }

}

// Output order will be different everytime if we run, because its is totally dependent on OS
// Thread name is High Priority Thread priority is 10
// Thread name is Low Priority Thread priority is 1
// Thread name is Normal Priority Thread priority is 5

 */








/*
Interrupt method in thread
*/

/*

class MyThread_03 extends Thread {

    @Override
    public void run(){

        try{

        System.out.println("Thread is running before sleep");
        Thread.sleep(2000);
        System.out.println("Thread is running after sleep");

        }
        catch(InterruptedException e){
            System.out.println("Thread is interrputed: " + e);
        }

    }

    public static void main(String[] args) {
        
        MyThread_03 t = new MyThread_03();
        t.start();
        t.interrupt();

    }

}

*/









/* Yeild method in thread */

/* 
A hint to the scheduler that the current thread is willing to yield its current use of a processor. The scheduler is free to ignore this hint.

Yield is a heuristic attempt to improve relative progression between threads that would otherwise over-utilise a CPU. Its use should be combined with detailed profiling and benchmarking to ensure that it actually has the desired effect.

Thread 1 is running
Thread 2 is running
Thread 1 is running
Thread 2 is running
Thread 1 is running
Thread 2 is running
Thread 1 is running
Thread 2 is running
Thread 1 is running
Thread 2 is running


*/

/*

public class MyThread_03 extends Thread{

    MyThread_03(String name){
        super(name);
    }

    @Override
    public void run(){

       for(int i = 0; i < 5; i++){

        System.out.println(Thread.currentThread().getName() + " is running");
        Thread.yield();

       }

    }

    public static void main(String[] args) {

        MyThread_03 t1 = new MyThread_03("Thread 1");
        MyThread_03 t2 = new MyThread_03("Thread 2");
        t1.start();
        t2.start();

    }

}

*/









/* User threads and daemon threads  */

/*

User Threads
Definition: Threads explicitly created by the user. These threads execute application-level tasks.
JVM Behavior: The JVM waits for all user threads to finish execution before it terminates, even if the main() thread has already completed.

Daemon Threads
Definition: Background threads that typically perform auxiliary or low-priority tasks (e.g., garbage collection).
JVM Behavior: The JVM does not wait for daemon threads to complete before terminating. As soon as all user threads finish, the JVM exits, regardless of the daemon thread's state.
How to Create: A user thread can be turned into a daemon thread by calling setDaemon(true) before starting the thread.

*/

// In the below example main will be complted but still Hello world will be printed 100 times, as JVM will complete the ULT

/*

class UserLevelThread extends Thread{
    @Override

    public void run(){
       
        for(int i = 0; i < 100 ; i++){
            System.out.println("Hello world");
        }

    }
}

public class MyThread_03{

    public static void main(String[] args) {
        
        UserLevelThread t1 = new UserLevelThread();
        t1.start();
        System.out.println("Main completed");

    }

}

*/



// In the below example of Daemon Level Thread Hello World be stopped printing as soon as the main thread is completed.
/*

class DaemonLevelThread extends Thread{
    @Override

    public void run(){
       
        for(int i = 0; i < 100 ; i++){
            System.out.println("Hello world");
        }

    }
}

public class MyThread_03{

    public static void main(String[] args) {
        
        DaemonLevelThread t1 = new DaemonLevelThread();
        t1.setDaemon(true);
        t1.start();
        // try {
        //     Thread.sleep(1);
        // } catch (Exception e) {
        //     System.out.println(e);
        // }
        System.out.println("Main completed");

    }

}

*/