package foo.bar.day01.lab09;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * Created by blvp on 06.04.15.
 */
public class DestroyMethodPrototypeWarningBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        for (String beanName : factory.getBeanDefinitionNames()) {
            GenericBeanDefinition definition = (GenericBeanDefinition) factory.getBeanDefinition(beanName);
            if(definition.isPrototype() && definition.getDestroyMethodName() != null){
                System.out.println("WARNING: CANNOT DESTROY BEAN WITH PROTOTYPE SCOPE!");
            }
        }
    }
}
