package foo.bar.day01.lab06;

import foo.bar.day01.lab05.Subject;
import foo.bar.day01.lab05.SubjectImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by blvp on 06.04.15.
 */
public class DynamicProxyTest {
    public static void main(String[] args) throws InterruptedException {
        Subject subject = (Subject) Proxy.newProxyInstance(
                Subject.class.getClassLoader(),
                new Class<?>[]{Subject.class}, new InvocationHandler() {
                    SubjectImpl impl = new SubjectImpl();
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        long startTime = System.nanoTime();
                        Object result = method.invoke(impl, objects);
                        System.out.println("Invocation time: " + (System.nanoTime() - startTime));
                        return result;
                    }
                });

        subject.longMethod();
    }
}
