class Printer {

    private boolean canUserConsume;

    Printer(boolean flag) {
        this.canUserConsume = flag; 
    }

    public synchronized void printNewPage() {
        while (canUserConsume) { 
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        try {
            Thread.sleep(1500); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        canUserConsume = true;
        System.out.println(Thread.currentThread().getName() + " has finished printing the page.");
        notify(); 
    }

    public synchronized void consumePage() {
        while (!canUserConsume) { 
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        canUserConsume = false; 
        System.out.println(Thread.currentThread().getName() + " has consumed the page.");
        notify(); 
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        boolean canUserConsume = false; // Initial state: no page available to consume

        Printer printer = new Printer(canUserConsume);

        Runnable printPaper = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    printer.printNewPage();
                }
            }
        };

        Runnable usePaper = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    printer.consumePage();
                }
            }
        };

        Thread printerThread = new Thread(printPaper, "Printer");
        Thread userThread = new Thread(usePaper, "User");

        printerThread.start();
        userThread.start();

        try {
            printerThread.join();
            userThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("Program Completed.");
    }
}
