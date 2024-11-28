import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private int count = 0;

    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public void incrementCount() {

        writeLock.lock();
        System.out.println(Thread.currentThread().getName() + " writer lock acquired");
        try {
                count += 1;
                System.out.println(Thread.currentThread().getName() + " increasing count, new count is " + count);
        } finally {
            writeLock.unlock();
        }

    }

    public void getCount() {

        readLock.lock();
        System.out.println(Thread.currentThread().getName() + " read lock acquired");
        try {

            System.out.println(Thread.currentThread().getName() + " reads value " + count);

        } finally {
            readLock.unlock();
        }

    }

    public static void main(String[] args) {

        ReadWriteLockExample countExample = new ReadWriteLockExample();

        Runnable writeTask = new Runnable() {
            
            @Override
            public void run(){
                for(int i = 0; i < 10; i ++){
                    countExample.incrementCount();
                }
            }

        };

        Runnable readTask = new Runnable() {
            
            @Override
            public void run(){
                for(int i = 0; i < 10; i ++){
                    countExample.getCount();
                }
            }

        };

        Thread writeThread = new Thread(writeTask, "WriteThread");
        Thread readThread1 = new Thread(readTask, "ReadThread1");
        Thread readThread2 = new Thread(readTask, "ReadThread2");

        writeThread.start();
        // try{
        //     Thread.sleep(50);
        // }
        // catch(InterruptedException e){

        // }
        readThread1.start();
        readThread2.start();

        try{
            writeThread.join();
            readThread1.join();
            readThread2.join();
        }
        catch(InterruptedException e){
            System.out.println(e);
        }

        System.out.println("Main Thread Completed");

    }

}




/* Key Concepts in Your Code
Read-Write Lock (ReentrantReadWriteLock):

A Read-Write Lock allows multiple threads to read a resource simultaneously (shared access) but ensures that only one thread can write (exclusive access) at a time.
Readers and writers are mutually exclusive, meaning no reading occurs while a write is happening, and vice versa.
Locks:

readWriteLock.readLock():
Acquires a lock for reading (readLock). Multiple threads can hold this lock simultaneously if there’s no writer.
readWriteLock.writeLock():
Acquires a lock for writing (writeLock). Only one thread can hold this lock, and it blocks all readers and writers until released. */