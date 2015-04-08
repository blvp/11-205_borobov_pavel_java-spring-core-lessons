package foo.bar.day01.lab07;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by blvp on 06.04.15.
 */
public class BenchmarkBeanPostProccessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(final Object bean, String s) throws BeansException {
        Class<?> clazz = bean.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

                if(bean.getClass().getMethod(method.getName(), method.getParameterTypes()).getAnnotation(Benchmark.class) != null){
                    Object result;
                    long startTime = System.nanoTime();
                    result = method.invoke(bean);
                    System.out.println("Invocation time: " + (System.nanoTime() - startTime));
                    return result;
                }
                return method.invoke(bean);
            }
        });
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
