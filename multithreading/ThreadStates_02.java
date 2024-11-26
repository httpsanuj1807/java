/*

Thread States in Java

1. NEW -> Thread is just created
2. RUNNABLE ->  Start has been called but run is not yet started by OS
3. RUNNING -> Currently running run function
4. WAITING/BLOCKED -> Waiting for some other process or thread
5. TERMINATED -> When run function completes

*/


public class ThreadStates_02 extends Thread {
 
    @Override
    public void run(){

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.err.println("RUNNING");

    }

    public static void main(String args[]) throws InterruptedException{


        ThreadStates_02 t1 = new ThreadStates_02();
        System.out.println(t1.getState());              // NEW
        t1.start();
        System.out.println(t1.getState());              // RUNNABLE
        Thread.sleep(100);                              // Main thread is sleep here for 200 ms
        System.out.println(t1.getState());              // TIMED WAITING
        t1.join();                                      // Here main thread will wait for t1 to finish and then will only continue ahead
        System.out.println(t1.getState());              // TERMINATED
        


    }



}

/*

Order of sequence of the above code, order may change, but in case of above code it will be sure 99%

NEW
RUNNABLE
TIMED_WAITING
RUNNING
TERMINATED

*/



