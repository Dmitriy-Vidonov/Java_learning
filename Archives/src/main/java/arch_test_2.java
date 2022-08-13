import java.io.*;
import java.util.zip.*;

public class arch_test_2 {
    public static void main(String[] args) {
        try {
            //открыть архив и считать содержимое архива
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("test.zip"));
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while(zipEntry != null) {
                String strZipFileName = zipEntry.getName();
              //  System.out.println(strZipFileName);
                zipEntry = zipInputStream.getNextEntry();
            }
            zipInputStream.closeEntry();
            zipInputStream.close();

        } catch(Exception ex) {
            System.out.println("some exception - " + ex);
        }

        //Считывание файла из архива
        try {
            //Открываем поток данных ZipInputStream для работы с архивом, кормим потоку архив через FileInputStream
            //FileInputStream - это поток сырых данных из архива
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("test.zip"));
            //ZipEntry - это элемент архива
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while(zipEntry != null) { //null - вернет после прохода всех элементов архива
                if (zipEntry.getName().contains("pom2.xml")) { //ищем элемент архива с нужным именем

                    File file = new File("out.xyz"); //инициализируем путь до нового файла
                    FileOutputStream fileOutputStream = new FileOutputStream(file); //создаем поток для записи данных в файл

                    byte[] buffer = new byte[1024]; //создали буфер на 1кб
                    int length; //задали счетчик длины буфера

                    //zipInputStream.read(buffer) - из текущего zipEntry получает байты и пишет их в массив байтов buffer
                    //System.err.println("длина буфера для текущего zipEntry - " + zipInputStream.read(buffer));

                    while((length = zipInputStream.read(buffer)) > 0) { //while для обхода пустых файлов, где ничего нет
                        fileOutputStream.write(buffer, 0, length); //пишем length байтов в массив байтов buffer
                    }
                    fileOutputStream.close(); //закрываем поток для записи в файл
                }
                zipEntry = zipInputStream.getNextEntry(); //переход к след. элементу архива - нужен для обхода всех эл-тов
            }
            zipInputStream.closeEntry(); //закрываем текущий zipEntry
            zipInputStream.close(); //закрываем поток для работы с архивом

        } catch (Exception ex) {
            System.out.println("exception reading file from zip-archive - " + ex);
        }

        //Создание нового архива с файлом
        try {
            //test2.zip - несуществующий архив
            //существующий архив будет перезаписан!
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("test2.zip"));

            //файл для добавления в создаваемый архив
            String file = "test5.txt"; //имя файла, который будем добавлять в архив
            ZipEntry zipEntry = new ZipEntry(file); //создание нового zipEntry с именем file

            //добавляем новую сущность (заголовок) в архив
            zipOutputStream.putNextEntry(zipEntry);

            //копируем (записываем) исходный файл в архив
            FileInputStream fileInputStream = new FileInputStream(file); //чтение потока сырых данных из файла
            int length; //создаем счетчик
            byte[] buffer = new byte[1024]; //создаем массив на 1кб

            //в fileInputStream - у нас поток сырых данных. Через read() мы пишем его в buffer
            //и по сути length - содержит длину массива buffer
            while((length = fileInputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, length);
            }
            //закрываем файлы и потоки
            fileInputStream.close(); //закрытия потока данных из файла
            zipOutputStream.closeEntry(); //закрытие zipEntry
            zipOutputStream.close(); //закрытие потока записи файлов в архив

        } catch(Exception ex) {
            System.out.println("Exception during creating new archive with file - " + ex);
        }
    }
}
