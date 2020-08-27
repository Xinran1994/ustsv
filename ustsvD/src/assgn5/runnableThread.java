package assgn5;

public class runnableThread implements Runnable {
	
	public void run() {
		System.out.println("runnable running1!");
	}
	
	public static void main(String[] args) {
		
		// 1. pass an instance of a class
		Runnable runnable1 = new runnableThread(); 
		
		// 2. anonymous class
		Runnable runnable2 = new Runnable() { 
			public void run() {
				System.out.println("runnable running2!");
			}
		};
		
		// 3. lambda expression 
		Runnable runnable3 = () -> {System.out.println("runnable running3!");};
		
		Thread mthread1 = new Thread(runnable1);
		Thread mthread2 = new Thread(runnable2, "new thread");
		Thread mthread3 = new Thread(runnable3);
		mthread1.start();
		mthread2.start();
		mthread3.start();
		System.out.println(mthread2.getName());
	}
}
