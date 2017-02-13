import java.util.concurrent.CopyOnWriteArrayList;

public class TestThread {

    public static void main(String args[]) {
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add(54);
        list.add(52);
        ThreadDemo T1 = new ThreadDemo( "Thread-1", list);
        T1.start();

        list.forEach(item -> System.out.println(item));

    }
}
