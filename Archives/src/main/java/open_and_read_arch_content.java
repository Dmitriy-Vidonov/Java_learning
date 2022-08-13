import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class open_and_read_arch_content {
    public static void main(String[] args) {
        try {
            /*ОТКРЫТИЕ АРХИВА И СЧИТЫВАНИЕ ЕГО СОДЕРЖИМОГО*/
            ZipInputStream myZipInputStream = new ZipInputStream(new FileInputStream("test.zip"));
            ZipEntry myZipEntry = myZipInputStream.getNextEntry();

            while(myZipEntry != null) {
                String zipFileName = myZipEntry.getName(); //getName() - возвращает имя вхождения
                System.out.println(zipFileName);
                myZipEntry = myZipInputStream.getNextEntry();
            }
            myZipInputStream.closeEntry();
            myZipInputStream.close();

        } catch (Exception ex) {
            System.out.println("some archive content reading exception - " + ex);
        }
    }
}
