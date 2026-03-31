import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class HeavyCalculator {

    @CacheResult
    public long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 5_000_000; j++);
            result *= i;
        }
        return result;
    }
}

class CacheExecutor {
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invoke(Object obj, String methodName, Class<?>[] paramTypes, Object[] args) throws Exception {
        Method method = obj.getClass().getMethod(methodName, paramTypes);
        String key = methodName + "_" + args[0];

        if (method.isAnnotationPresent(CacheResult.class)) {
            if (cache.containsKey(key)) {
                System.out.println("Returning cached result");
                return cache.get(key);
            } else {
                Object result = method.invoke(obj, args);
                cache.put(key, result);
                System.out.println("Computed and cached result");
                return result;
            }
        } else {
            return method.invoke(obj, args);
        }
    }
}

public class CacheDemo {
    public static void main(String[] args) throws Exception {
        HeavyCalculator calc = new HeavyCalculator();

        System.out.println(CacheExecutor.invoke(calc, "factorial", new Class[]{int.class}, new Object[]{5}));
        System.out.println(CacheExecutor.invoke(calc, "factorial", new Class[]{int.class}, new Object[]{5}));
        System.out.println(CacheExecutor.invoke(calc, "factorial", new Class[]{int.class}, new Object[]{6}));
    }
}
