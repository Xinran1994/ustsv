package mThread;

public class twoThread implements Runnable {
	
	private int counter = 0;
	
	public void run() {
		while(counter < 100) {
			synchronized(this){
				this.counter++;
				System.out.println(counter);
			}
        }
	}
	
	
	public static void main(String[] args) {
		Runnable runnable1 = new twoThread();
		Runnable runnable2 = new twoThread();
		
		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);
		
	
		thread1.start();
		thread2.start();
	}
	
}
