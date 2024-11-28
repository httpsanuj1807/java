import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairUnfairLocks {


    private Lock lock = new ReentrantLock(true);

    public void accessResource(){

        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        finally{
            System.out.println(Thread.currentThread().getName() + " released the lock.");
            lock.unlock();
        }

    }


    public static void main(String[] args) {
        
        FairUnfairLocks lock = new FairUnfairLocks();

        Runnable task = new Runnable(){
            @Override
            public void run(){

                lock.accessResource();

            }
        };

        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");
        Thread t3 = new Thread(task, "Thread3");

        t1.start();
        t2.start();
        t3.start();

        
    }
    

}

// go through the theory 

/*

Fairness in Reentrant Locks
In Java's ReentrantLock, fairness refers to the order in which threads are allowed to acquire the lock. The fairness policy determines whether the lock grants access to threads in a first-come-first-served manner (fair) or not (unfair, which is the default).



Fair Lock (FIFO):

Threads acquire the lock in the order they requested it.
If multiple threads are waiting, the one that has been waiting the longest gets the lock first.
This ensures no thread is starved



Unfair Lock (Default):

Threads can acquire the lock out of order, potentially favoring certain threads over others.
This can result in better performance because a thread already running might acquire the lock again faster than waiting threads.



How Fairness Affects Thread Behavior

Fair Lock Behavior:
Threads queue up, and each thread is served one at a time in the order of arrival.
Guarantees predictable behavior, useful in applications where fairness is critical.

Unfair Lock Behavior:
Threads do not strictly follow the queue.
A newly arrived thread can "cut in line" if the lock becomes available when it's trying to acquire it.
This can result in better throughput at the cost of fairness.




Use Fair Locks:
When fairness is critical (e.g., in systems where starvation must be avoided).
Useful in real-time systems where predictable thread execution is needed.


Use Unfair Locks:
When performance is a priority.
In cases where the system can tolerate some level of unfairness, as unfair locks often lead to higher throughput due to reduced contention.


Trade-offs
Feature	                    Fair Lock	                    Unfair Lock
Order	            First-come-first-served	            Random/Unpredictable
Performance	        Slower (thread queueing)	        Faster (fewer delays)
Starvation	        No thread starvation	            Possible thread starvation


 

*/
