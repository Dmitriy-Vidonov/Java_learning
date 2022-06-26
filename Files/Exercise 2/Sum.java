import filepathconst; //подключаем файл с конcтантой - путь до файлов
import java.io.File;
import java.nio.file.*;
import java.util.List;

public class Sum {
    public static int getSum(int a, int b) {
      
        int[] array = new int[2];
        array[0] = a;
        array[1] = b;

        int result = 0; //итоговый результат

        for (int k = 0; k < 2; k++) {  //для каждого файла
            Path path = Paths.get(filepathconst.getPath() + "example" + array[k] + ".txt"); //получаем адрес файла
            
            File f = new File(filepathconst.getPath() + "example" + array[k] + ".txt"); //создаем переменную с файлом для проверки
        
            if (f.exists()) { //если запрашиваемый файл существует
                try {
                    //открываем файл
                    List<String> lines = Files.readAllLines(path);
                   
                    if (lines.size() == 3) { //если число строк в файле равно проверяемому значению
                        for (int i = 0; i < 3; i++) { //в цикле складываем числа из файла
                            int currNum = Integer.parseInt(lines.get(i));
                            result += currNum;
                        }
                    }
                    else {
                        System.out.println("Ошибка! В файле не 3 элемента! Или есть некорректные элементы/пустые строки!");
                        break;
                    }
                }
                catch (Exception e) {
                    System.out.println("Ошибка - " + e);
                    break;
                }
            }
            else {
                System.out.println("Файл не найден!");
                break;
            }
        }
        return result;
    }
}
