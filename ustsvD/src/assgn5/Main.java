package assgn5;


public class Main {
	 
    public static void main(String[] args) {
        threadPool pool = new threadPool(5);
 
        for (int i = 0; i < 20; i++) {
            Task task = new Task(i);
            pool.execute(task);
        }
    }
}
