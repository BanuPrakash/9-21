package vt;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

// like JDBC, blocking code
public class SimpleWork {
    AtomicLong id = new AtomicLong();
    ReentrantLock lock = new ReentrantLock(); // java 1.5 instead of synchronized

    public String doJob() {
        String response = null;
        lock.lock();
        try {
            Thread.sleep(1000);
            response = "Ping_" + id.incrementAndGet();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
        return  response;
    }

}
