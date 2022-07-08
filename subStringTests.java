import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

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
        Assertions.assertEquals(true, SubStrMethod.searchMethod("avangardnaya", "vanga"), "substring - vanga is in string - avangardnaya");
    }

    //random values test
    @RepeatedTest(1000)
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

    //test with null values
    @org.junit.jupiter.api.Test
    public void nullTest() throws IOException {
        Assertions.assertFalse(SubStrMethod.searchMethod(null, str2), "expect that null has no substring");
        Assertions.assertFalse(SubStrMethod.searchMethod(str1, null), "expect that there is no null in string");
        Assertions.assertFalse(SubStrMethod.searchMethod(null, null), "expect no matches with nulls");
    }

    //empty values test
    @org.junit.jupiter.api.Test
    public void emptyTest() throws IOException {
        Assertions.assertEquals(SubStrMethod.searchMethod(str1, ""), true, "expecting that empty substring is in string");
        Assertions.assertEquals(SubStrMethod.searchMethod("", str2), false, "expecting that substring can't be inside empty string");
        Assertions.assertEquals(SubStrMethod.searchMethod("", ""), true, "expecting that empty substring can be in empty string");
    }
}