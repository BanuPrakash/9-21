package hidden;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class HiddenClassExample {
    public static void main(String[] args) throws  Throwable{
        BusinessService service = new BusinessService();

        // Dynamically create telemetry interceptor class bytecode
        // we need a byte[]
        Path path = Paths.get("/Users/banuprakash/IdeaProjects/CISCO/9-21/workspace/java21/out/production/java21/hidden/TelemetryInterceptor.class");

        byte[] classfileBytes = Files.readAllBytes(path);

//        String BASE_64 = Base64.getEncoder().encodeToString(classfileBytes);
//        byte[] telemetryClassBytes = Base64.getDecoder().decode(BASE_64);

        // Define HiddenClass
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        var hidden = lookup.defineHiddenClass(classfileBytes, true,
                MethodHandles.Lookup.ClassOption.NESTMATE);

        Class<?> interceptorClass = hidden.lookupClass();

        // instantiate hidden class
        Object interceptor = interceptorClass.getConstructor().newInstance();
        Method method = interceptorClass.getMethod("intercept", Object.class, Method.class);

        // intercept a method call

        Method targetMethod = BusinessService.class.getMethod("processTransaction");
        method.invoke(interceptor, service, targetMethod);
    }
}
