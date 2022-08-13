import java.io.*;
import java.util.zip.*;

public class archives_tests {
    public static void main(String[] args) throws IOException {
        /*ОТКРЫТИЕ АРХИВА И СЧИТЫВАНИЕ ЕГО СОДЕРЖИМОГО*/
        //ZipInputStream - тип, задающий поток данных архива. Точнее - поток объектов типа ZipEntry
        //объекты типа ZipEntry - это некая элементарная составляющая архива
        //по сути архив - это небольшая файловая система с файлами и каталогами

        //Открыли поток-архив, создаеая объект zipInputStream
        //далее - начинаем считывать из него по одному объекты ZipEntry через getNextEntry() - обход всех файлов архива
        //как поток будет закончен - эта команда вернет null
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("test.zip"));
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        //закрытие потока
        zipInputStream.closeEntry();
        zipInputStream.close();

        //метод getName() класса ZipEntry возвращает имя нужного файла или каталога
        //в заключении поток надо закрыть методами closeEntry() и close()

        /*ВЫВОД ЗАГОЛОВКОВ СОДЕРЖИМОГО АРХИВА*/
        ZipInputStream zipInputStream1 = new ZipInputStream(new FileInputStream("test.zip"));
        ZipEntry zipEntry1 = zipInputStream1.getNextEntry();
        while (zipEntry1 != null) { //null - вернет, когда весь архив будет перебран
            String zipFileName = zipEntry1.getName(); //в переменную zipFileName передаем имя очередного файла архива
            System.out.println(zipFileName); //выводим значение переменно zipFileName
            zipEntry1 = zipInputStream1.getNextEntry(); //передаем в zipEntry1 - следующий элемент
        }
        zipInputStream1.closeEntry();
        zipInputStream1.close();

        /*ИЗВЛЕЧЕНИЕ(СЧИТЫВАНИЕ) ФАЙЛА ИЗ АРХИВА*/
        //нужный файл считывается по кусочкам в буфер и пишется в итоговый файл
        //метод read() класса ZipInputStream считывает этот кусочек
        ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream("test.zip"));
        ZipEntry zipEntry2 = zipInputStream2.getNextEntry();

        assert zipEntry2 != null;
        if (zipEntry2.getName() == "pom2.xml") {
                File file = new File("out.xyz");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = zipInputStream2.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }
                fileOutputStream.close();
            }

        zipInputStream2.closeEntry();
        zipInputStream2.close();

        System.out.println("buffer = ");
    }
}
