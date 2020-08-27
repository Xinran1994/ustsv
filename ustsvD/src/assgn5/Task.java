package assgn5;

public class Task implements Runnable {
	 
    private int num;
 
    public Task(int n) {
        num = n;
    }
 
    public void run() {
        System.out.println("Task " + num + " is running.");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("end task " + num);
    }
}
