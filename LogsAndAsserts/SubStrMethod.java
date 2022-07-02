import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class SubStrMethod { //класс - поиск подстроки
    private static Logger logSubStrMethod = Logger.getLogger(SubStrMethod.class.getName()); //логгер для текущего класса
    public static Boolean searchMethod(String s1, String s2) throws IOException {  //метод поиска подстроки
        //подключение файла настроек логгера
        LogManager.getLogManager().readConfiguration(SubStrMethod.class.getResourceAsStream("logging.properties"));

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
            throw new Exception("some exception from SubStrMethod");
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