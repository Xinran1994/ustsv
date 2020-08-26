package mThread;


public class mThread extends Thread {
	
	public void run() { // the method is executed after call start()
		System.out.print("mthread running");
	}
	
	public static void main(String[] args) {
		mThread mthread = new mThread();
		mthread.start();
	}
}
