public class Main {

    static int incremento = 0;
    public static void main(String[] args) {
        Thread t0 = new Thread(() -> incremento());
        Thread t1 = new Thread(() -> incremento());
        Thread t2 = new Thread(() -> incremento());
        Thread t3 = new Thread(() -> incremento());
        Thread t4 = new Thread(() -> incremento());
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public synchronized static void incremento(){
        System.out.println(Thread.currentThread().getName() + " Valor: " + incremento++);
    }
}