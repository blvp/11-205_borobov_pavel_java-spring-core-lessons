package foo.bar.lab02;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by blvp on 07.04.15.
 */
public class StringBuilderFactoryBean implements FactoryBean<StringBuilder> {

    private String start;
    private String middle;
    private String end;

    @Override
    public StringBuilder getObject() throws Exception {
        return new StringBuilder(start).append(middle).append(end);
    }

    @Override
    public Class<?> getObjectType() {
        return StringBuilder.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
