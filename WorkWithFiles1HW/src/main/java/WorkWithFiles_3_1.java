import java.io.*;

public class WorkWithFiles_3_1 {
    public static void main(String[] args) {
        //генерация 10 файлов
        try {
            for (int i = 1; i <= 10; i++) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(i + ".txt"));
                //генерация по 3 числа с новой строки в каждом файле
                for (int j = 0; j < 3; j++) {
                    bw.write(String.valueOf((int)(10 + Math.random() * 90)));
                    bw.newLine();
                }
                bw.close();
            }
        } catch (Exception ex) {
            System.err.println("Error in files generating - " + ex);
        }

        /*Тестирование задания 3_2*/
       int a = (int)(1 + Math.random() * 4);
       int b = (int)(5 + Math.random() * 5);
       String filePath = "./././";

       try {
           System.out.println("Sum of 6 nums from " + a + " and " + b + " = " + WorkWithFiles_3_2.SumOf6(a, b, filePath));

           /*Тестирование задания 3_3*/
           WorkWithFiles_3_3.catReader();
       } catch (Exception ex1) {
           System.err.println("Exception while testing to print results of methods");
       }
    }
}