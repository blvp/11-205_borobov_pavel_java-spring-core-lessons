package foo.bar.lab07;

import foo.bar.lab08.Transactional;

/**
 * Created by blvp on 06.04.15.
 */

@Transactional
public class SomeCoolClassImpl implements SomeCoolClass {
    @Override
    @Benchmark
    public long myMethod() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000L);
        }
        return 0;
    }
}
