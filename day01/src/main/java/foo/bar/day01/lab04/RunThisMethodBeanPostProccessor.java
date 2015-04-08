package foo.bar.day01.lab04;

import foo.bar.day01.lab01.RunThisMethod;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by blvp on 06.04.15.
 */
public class RunThisMethodBeanPostProccessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (Method method : bean.getClass().getMethods()) {
            RunThisMethod annotation = method.getAnnotation(RunThisMethod.class);
            if (annotation != null) {
                try {
                    for (int i = 0; i < annotation.repeat(); i++) {
                        method.invoke(bean);

                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                return bean;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        return bean;
    }
}
