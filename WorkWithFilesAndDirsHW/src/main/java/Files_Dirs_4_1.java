import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Files_Dirs_4_1 {
    public static void main(String[] args) {
        //Печать всех подкаталогов текущего каталога до глубины вложенности 10
        File root = new File("."); //задаем "отправную точку" в пути до папок - текущую директорию
        ArrayList<File> expand = new ArrayList<>(); //expand - динамический массив с "путями" до каталогов
        expand.add(root); //в "список путей" до каталогов добавили "." - текущую директорию

        for (int depth = 0; depth < 10; depth++) { //повторяем проходку "вглубь" вплоть до вложенности 10
            File[] expandCopy = expand.toArray(new File[expand.size()]); //в массив expandCopy помещаем содержимое списка expand
            expand.clear(); //чистим список expand
            for (File file : expandCopy) { //для каждого элемента массива expandCopy типа file
                System.out.println(depth + " " + file); //печатаем текущий уровень глубины + содержимое элемента expandCopy

                if (file.isDirectory()) {   //проверяем, имеется ли директория по адресу из file
                    expand.addAll(Arrays.asList(file.listFiles())); //кладем в expand все, что находилось в file, т.е. список путей
                }
            }
        }
    }
}