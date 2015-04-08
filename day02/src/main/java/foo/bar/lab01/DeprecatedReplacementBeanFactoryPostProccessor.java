package foo.bar.lab01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * Created by blvp on 07.04.15.
 */
public class DeprecatedReplacementBeanFactoryPostProccessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            for (String beanName : beanFactory.getBeanDefinitionNames()) {
                GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition(beanName);
                DeprecatedOnSteroids annotation = null;

                annotation = Class.forName(beanDefinition.getBeanClassName()).getAnnotation(DeprecatedOnSteroids.class);

                if (annotation != null) {
                    Class<?> replaceClass = annotation.replaceWith();
                    beanDefinition.setBeanClass(replaceClass);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
