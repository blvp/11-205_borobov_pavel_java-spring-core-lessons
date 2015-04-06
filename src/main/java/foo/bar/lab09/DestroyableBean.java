package foo.bar.lab09;

import org.springframework.beans.factory.DisposableBean;

/**
 * Created by blvp on 06.04.15.
 */
public class DestroyableBean {
    public void destroy() throws Exception {
        System.out.println("destroying!");
    }
}
