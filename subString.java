//SubStrMethod.java
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class SubStrMethod { //класс - поиск подстроки
    private static Logger logSubStrMethod = Logger.getLogger(SubStrMethod.class.getName()); //логгер для текущего класса
    public static Boolean searchMethod(String s1, String s2) throws IOException {  //метод поиска подстроки
        //подключение файла настроек логгера
        LogManager.getLogManager().readConfiguration(SubStrMethod.class.getResourceAsStream("logging.properties"));

        if (s1 == null || s2 == null) return false;

        char[] arrayS1 = s1.toCharArray(); //массив для исходной строки
        char[] arrayS2 = s2.toCharArray(); //массив для подстроки

        try { //попытка проверить длины массивов
            if (arrayS1.length != 0 && arrayS2.length == 0) {
                assert arrayS1.length > 0; //проверка что длина первого массива оказалась больше 0
                return true;
            }
            else if (arrayS1.length == 0 && arrayS2.length != 0) {
                assert arrayS2.length > 0; //проверка что длина второго массива оказалась больше 0
                return false;
            }
            else if (arrayS1.length == 0 && arrayS2.length == 0) { return true; }
            //throw new Exception("some exception from SubStrMethod");
        } catch (Exception ex) { //в случае исключение мы его логируем
            logSubStrMethod.logp(Level.SEVERE, "SubStrMethod", "Check arrays length",
                        "Exception - " + ex);
        }

        boolean equal = true;

        try { //попытка просчета цикла с вложенным циклом
            for(int i = 0; i < (s1.length() - s2.length()); i++) {
                equal = true;
                assert i < s1.length() - s2.length() && i >= 0; //проверка что i лежит в нужном диапазоне
                try { //попытка просчета вложенного цикла
                    for(int j = 0; j < s2.length(); j++) {
                        assert j < s2.length() && j >= 0; //проверка что j лежит в нужном диапазоне
                        if(arrayS2[j] != arrayS1[i + j]) {
                            equal = false;
                            break;
                        }
                    }
                } catch (Exception ex1) { //в случае исключения при работе вложенного цикла - ловим исключение в лог
                    logSubStrMethod.logp(Level.SEVERE, "SubStrMethod", "Checking inner loop if substring exist in main string",
                            "Exception - " + ex1);
                }

                try { //попытка определения состояния переменной equal
                    if(equal == true) {
                        assert equal = Boolean.parseBoolean("true"); //проверка является ли equal типом boolean
                        return equal;
                    }
                } catch (Exception ex2) { //в случае возникновения исключения при проверке equal - пишем это в лог
                    logSubStrMethod.logp(Level.SEVERE, "SubStrMethod", "Checking variable equal", "Exception - " + ex2);
                }
            }
        } catch (Exception exc) { //в случае исключения при работе основного цикла - ловим исключение в лог
            logSubStrMethod.logp(Level.SEVERE, "SubStrMethod", "Checking outer loop if substring exist in main string",
                    "Exception - " + exc);
        }

        assert equal = Boolean.parseBoolean("true"); //проверка является ли equal типом boolean
        return false;
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
            //throw new Exception("some exception from StringGen");
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
            //System.out.println(subSearch.searchMethod("", ""));
            System.out.println(subSearch.searchMethod(str1, null));
            //throw new Exception("some exception from main");
        } catch (Exception ex) {
            logMain.logp(Level.SEVERE, "Main", "trying to generate strings and get results",
                    "Exception - " + ex);
        }
    }
}