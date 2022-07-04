import org.junit.*;
import java.io.IOException;

public class SubStrMethodTest {

    static String str1;
    static String str2;

    @Before
    public void setUp() throws IOException {
        str1 = StringGen.generator(1000);
        str2 = StringGen.generator(10);
    }

    //регрессионный тест - сравниваем заранее известное значение с работой метода
    @Test
    public void regressionTest() throws IOException {
        Assert.assertEquals("подстрока - ванга содержится в строке - авангардная", true,
                SubStrMethod.searchMethod("авангардная", "ванга"));
    }

    //сгенерим рандомные значения и сравним работу нашей функции и системной
    @Test
    public void randomTest() throws IOException {
        for (int i = 0; i < 10000; i++) {
            String str1 = StringGen.generator((int)((Math.random() * (50 - 10) + 1) + 10));
            String str2 = StringGen.generator((int)(Math.random() * 5));
            Assert.assertEquals(str1.contains(str2), SubStrMethod.searchMethod(str1, str2));
        }
    }

    //тест с использованием null
    @Test
    public void nullTest() throws IOException {
        Assert.assertFalse(SubStrMethod.searchMethod(null, str2));
        Assert.assertFalse(SubStrMethod.searchMethod(str1, null));
        Assert.assertFalse(SubStrMethod.searchMethod(null, null));
    }

    //тест с ипользованием пустых значений
    @Test
    public void emptyTest() throws IOException {
        //пустая подстрока состоит в рандомно созданной строке
        Assert.assertEquals(SubStrMethod.searchMethod(str1, ""), true);
        //непустая подстрока не состояит в пустой строке
        Assert.assertEquals(SubStrMethod.searchMethod("", str2), false);
        //пустая подстрока состоит в пустой строке
        Assert.assertEquals(SubStrMethod.searchMethod("", ""), true);
    }
}

/* Результаты тестов
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running SubStrMethodTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.393 sec

Results :

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.604 s
[INFO] Finished at: 2022-07-04T23:53:02+03:00
[INFO] ------------------------------------------------------------------------
 */