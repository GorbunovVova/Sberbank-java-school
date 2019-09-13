import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fibonacci {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        if (args.length != 0) {
            int n = Integer.parseInt(args[0]);
            int current = 1;
            int next = 1;
            int temp;
            for (int i = 0; i < n; i++) {
                System.out.print(current + " ");
                temp = current;
                current = next;
                next += temp;
            }
            System.out.println();
        }
        Logger log = LoggerFactory.getLogger(Fibonacci.class);
        log.info(System.currentTimeMillis() - startTime + " ms");
    }
}