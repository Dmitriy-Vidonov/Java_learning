import filepathconst; //подключаем файл с контантой - путь до файлов
import java.io.File;
import Sum;
import java.nio.file.*;
import java.util.List;

public class MagicSum {
    public static void main(String[] args) {

        int arraySize = 2; //размер массива. От размера массива зависит - сколько файлов мы будем складывать и проверять
        int strCount = 3; //число строк в файле, которое будем проверять.

        int[] array = new int[arraySize]; //создаем массив рандомных чисел для дальнейшего использования. 
      
        for (int i = 0; i < array.length; i++){
            array[i] = (int)(1 + (Math.random() * 10));
        }

        int result = 0; //итоговый результат

        for (int k = 0; k < array.length; k++) {  //для каждого файла
            Path path = Paths.get(filepathconst.getPath() + "example" + array[k] + ".txt"); //получаем адрес файла
            
            File f = new File(filepathconst.getPath() + "example" + array[k] + ".txt"); //создаем переменную с файлом для проверки
        
            if (f.exists()) { //если запрашиваемый файл существует
                try {
                    //открываем файл
                    List<String> lines = Files.readAllLines(path);
                   
                    if (lines.size() == strCount) { //если число строк в файле равно проверяемому значению
                        for (int i = 0; i < strCount; i++) { //в цикле складываем числа из файла
                            int currNum = Integer.parseInt(lines.get(i));
                            result += currNum;
                        }
                    }
                    else {
                        System.out.println("Ошибка! В файле не 3 элемента! Или есть некорректные элементы/пустые строки!");
                        break;
                    }
                    System.out.println("Путь к файлу - " + path); //отображение имен файлов
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
        System.out.println("Сумма всех чисел = " + result);

        System.out.println(Sum.getSum(1, 4));
        
    }
}
