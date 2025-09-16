package hidden;

public class BusinessService {
    public void processTransaction() {
        System.out.println("Processing Tx...");
        try {
            // actual logic
             Thread.sleep((long)(Math.random() * 1000) );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
