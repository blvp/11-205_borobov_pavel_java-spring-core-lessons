package foo.bar.lab01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by blvp on 06.04.15.
 */
public class ObjectFactory {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazzToInstantiate = Class.forName(args[0]);
        Object object = clazzToInstantiate.newInstance();
        System.out.println(object);
        for (Method method : clazzToInstantiate.getMethods()) {
            RunThisMethod annotation = method.getAnnotation(RunThisMethod.class);
            if (annotation != null) {
                int repeat = annotation.repeat();
                for (int i = 0; i < repeat; i++) {
                    method.invoke(object);
                }
            }
        }
    }
}

