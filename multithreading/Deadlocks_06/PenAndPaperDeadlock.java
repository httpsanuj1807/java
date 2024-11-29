import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Pen {

    private final Lock penLock;
    private final Lock paperLock;

    Pen(Lock penLock, Lock paperLock) {
        this.penLock = penLock;
        this.paperLock = paperLock;
    }

    public void writeWithPenAndPaper() {
        try {
            penLock.lock();
            System.out.println(Thread.currentThread().getName() + " Acquired Pen and waiting for Paper to be available.");
            try {
                paperLock.lock();
                System.out.println(Thread.currentThread().getName() + " Acquired Pen and Paper and started writing.");
            } finally {
                paperLock.unlock();
            }
        } finally {
            penLock.unlock();
        }
    }
};


class Paper {

    private final Lock penLock;
    private final Lock paperLock;

    Paper(Lock penLock, Lock paperLock) {
        this.penLock = penLock;
        this.paperLock = paperLock;
    }

    public void writeWithPaperAndPen() {
        try {
            paperLock.lock();
            System.out.println(Thread.currentThread().getName() + " Acquired Paper and waiting for Pen to be available.");
            try {
                penLock.lock();
                System.out.println(Thread.currentThread().getName() + " Acquired Paper and Pen and started writing.");
            } finally {
                penLock.unlock();
            }
        } finally {
            paperLock.unlock();
        }
    }
};



public class PenAndPaperDeadlock {
    public static void main(String[] args) {

        Lock penLock = new ReentrantLock();
        Lock paperLock = new ReentrantLock();

        Pen penObj = new Pen(penLock, paperLock);
        Paper paperObj = new Paper(penLock, paperLock);

        Runnable writeTaskWithPen = new Runnable() {

            @Override

            public void run() {

                penObj.writeWithPenAndPaper();

            }

        };
        Runnable writeTaskWithPaper = new Runnable() {

            @Override

            public void run() {

                paperObj.writeWithPaperAndPen();

            }

        };

        Thread thread1 = new Thread(writeTaskWithPen, "Thread1HavingPen");
        Thread thread2 = new Thread(writeTaskWithPaper, "Thread2HavingPaper");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("Program Completed.");

    }

}











/* To resolve the deadlock in your code, you need to ensure that both threads acquire locks in the same order. Deadlocks typically occur when multiple threads try to acquire multiple locks in different orders. By standardizing the locking order, you can eliminate the deadlock.

Here’s how to fix the issue:

Fixed Code:
The solution is to ensure both Pen and Paper acquire the locks in the same order: first penLock, then paperLock. */


// Corrected Code below




// import java.util.concurrent.locks.Lock;
// import java.util.concurrent.locks.ReentrantLock;

// class Pen {

//     private final Lock penLock;
//     private final Lock paperLock;

//     Pen(Lock penLock, Lock paperLock) {
//         this.penLock = penLock;
//         this.paperLock = paperLock;
//     }

//     public void writeWithPenAndPaper() {
//         try {
//             penLock.lock();
//             System.out.println(Thread.currentThread().getName() + " Acquired Pen and waiting for Paper to be available.");
//             try {
//                 paperLock.lock();
//                 System.out.println(Thread.currentThread().getName() + " Acquired Pen and Paper and started writing.");
//             } finally {
//                 paperLock.unlock();
//             }
//         } finally {
//             penLock.unlock();
//         }
//     }
// };


// class Paper {

//     private final Lock penLock;
//     private final Lock paperLock;

//     Paper(Lock penLock, Lock paperLock) {
//         this.penLock = penLock;
//         this.paperLock = paperLock;
//     }

//     public void writeWithPaperAndPen() {
//         try {
//             penLock.lock();
//             System.out.println(Thread.currentThread().getName() + " Acquired Paper and waiting for Pen to be available.");
//             try {
//                 paperLock.lock();
//                 System.out.println(Thread.currentThread().getName() + " Acquired Paper and Pen and started writing.");
//             } finally {
//                 paperLock.unlock();
//             }
//         } finally {
//             penLock.unlock();
//         }
//     }
// };



// public class PenAndPaperDeadlock {
//     public static void main(String[] args) {

//         Lock penLock = new ReentrantLock();
//         Lock paperLock = new ReentrantLock();

//         Pen penObj = new Pen(penLock, paperLock);
//         Paper paperObj = new Paper(penLock, paperLock);

//         Runnable writeTaskWithPen = new Runnable() {

//             @Override

//             public void run() {

//                 penObj.writeWithPenAndPaper();

//             }

//         };
//         Runnable writeTaskWithPaper = new Runnable() {

//             @Override

//             public void run() {

//                 paperObj.writeWithPaperAndPen();

//             }

//         };

//         Thread thread1 = new Thread(writeTaskWithPen, "Thread1HavingPen");
//         Thread thread2 = new Thread(writeTaskWithPaper, "Thread2HavingPaper");

//         thread1.start();
//         thread2.start();

//         try {
//             thread1.join();
//             thread2.join();
//         } catch (InterruptedException e) {
//             System.out.println("Thread interrupted: " + e.getMessage());
//         }

//         System.out.println("Program Completed.");

//     }

// }
