/**
 * Created by prasanthnair on 12/27/15.
 */
public class ThreadTermination implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread running.");
//        for (int i = 0; i < Integer.MAX_VALUE; i++) ;
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ending.");
    }

    public static void main(String[] args) {
        ThreadTermination t1 = new ThreadTermination();
        ThreadTermination t2 = new ThreadTermination();

        Thread thr1 = new Thread(t1);
        System.out.println("Thread 1 starting.");
        thr1.start();
        Thread thr2 = new Thread(t2);
        System.out.println("Thread 2 starting.");
        thr2.start();

        System.out.println("Main thread finished.");
//        return;
//        System.exit(0);
    }
}
