//SubStrMethod.java
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class SubStrMethod { //класс - поиск подстроки

    private static Logger logSubStrMethod = Logger.getLogger(SubStrMethod.class.getName()); //логгер для текущего класса

    static Boolean searchMethod (String str1, String str2) throws IOException {

        //подключение файла настроек логгера
        LogManager.getLogManager().readConfiguration(SubStrMethod.class.getResourceAsStream("logging.properties"));

        boolean res = false;

        if (str1 == null || str2 == null) return false;

        try { //попытка проверить длины массивов
            if (str1.length() != 0 && str2.length() == 0) {
                assert str1.length() > 0; //проверка что длина первого массива оказалась больше 0
                return true;
            } else if (str1.length() == 0 && str2.length() != 0) {
                assert str2.length() > 0; //проверка что длина второго массива оказалась больше 0
                return false;
            } else if (str1.length() == 0 && str2.length() == 0) {
                return true;
            }

        } catch (Exception ex) { //в случае исключение мы его логируем
            logSubStrMethod.logp(Level.SEVERE, "SubStrMethod", "Check arrays length",
                    "Exception - " + ex);
        }

            for (int i = 0; i < str1.length(); i++) { //цикл по всему базовому тексту
                int j = 0; //переменная j указывает текущую позицию внутри образца
                    while (j < str2.length() && i + j < str1.length() && str2.charAt(j) == str1.charAt(i + j)) { //до тех пор, пока мы не вышли за границы подстроки - sample
                        j++;                                                      //а также если мы не вышли за границы текста
                        //и если текущие символы в образце и тексте равны
                    }
                if (j == str2.length()) {
                    res = true;
                }
            }

        return res;
    }
}


//StringGen.java
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class StringGen {
    private static Logger logStringGen = Logger.getLogger(StringGen.class.getName()); //логгер для текущего класса
    public static String generator(int len) throws IOException {
        //подключаем файл настроек к классу
        LogManager.getLogManager().readConfiguration(StringGen.class.getResourceAsStream("logging.properties"));

        StringBuilder str = new StringBuilder(); //используем StringBuilder для построения строки
        try {
            for (int i = 0; i < len; i++)
            {
                if (i % 3 == 0) { //если остаток от деления i на 3 равен 0, то генерим число, иначе - букву
                    int digit = (int)(Math.random() * 10); //генерация случайного число от 0 до 9
                    assert digit >= 0 && digit <= 9; //Проверка сгенерированного значения в диапазоне от 0 до 9
                    char c = Character.forDigit(digit,10); //перевод числа в символ
                    str.append(c);
                }
                else { //генерация ASCII символов - англоязычные буквы
                    char c = (char) (int) (Math.random() * 26 + 97);
                    assert Character.isLetter(c); //Проверка - является ли символ 'c' - буквой
                    str.append(c);
                }
            }
        } catch (Exception ex) {
            logStringGen.logp(Level.SEVERE, "StringGen", "trying to generate strings", "exception - " + ex);
        }
        assert str.length() == len; //Проверка, что итоговая строка корректная по длине
        return str.toString();
    }
}


//Main.java
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static Logger logMain = Logger.getLogger(Main.class.getName()); //логгер для текущего класса

    public static void main(String[] args) throws IOException {

        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("logging.properties"));

        try {
            StringGen gen = new StringGen();
            String str1 = gen.generator(30);
            String str2 = gen.generator(5);

            SubStrMethod subSearch = new SubStrMethod();
            System.out.println(subSearch.searchMethod(str1, str2));
            System.out.println(subSearch.searchMethod("", ""));
            System.out.println(subSearch.searchMethod(str1, null));
        } catch (Exception ex) {
            logMain.logp(Level.SEVERE, "Main", "trying to generate strings and get results",
                    "Exception - " + ex);
        }
    }
}

