package foo.bar.day01.lab08;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by blvp on 06.04.15.
 */
public class TransactionBeanPostProccessor implements BeanPostProcessor {
    Map<String, Class<?>> classes = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        Transactional annotation = bean.getClass().getAnnotation(Transactional.class);
        if(annotation != null){
            classes.put(beanName, bean.getClass());
        }
        return bean;

    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {

        if(classes.containsKey(beanName)){
            Class<?> clazz = classes.get(beanName);
            return Proxy.newProxyInstance(
                    clazz.getClassLoader(),
                    clazz.getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                            System.out.println("transaction start");
                            Object result = method.invoke(bean, objects);
                            System.out.println("transaction commit");
                            return result;
                        }
                    });
        } else {
            return bean;
        }
    }
}
