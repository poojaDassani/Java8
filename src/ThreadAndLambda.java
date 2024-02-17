public class ThreadAndLambda {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadImplement());
        thread.start();
        Runnable runnable = () -> {
            int i = 0;
            while (i < 100) {
                System.out.println("Hello World using lambda expression...");
                i++;
            }
        };
        Thread thread1 = new Thread(runnable);    // running runnable thread using lambda expression
        thread1.start();
        Thread thread2 = new Thread(() -> System.out.println("Hello World using lambda expression...")); // passing runnable as lambda expression direct to thread
        thread2.start();

    }
}


class ThreadImplement implements Runnable{

    @Override
    public void run() {
        int i = 0;
        while(i< 100) {
            System.out.println("Hello World");
            i++;
        }
    }
}
