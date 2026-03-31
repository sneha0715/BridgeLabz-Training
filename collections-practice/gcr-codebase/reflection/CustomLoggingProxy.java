import java.lang.reflect.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogMe {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TimeIt {
}

interface Greeting {
    void sayHello();
    void sayGoodbye();
    String greet(String name);
}

class GreetingImpl implements Greeting {
    @LogMe
    @Override
    public void sayHello() {
        System.out.println("Hello from implementation!");
    }
    
    @Override
    public void sayGoodbye() {
        System.out.println("Goodbye!");
    }
    
    @TimeIt
    @Override
    public String greet(String name) {
        return "Greetings, " + name + "!";
    }
}

class InvocationHandler implements java.lang.reflect.InvocationHandler {
    private Object target;
    
    public InvocationHandler(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[PROXY LOG] Method called: " + method.getName());
        
        if (method.isAnnotationPresent(LogMe.class)) {
            System.out.println("[ANNOTATION] @LogMe detected on method: " + method.getName());
        }
        
        if (method.isAnnotationPresent(TimeIt.class)) {
            long startTime = System.nanoTime();
            Object result = method.invoke(target, args);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000;
            System.out.println("[TIMING] Method " + method.getName() + " took " + duration + " ms");
            return result;
        }
        
        return method.invoke(target, args);
    }
}

public class CustomLoggingProxy {
    
    public static <T> T createProxy(T target, Class<T> interfaceClass) {
        InvocationHandler handler = new InvocationHandler(target);
        
        @SuppressWarnings("unchecked")
        T proxy = (T) Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class[]{interfaceClass},
            handler
        );
        
        return proxy;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Custom Logging Proxy Using Reflection ===\n");
        
        GreetingImpl greetingImpl = new GreetingImpl();
        Greeting greetingProxy = createProxy(greetingImpl, Greeting.class);
        
        System.out.println("--- Direct Method Calls (via Proxy) ---");
        greetingProxy.sayHello();
        
        System.out.println();
        greetingProxy.sayGoodbye();
        
        System.out.println();
        String result = greetingProxy.greet("Alice");
        System.out.println("Result: " + result);
        
        System.out.println("\n--- Another Example ---");
        greetingProxy.greet("Bob");
    }
}
