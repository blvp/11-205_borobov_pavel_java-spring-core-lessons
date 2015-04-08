package foo.bar.day01.lab05;

/**
 * Created by blvp on 06.04.15.
 */
class BenchmarkProxySubject implements Subject {
    private Subject subject;

    public BenchmarkProxySubject() {
        this.subject = new SubjectImpl();
    }

    @Override
    public String longMethod() throws InterruptedException {
        long startTime = System.nanoTime();
        String  result = subject.longMethod();
        System.out.println("Execution of long method take: " + (System.nanoTime() - startTime));
        return result;
    }
}
