import java.nio.file.*;
import java.util.List;
import filepathconstant;

public class files1randNums {
    
    public static void main(String[] args){

        for (int i = 1; i <= 10; i++) { //в цикле от 1 до 10
            Path path = Paths.get(filepathconstant.getPath() + "example" + i + ".txt"); //получаем путь для текущего файла

            try {
                String str = Integer.toString((int)(10 + Math.random() * 50)); //создаем число для первой строки
			    byte[] bs = str.getBytes(); //получаем массив байтов из строки
                Files.write(path, bs); //пишем в файл данные

                for (int j = 1; j < 3; j++) { //для каждого созданного ранее файла в цикле дважды добавляем по новой строке
                    try {
                        List<String> lines = Files.readAllLines(path); //создание списка из строк в ранее заготовленном файле
            
                        int position = lines.size(); //расчет позиции добавления новой строки
                        String extraNum = Integer.toString((int)(10 + Math.random() * 50)); //генерируем число для новой строки
            
                        lines.add(position, extraNum); //добавление новой строки
                        Files.write(path, lines); //запись в файл
                    }
                   catch (Exception e) {
                    e.printStackTrace();
                   }
                }
            }
            catch (Exception e1) {
                e1.printStackTrace();
            }  
        }
    }
}
