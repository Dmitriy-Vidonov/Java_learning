import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class Try_HW_ver1_1 {

    private static final byte[] buffer = new byte[4096 * 1024]; //буфер на 4 мб
    public static void copy(InputStream input, OutputStream output) throws Exception {
        int length;
        while((length = input.read(buffer)) != -1) {
            output.write(buffer, 0, length);
        }
    }

    public static void archivator(String archName, String[] filesList) {
         try{


             ZipFile primaryArchive = new ZipFile(archName); //переменная ZipFile для чтения исходного архива
             ZipOutputStream temporaryArchive = new ZipOutputStream(new FileOutputStream("temp.zip"));

             Enumeration<? extends ZipEntry> primaryArchiveEntries = primaryArchive.entries();
             while(primaryArchiveEntries.hasMoreElements()) {
                 ZipEntry zipEntry = primaryArchiveEntries.nextElement();
                 temporaryArchive.putNextEntry(zipEntry);

                 if(!zipEntry.isDirectory()) {
                     copy(primaryArchive.getInputStream(zipEntry), temporaryArchive);
                 }
                 temporaryArchive.closeEntry();
             }

             /*Добавляем дополнительные файлы в temporaryArchive*/
             String[] filesList = {"TEST1.txt", "TEST2.txt", "TEST3.txt"}; //список с файлами на добавление
             for(int loopCounter = 0; loopCounter < filesList.length; loopCounter++) {
                 ZipEntry e = new ZipEntry(filesList[loopCounter]);
                 temporaryArchive.putNextEntry(e);

                 FileInputStream fileInputStream = new FileInputStream(filesList[loopCounter]); //чтение потока сырых данных из файла
                 int length; //создаем счетчик
                 byte[] buffer = new byte[1024]; //создаем массив на 1кб

                 //в fileInputStream - у нас поток сырых данных. Через read() мы пишем его в buffer
                 //и по сути length - содержит длину массива buffer
                 while((length = fileInputStream.read(buffer)) > 0) {
                     temporaryArchive.write(buffer, 0, length);
                 }
                 //закрываем файлы и потоки
                 fileInputStream.close(); //закрытия потока данных из файла
                 temporaryArchive.closeEntry(); //закрытие zipEntry
             }

             primaryArchive.close();
             temporaryArchive.close();

             //удалить первичный архив и темп переименовать
             File archForDel = new File("test.zip");
             if(archForDel.exists()) archForDel.delete();

             //File finalArchName = new File("test.zip");
             File archForRename = new File("temp.zip");
             if(archForRename.exists()) {
                 archForRename.renameTo(archForDel);
             }

         } catch (Exception ex) {
             System.out.println("Exception while working with archives - " + ex);
         }
    }

    public static void main(String[] args) {
        String[] fileList1 = {"FILE1.txt", "FILE2.txt", "FILE3.txt"};
        archivator("test.zip", fileList1);
    }

}
