/*
 

public class LambdaExpression {
    
    
    public static void main(String[] args) {
        
        Runnable task = new Runnable(){
            @Override
            public void run(){

                System.out.println("Hello");
                
            }

        };
        
        Thread t = new Thread(task);
        t.start();
    }
    

}

*/

// Above is the one way of creating and implementing threads in java, above method is called using a Runnable interface with an anonymous inner class. 

// Below method of implementing thread is -> Implementing thread by extending Thread class

/* 
 
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.start(); // Starts a new thread and executes the `run` method
    }
}

*/

// The above two method is what we have learned so far in this java learning. Now we will a latest method of implementing thread.

// Those interfaces which have single abstract method are known as functional interfaces.

/*
@FunctionalInterface
public interface Runnable {
    void run();
}
*/


/*
 
public class LambdaExpression {
    
    public static void main(String[] args) {

        // Runnable task = () -> {

        //     System.out.println("Hello");

        // };
        // Thread t = new Thread(task);



        // can be done as
        // Runnable task = () -> System.out.println("Hello");
        // Thread t = new Thread(task);



        // or can be done as 
        Thread t = new Thread(() -> System.out.println("Hello"));
        t.start();

    }

};

*/







// Another example of lambda expression

