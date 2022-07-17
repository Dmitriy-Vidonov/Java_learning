import java.io.*;
import java.util.ArrayList;

class Cat{ //прописали класс Cat
    private String name;
    private float weight;
    private int fq;

    Cat(String name, float weight, int fq){
        this.name = name;
        this.weight = weight;
        this.fq = fq;
    }

    public String getName() { return name; }
    public float getWeight() { return weight; }
    public int getFq() { return fq; }

    public void setName(String name) { this.name = name; }
    public void setWeight(float weight) { if(weight > 0 && weight < 35) {this.weight = weight;} }
    public void setFq(int fq) { if(fq > 0 && fq < 300) {this.fq = fq;} }
}
public class WorkWithFiles_3_3 {
    public static void catReader() throws IOException {
        File myCatsFile = new File("/home/dima/Рабочий стол/Java/1 - Шилдт/Github/idea_projects/WorkWithFiles1HW/"
                + "cats.txt");
            BufferedReader buffReader = new BufferedReader(new FileReader(myCatsFile));
            try {
                String str = buffReader.readLine();
                //Создали ArrayList с объектами класса Cat
                ArrayList<Cat> cats = new ArrayList<Cat>();
                assert str != null : "the file is empty!";
                while (str != null) {
                    System.out.println(str);

                    //создаем массив catsData с данными для объекта класса, через split() нарезаем строку на ячейки
                    String[] catsData = str.split(" ");
                    assert catsData.length == 3 : "the amount of data in string != 3" + " (=" + catsData.length + ")";
                    //создали объект класса Cat на основе данных массива catsData с нужной конвертацией данных
                    Cat cat = new Cat(catsData[0], Float.valueOf(catsData[1]), Integer.valueOf(catsData[2]));
                    //поместили объект класса Cat в ArrayList
                    cats.add(cat);

                    str = buffReader.readLine();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                buffReader.close();
            }
        }
    }
