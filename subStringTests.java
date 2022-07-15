import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Timeout;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.concurrent.TimeUnit;

class SubStrMethodTest {

    static String str1;
    static String str2;
    String longString;
    String subStr;
    String systemConf;

    @org.junit.jupiter.api.BeforeEach //конструктор - задаем начальные значения перед проведением тестов
    void setUp() throws IOException {
        str1 = StringGen.generator(1000);
        str2 = StringGen.generator(10);
        longString = StringGen.generator(10000000);
        subStr = StringGen.generator(5);
        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
        systemConf = "OS: " + System.getProperty("os.name")
                + "\nVersion: " + System.getProperty("os.version")
                + "\nArchitecture: " + System.getProperty("os.arch")
                + "\nAvailable processors (cores): " + Runtime.getRuntime().availableProcessors()
                + "\nSystem CPU load: " + operatingSystemMXBean.getSystemLoadAverage();
    }

    //regression test
    @org.junit.jupiter.api.Test
    @DisplayName(" - regression test - \uD83D\uDE3A")
    public void regressionTest() throws IOException {
        Assertions.assertEquals(true, SubStrMethod.searchMethod("avangardnaya", "vanga"), "substring - vanga is in string - avangardnaya");
    }

    //random values test
    @RepeatedTest(10000)
    @DisplayName(" - random values test - ╯°□°）╯")
    public void randomTest() throws Exception {
        String text = StringGen.generator((int) ((Math.random() * (50 - 10) + 1) + 10));
        String example = StringGen.generator((int) (Math.random() * 5));
        try {
            SubStrMethod.searchMethod(text, example);
        } catch (Exception ex) {
            Assertions.fail("Error of searchMethod!!!. Expect that main string " + text + " will have substring " + example + ", but failed");
        }
        Assertions.assertEquals(text.contains(example), SubStrMethod.searchMethod(text, example), "Expect that str1 = " + text + " contains str2 = " + example);
    }

    //long string test with jUnit timeout
    @org.junit.jupiter.api.Test
    @DisplayName(" - long string test with jUnit timeout - ( ಠ ʖ̯ ಠ )")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void longStringTestJunit() throws IOException {
        SubStrMethod.searchMethod(longString, subStr);
    }

    //long string test with system timeout
    @org.junit.jupiter.api.Test
    @DisplayName(" - long string test with system timeout [¬º-°]¬")
    public void longStringTestSystem() throws Exception{
        long currTime = java.lang.System.currentTimeMillis();
        SubStrMethod.searchMethod(longString, subStr);
        long currTime2 = java.lang.System.currentTimeMillis();

        Assertions.assertTrue(currTime2 - currTime < 50,
                "Method(testing long string with system time) is out of time! " +
                        "\nHere are the system configuration: \n" + systemConf);
    }

    //empty values test
    @org.junit.jupiter.api.Test
    @DisplayName(" - empty values test - ( ੭ ･ᴗ･ )੭")
    public void emptyTest() throws IOException {
        Assertions.assertEquals(SubStrMethod.searchMethod(str1, ""), str1.contains(""),
                "expecting that empty substring is in string");
        
        Assertions.assertEquals(SubStrMethod.searchMethod("", str2), "".contains(str2),
                "expecting that substring can't be inside empty string");

        Assertions.assertEquals(SubStrMethod.searchMethod("", ""), "".contains(""),
                "expecting that empty substring can be in empty string");
    }
}