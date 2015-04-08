package foo.bar.lab06;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by blvp on 07.04.15.
 */
public class FileCreator {

    private String fileName;

    public FileCreator(String fileName) {
        this.fileName = fileName;
    }

    @PostConstruct
    public void writeFile() throws IOException {
        try(FileWriter fw = new FileWriter(fileName)){
            fw.write("bla-bla-bla!");
        }
    }
}
