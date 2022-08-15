import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class Arch_HW {

    // 4MB buffer
    //создается буфер на 4 мб
    private static final byte[] BUFFER = new byte[4096 * 1024];

    /**
     * copy input to output stream - available in several StreamUtils or Streams classes
     */
    //входной поток копируется в выходной поток. по сути это отдельный простой метод копирования
    public static void copy(InputStream input, OutputStream output) throws IOException {
        int bytesRead; //счетчик - сколько байтов считывать
        //input.read(buffer) - чтение байтов из входного потока и запись их в буфер
        while ((bytesRead = input.read(BUFFER))!= -1) { //-1 видимо возвращает по завершению чтения потока
            //output.write(buffer) - пишет bytesRead байтов из buffer в поток вывода
            output.write(BUFFER, 0, bytesRead);
        }
    }

    public static void main(String[] args) throws Exception {
        // read war.zip and write to append.zip
        //читаем архив test.zip и пишем его в архив test2.zip. Т.е. test.zip у нас изначально есть, а test2.zip создаем
        //класс ZipFile - служит для чтения zip-архива. в конце его надо закрыть
        ZipFile war = new ZipFile("test.zip"); //ex war.zip
        //ZipOutputStream - выходной поток для записи файлов в zip формат
        //FIleOutputStream - выходной поток для записи в файл
        //создается новый файловый поток, который кормим потоку для создания архива. в общем, создаем архив новый
        ZipOutputStream append = new ZipOutputStream(new FileOutputStream("test2.zip")); //ex append.zip / test2.zip

        // first, copy contents from existing war
        //сперва копируем данные из существующего архива test.zip
        //Enumeration - это интерфейс, в котором перебираются элементы из коллекции объектов, получая их по очереди
        //Enumeration в новых версиях заменен на Iterator. В новом коде его писать не рекомендуется
        //создается типа списка элементов с наследованием от ZipEntry, в который кладется список элементов
        //из test.zip (исходный массив). здесь это переменная war типа ZipFile
        Enumeration<? extends ZipEntry> entries = war.entries(); //то есть получаем список элементов архива test.zip
        //entries.hasMoreElements() - берет список entries и проверяет - есть ли там еще элементы
        //возвращает true до тех пор пока не останется хотя бы еще один элемент. т.е. чекаем наличие элементов в целом
        while (entries.hasMoreElements()) { //пока наш список не закончился
            //ZipEntry - это по сути составная часть архива. т.е. здесь мы создаем элементы архива
            //entries.nextElement() - возвращает следующий объект в перечислении из списка entries
            ZipEntry e = entries.nextElement(); //в очередной zipEntry пишем элемент из entries
            //e.getName() - это имя очередного zipEntry, т.е. элемента архива
            //этот вывод на экран ниже - чисто служебный
            System.out.println("copy: " + e.getName()); //просто пишем - copy: и что копируем
            //append - создаваемый архив. putNextEntry() - добавление новой сущности (заголовка) в архив
            //putNextEntry() - по сути создает новый файл в архиве, новый элемент архива
            // e - это zipEntry, куда и пишется файл. то есть добавляем файл в архив.
            append.putNextEntry(e);
            //если наш e (zipEntry) не является директорией, то есть если это обычный файл
            if (!e.isDirectory()) {
                //getInputStream(zipEntry) - возвращает входной поток для чтения содержимого zipEntry
                //war.getInputStream - из архива test.zip берем содержимое zipeEntry и получаем входной поток для чтения
                //полученный поток из zipEntry архива test.zip копируем в архив append (в примере это test2.zip
                //то есть по сути копируем содержимое файла из исходного массива в создаваемый
                //мы в самом начале как раз писали метод copy() - копируем входной поток в выходной
                copy(war.getInputStream(e), append);
            }
            append.closeEntry(); //закрываем zipEntry в создаваемом массиве append (у нас это test2.zip)
        }


        // now append some extra content
        //этот блок для добавления доп. контента в создаваемый массив. он в общем-то не обязателен, как я понимаю
        //создаем новый zipEntry. можно назвать так же, т.к. предыдущий уже закрыт
        //"out.xyz" - имя файла, который мы добавляем в архив
        ZipEntry e = new ZipEntry("addingFile.txt"); //ex answer.txt
        //так же чисто технический вывод. нужен для наглядности. пишем имя файла, которое добавляем в архив
        System.out.println("append: " + e.getName());
        //создаем новую сущность в создаваемом архиве в рамках созданного выше zipEntry
        append.putNextEntry(e);
        //записываем в текущий zipEntry нашего создаваемого архива append по байтам (метод getBytes) текст "42\n"
        //по сути это тоже уже не нужный нам кусок кода
        append.write("42\n".getBytes());
        //закрываем текущий zipEntry
        append.closeEntry();

        // close
        war.close(); //закрытие исходного массива (в примере это test.zip
        append.close(); //закрытие создаваемого массива (в примере это test2.zip)
    }
}