package hidden;

import java.lang.reflect.Method;

// @Around("execution(* com.cisco.prj.service.*.*(...)))
// public void logBefore(JoinPoint jp) ..

// cross cutting concern
public class TelemetryInterceptor {
    public void intercept(Object target, Method method) throws  Exception {
        long start = System.nanoTime();
            method.invoke(target); // actual method
        long end = System.nanoTime();
        System.out.println("Execution Time: " + (end - start)/1_000_000 + " ms");
    }
}
