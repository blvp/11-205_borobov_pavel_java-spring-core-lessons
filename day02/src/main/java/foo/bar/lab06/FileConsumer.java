package foo.bar.lab06;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * Created by blvp on 07.04.15.
 */
public class FileConsumer {

    private String filename;

    public FileConsumer(String filename) {
        this.filename = filename;
    }

    @PostConstruct
    private void consumeFile(){
        System.out.println(new File(filename).length());
    }
}
