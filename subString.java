//файл main/java/SubStrMethod.java
public class SubStrMethod {
    public static Boolean searchMethod(String s1, String s2){
        char[] arrayS1 = s1.toCharArray(); //массив для исходной строки
        char[] arrayS2 = s2.toCharArray(); //массив для подстроки

        if (arrayS1.length != 0 && arrayS2.length == 0) { return true; }
        else if (arrayS1.length == 0 && arrayS2.length != 0) { return false; }
        else if (arrayS1.length == 0 && arrayS2.length == 0) { return true; }

        boolean equal = true;

        for(int i = 0; i < (s1.length() - s2.length()); i++) {
            equal = true;
            for(int j = 0; j < s2.length(); j++) {
                if(arrayS2[j] != arrayS1[i + j]) {
                    equal = false;
                    break;
                }
            }
            if(equal == true) {
                return equal;
            }
        }
        return false;
        }
    }

//файл main/java/StringGen.java
public class StringGen {

    public static String generator(int len) {

        String pw = "";
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < len; i++)
        {
            if (i % 3 == 0) { //генерация чисел от 0 до 9
                char c=Character.forDigit((int) (Math.random() * 10),10);
                str.append(c);
            }
            else { //генерация ASCII символов - англоязычные буквы
                char c = (char) (int) (Math.random() * 26 + 97);
                str.append(c);
            }
        }
    return str.toString();
    }
}

//файл test/java/SubStrSearchTestCase
import org.junit.Assert;
import org.junit.Test;

public class SubStrSearchTestCase {

    String str1 = "";
    String str2 = "";

    @Test //регресионный тест - сверяем работу метода с заранее известными значениями
    public void regressionTest() {

        Assert.assertEquals("подстрока - ванга содержится в строке - авангардная", true,
                SubStrMethod.searchMethod("авангардная", "ванга"));
    }

    @Test //тест с использованием рандомных значений - сравнить работу нашей функции и системной
    public void randTest() {
            for(int i = 0; i < 100; i++){
                str1 = StringGen.generator(1000); //генерация строки str1
                str2 = StringGen.generator(10); //генерация строки str2
                boolean res = SubStrMethod.searchMethod(str1, str2); //проверка вхождения str2 в str1
                Assert.assertEquals(str1.contains(str2), res); //сравниваем работу нашей фунции и системной
            }
    }

    @Test //тест с ипользованием максимальных значений - ожидаем false, так как не может быть такого совпадения
    public void maxText() {
        str1 = StringGen.generator(1000000);
        str2 = StringGen.generator(1000);
        Assert.assertFalse(SubStrMethod.searchMethod(str1, str2));
    }

    @Test //тест с использованием пустых значений
    public void emptyTest() {
        //пустая подстрока состоит в рандомно созданной строке из 10 символов
        Assert.assertEquals(SubStrMethod.searchMethod(StringGen.generator(10), ""), true);
        //непустая подстрока не состояит в пустой строке
        Assert.assertEquals(SubStrMethod.searchMethod("", StringGen.generator(10)), false);
        //пустая подстрока состоит в пустой строке
        Assert.assertEquals(SubStrMethod.searchMethod("", ""), true);
    }
}


/* Результаты тестов
 -------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running SubStrSearchTestCase
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.16 sec

Results :

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.737 s
[INFO] Finished at: 2022-06-25T14:39:04+03:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
 */