package foo.bar.lab03;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * Created by blvp on 07.04.15.
 */
public class PrototypeReplacementBeanPostProccessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
