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

    //regression test
    @Test
    public void regressionTest() throws IOException {
        Assert.assertEquals("substring - vanga is in string - avangardnaya", true,
                SubStrMethod.searchMethod("avangardnaya", "vanga"));
    }

    //random values test
    @Test
    public void randomTest() throws IOException {
            for (int i = 0; i < 10000; i++) {
                String str1 = StringGen.generator((int)((Math.random() * (50 - 10) + 1) + 10));
                String str2 = StringGen.generator((int)(Math.random() * 5));
                Assert.assertEquals("Expect that str1 = " + str1 + " contains str2 = " + str2, str1.contains(str2), SubStrMethod.searchMethod(str1, str2));
            }
    }

    //test with null values
    @Test
    public void nullTest() throws IOException {
        Assert.assertFalse("expect that null has no substring", SubStrMethod.searchMethod(null, str2));
        Assert.assertFalse("expect that there is no null in string", SubStrMethod.searchMethod(str1, null));
        Assert.assertFalse("expect no matches with nulls", SubStrMethod.searchMethod(null, null));
    }

    //empty values test
    @Test
    public void emptyTest() throws IOException {
        Assert.assertEquals("expecting that empty substring is in string", SubStrMethod.searchMethod(str1, ""), true);
        Assert.assertEquals("expecting that substring can't be inside empty string", SubStrMethod.searchMethod("", str2), false);
        Assert.assertEquals("expecting that empty substring can be in empty string", SubStrMethod.searchMethod("", ""), true);
    }
}

/* Результаты тестов
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running SubStrMethodTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.166 sec

Results :

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  5.875 s
[INFO] Finished at: 2022-07-05T13:24:26+03:00
[INFO] ------------------------------------------------------------------------
 */