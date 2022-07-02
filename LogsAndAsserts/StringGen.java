import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class StringGen {
    private static Logger logStringGen = Logger.getLogger(StringGen.class.getName()); //логгер для текущего класса
    public static String generator(int len) throws IOException {
        //подключаем файл настроек к классу
        LogManager.getLogManager().readConfiguration(StringGen.class.getResourceAsStream("logging.properties"));

        //String pw = "";
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
            throw new Exception("some exception from StringGen");
        } catch (Exception ex) {
            logStringGen.logp(Level.SEVERE, "StringGen", "trying to generate strings", "exception - " + ex);
        }
        assert str.length() == len; //Проверка, что итоговая строка корректная по длине
        return str.toString();
    }
}
