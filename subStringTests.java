import org.junit.Assert;
import org.junit.jupiter.api.RepeatedTest;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

class SubStrMethodTest {

    static String str1;
    static String str2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException {
        str1 = StringGen.generator(1000);
        str2 = StringGen.generator(10);
    }

    //regression test
    @org.junit.jupiter.api.Test
    public void regressionTest() throws IOException {
        assertEquals("substring - vanga is in string - avangardnaya", true,
                SubStrMethod.searchMethod("avangardnaya", "vanga"));
    }

    //random values test
    @RepeatedTest(10000)
    public void randomTest() throws Exception {
        String text = StringGen.generator((int) ((Math.random() * (50 - 10) + 1) + 10));
        String example = StringGen.generator((int) (Math.random() * 5));
        try {
            SubStrMethod.searchMethod(text, example);
        } catch (Exception ex) {
            Assert.fail("Error of searchMethod!!!. Expect that main string " + text + " will have substring " + example + ", but failed");
        }
        Assert.assertEquals("Expect that str1 = " + text + " contains str2 = " + example,
                text.contains(example), SubStrMethod.searchMethod(text, example));
    }

    //test with null values
    @org.junit.jupiter.api.Test
    public void nullTest() throws IOException {
        Assert.assertFalse("expect that null has no substring", SubStrMethod.searchMethod(null, str2));
        Assert.assertFalse("expect that there is no null in string", SubStrMethod.searchMethod(str1, null));
        Assert.assertFalse("expect no matches with nulls", SubStrMethod.searchMethod(null, null));
    }

    //empty values test
    @org.junit.jupiter.api.Test
    public void emptyTest() throws IOException {
        assertEquals("expecting that empty substring is in string", SubStrMethod.searchMethod(str1, ""), true);
        assertEquals("expecting that substring can't be inside empty string", SubStrMethod.searchMethod("", str2), false);
        assertEquals("expecting that empty substring can be in empty string", SubStrMethod.searchMethod("", ""), true);
    }
}