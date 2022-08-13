import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.io.File;
import java.util.zip.ZipInputStream;

public class extract_file_from_arch {
    public static void main(String[] args) {
        try{
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("test.zip"));
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while(zipEntry != null) {
                String zipFileName = zipEntry.getName(); //getName() - возвращает имя вхождения
                System.out.println(zipFileName);

                //if (zipEntry.getName() == "test.txt") {
                {
                    File file = new File("out.xyz");
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    //byte[] buffer = new byte[1024];

                    String inputStroka = "some_blah_blah_thing";
                    byte[] buffer = inputStroka.getBytes("UTF-8");

                    int length = 0;

                    System.out.println("read buffer = " + zipInputStream.read(buffer));

                    while ((length = zipInputStream.read(buffer)) > 0) {
                        fileOutputStream.write(buffer, 0, length);
                        }
                        System.out.println("buffer = " + buffer);
                        fileOutputStream.close();
                }
                zipEntry = zipInputStream.getNextEntry();
            }
            zipInputStream.closeEntry();
            zipInputStream.close();
            //определить нужный файл, перевести его в распакованный вид и все позакрывать

        } catch (Exception ex) {

        }
    }
}
