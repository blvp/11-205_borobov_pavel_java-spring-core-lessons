package foo.bar.day01.lab10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by blvp on 06.04.15.
 */
public class InjectRandomIntBeanPostProccessor implements BeanPostProcessor {

    public static final Random RANDOM_GENERATOR = new Random();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (Field field : bean.getClass().getDeclaredFields()) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if(annotation != null){
                field.setAccessible(true);
                try {
                    int random = randInt(annotation.min(), annotation.max());
                    field.set(bean, random);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }


    public static int randInt(int min, int max) {
        int diff = max - min;
        return RANDOM_GENERATOR.nextInt(diff + (diff != Integer.MAX_VALUE?1:0)) + min;
    }
}
