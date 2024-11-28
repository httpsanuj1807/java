import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    
    private final Lock lock = new ReentrantLock();

    public void outerMethod(){

        lock.lock();

        try{

            System.out.println("Outer Method");
            innerMethod();

        } 
        finally{
            lock.unlock();
        }

    }

    public void innerMethod(){

        lock.lock();

        try{

            System.out.println("Inner Method");

        } 
        finally{
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        
        ReentrantExample example = new ReentrantExample();
        example.outerMethod();

    }

}

/*
 Learn about the ReentrantLock and Lock Fairness ?

What Are Reentrant Locks in Java?
A ReentrantLock in Java is a type of lock provided in the java.util.concurrent.locks package that allows a thread to acquire the lock multiple times without getting stuck. This makes it more flexible than the basic synchronized keyword.


Why is it called "Reentrant"?
The term "reentrant" means that a thread can re-enter the same lock it already holds. If a thread acquires a ReentrantLock, it can safely lock it again without causing a deadlock, as long as it unlocks it the same number of times. */



/*

When outerMethod() is called, the thread acquires the lock using lock.lock().
Inside outerMethod(), innerMethod() is called, which also tries to acquire the same lock.

When innerMethod() is executed, it calls lock.lock() again, even though the same thread already holds the lock.
Thanks to reentrancy, the same thread is allowed to acquire the lock multiple times without causing a deadlock.



Reentrant Behavior
What is Happening?

When outerMethod() acquires the lock (lock.lock()), the thread becomes the owner of the lock.
When innerMethod() is called and tries to acquire the same lock, it is allowed because the same thread already owns the lock.
The ReentrantLock maintains a lock count:
When outerMethod() calls lock.lock(), the count is incremented to 1.
When innerMethod() calls lock.lock(), the count is incremented to 2.

Releasing the Lock:
Both outerMethod() and innerMethod() have their own try-finally blocks with lock.unlock().
When innerMethod() completes, its lock.unlock() decrements the lock count to 1.
When outerMethod() completes, its lock.unlock() decrements the count to 0, fully releasing the lock.


Why Does Reentrancy Matter?
If ReentrantLock did not support reentrancy:

When innerMethod() tried to call lock.lock(), it would block or deadlock, even though the lock is held by the same thread.
Reentrant behavior ensures that:

The same thread can acquire the lock multiple times, as long as it releases it the same number of times.

*/



