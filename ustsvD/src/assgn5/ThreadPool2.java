package assgn5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool2 {

    private LinkedBlockingQueue taskQueue;
    private List<poolThread2> threads = new ArrayList<poolThread2>();
    private boolean isStopped = false;

    public ThreadPool2(int noOfThreads, int maxNoOfTasks){
        taskQueue = new LinkedBlockingQueue(maxNoOfTasks);

        for(int i=0; i<noOfThreads; i++){
            threads.add(new poolThread2(taskQueue));
        }
        for(poolThread2 thread : threads){
            thread.start();
        }
    }

    public synchronized void  execute(Runnable task) throws Exception{
        if(this.isStopped) throw
            new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.add(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(poolThread2 thread : threads){
           thread.doStop();
        }
    }

}