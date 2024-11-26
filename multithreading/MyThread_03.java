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