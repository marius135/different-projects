import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

class ThreadDemo extends Thread {
    private final String threadName;
    private Thread t;
    CopyOnWriteArrayList list;

    ThreadDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public ThreadDemo(String s, CopyOnWriteArrayList list) {
        threadName = s;
        this.list = list;
    }

    public void run() {
        System.out.println("Running " +  threadName );
        list.add(33);
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

