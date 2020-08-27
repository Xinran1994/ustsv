package assgn5;

public class twoThread implements Runnable {
    static int counter = 1; // a global counter

    public twoThread() {
    }

    static synchronized void incrementCounter() {
         System.out.println(Thread.currentThread().getName() + ": " + counter);
         counter++;
    }

    @Override
    public void run() {
         while(counter<1000){
              incrementCounter();
         }
    }

    public static void main(String[] args) {
    	twoThread te = new twoThread();
         Thread thread1 = new Thread(te);
         Thread thread2 = new Thread(te);

         thread1.start();
         thread2.start();          
    }
}