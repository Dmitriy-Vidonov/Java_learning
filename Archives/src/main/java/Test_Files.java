import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Test_Files {
    public static void main(String[] args) throws Exception {
        ZipFile archTestzip = new ZipFile("test.zip");  //создали переменную ZipFile для чтения архива test.zip
        Enumeration<? extends ZipEntry> entries = archTestzip.entries();  //создали список из элементов ZipEntry по сути
        while(entries.hasMoreElements()) { //перебираем все элементы списка
            ZipEntry zipEntry = entries.nextElement(); //создаем zipEntry с очередным элементом списка
            System.out.println(zipEntry.getName()); //вывод имени текущего zipEntry, по сути имени файла в архиве
        }

    }
}
