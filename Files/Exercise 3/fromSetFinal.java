import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//Создаем класс Кот
class Cat{
    private String name;
    private double weight;
    private int fq;

    //Описываем параметризированный конструктор класса
    Cat(String name, double weight, int fq) {
        this.name = name;
        this.weight = weight;
        this.fq = fq;
    }

    //Задаем геттеры
    public String getName() { return name; }
    public double getWeight() { return weight; }
    public int getFq() { return fq; }

    //Задаем сеттеры
    public void setName(String name) { this.name = name; }
    public void setWeight(double weight) { if(weight > 0 && weight < 100) { this.weight = weight; } }
    public void setFq(int fq) { if(fq > 0 && fq < 1000) { this.fq = fq; } }
}

public class fromSetFinal {
    public static void main(String[] args) {

        //получаем адрес файла
        Path path = Paths.get("/media/dima/F462A22262A1E996/Personal/Coding/Java/1 - Шилдт/Github/java_codes/files/Ex 3/" + "settings.txt"); //получаем адрес файла

        File f = new File("/media/dima/F462A22262A1E996/Personal/Coding/Java/1 - Шилдт/Github/java_codes/files/Ex 3/" + "settings.txt"); //создаем переменную с файлом для проверки

        if (f.exists() && f.length() != 0) {
            try{
                List<String> lines = Files.readAllLines(path); //прочитали содержимое файла

                //задаем массив объектов, где в каждой ячейке будет хранится новая линия
                Object[] array = lines.toArray();

                //массив с котами
                Cat[] catArray = new Cat[lines.size()]; //создаем массив с котами, равный по размеру число строк в файле

                for (int i = 0; i < lines.size(); i++) { //читаем строчки а цикле до тех пор, пока они не закончатся
                    
                    String str = array[i].toString(); //берем элемент массива в lines - и переводим его в строку
                    String[] settingsArray = str.split(" "); //создаем массив настроек, из строки нарезаем параметры через split()
                    
                    //сотворяем нового кота
                    Cat catto = new Cat(settingsArray[0],  Double.parseDouble(settingsArray[1]), Integer.parseInt(settingsArray[2]));

                    //Помещаем нового котика в массив котов
                    catArray[i] = catto;
            }
            for (int i = 0; i < catArray.length; i++) {
                System.out.println("Кот номер " + (i + 1) + " по имени - " + catArray[i].getName());
            }
        }
            catch (NumberFormatException excNum){
                System.out.println("Ошибка - вы вбили неверные данные");
            }
            catch (ArrayIndexOutOfBoundsException empty) {
                System.out.println("Ошибка - некорректная строка" + empty);
            }
            catch (Exception exc1) {
                System.out.println("Возникла ошибка - " + exc1);
            }
        }
        else {
            System.out.println("Файла нет или он пуст!");
        }
    }
}