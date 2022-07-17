import org.junit.jupiter.api.RepeatedTest;

class WorkWithFiles_3_2Test {

    int a, b;
    String filePath;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        a = (int)(1 + Math.random() * 4);
        b = (int)(5 + Math.random() * 5);
        filePath = "/home/dima/Рабочий стол/Java/1 - Шилдт/Github/idea_projects/WorkWithFiles1HW/";
    }

    @RepeatedTest(10000)
    public void multiTest() throws Exception {
        System.out.println(WorkWithFiles_3_2.SumOf6(a, b, filePath));
    }
}