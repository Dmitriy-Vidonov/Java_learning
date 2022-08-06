import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Testing_Site {
  public static void main(String[] args) throws IOException {
    String res = "";
    String dir = "./test_dir"; //задаем рабочую папку

    System.out.println("Список файлов - " + (Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(0)));
    System.out.println("Список поддиректорий - " + (Files_Dirs_4_2.filesNdirs(dir, "*.*", false)).get(1));

    //Здесь список списков приведен для наглядности работы этой концепции
    ArrayList<ArrayList<String>> doubleList = new ArrayList<ArrayList<String>>();
    ArrayList<String> arr1 = new ArrayList<>();
    ArrayList<String> arr2 = new ArrayList<>();
    arr1.add("a1");
    arr1.add("a2");
    arr1.add("a3");
    arr2.add("b1");
    arr2.add("b2");
    arr2.add("b3");

    doubleList.add(arr1); //добавляем в список списков первый подсписок
    doubleList.add(arr2); //добавляем в список списков второй подсписок

    System.out.println(doubleList); //выводим общий список списков

    //выводим в цикле элементы вложенного списка
    for (int i = 0; i < doubleList.get(0).size(); i++)
      System.out.println(doubleList.get(0).get(i));

    //вывод нулевого элемента подсписка. Есть список из списков, каждый из которых имеет элементы. Выводим им
    System.err.println(Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(0).get(0));

    //проверим существование файла, пути до файла и его родительскую папку - getParent()
    File testFile = new File(dir + "/" + Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(0).get(1));
    System.err.println("testFile exists - " + testFile.exists());
    System.err.println("absolute path = " + testFile.getAbsolutePath());
    System.err.println("canonical path = " + testFile.getCanonicalPath());
    System.err.println("getParent = " + testFile.getParent());

    /*ПРИМЕР УДАЛЕНИЯ ФАЙЛОВ ЧЕРЕЗ РЕЗУЛЬТАТ РАБОТЫ МЕТОДА. БЕЗ СОЗДАНИЯ ОТДЕЛЬНОЙ ПЕРЕМЕННОЙ ТИПА File*/
    //удаляем файл и выводим сообщение, если получилось удалить корректно
    //метод filesNdirs() возвращает список списков файлов. 2 списка файлов. через get() мы обращаемся к нужным элементам
    //чтобы не вводить новую переменную типа File, мы результат filesNdirs() помещаем в тип File и оперируем этой переменной
    //вместо того, чтобы писать File filname = new File(filesNdirs()) мы пишем просто new File(filesNdirs()) c нужным элементом
   /* if (new File(dir + "/" + Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(0).get(1)).delete()) {
      System.err.println("file " + testFile + " deleted successfully!");
    } else {
      System.err.println("file " + (Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(0).get(1)) + " isn't deleted");
    } */

    System.err.println("parent = " + new File(dir).exists());
    //проверяем длину списка, в котором хранятся имена подкаталогов. если размер списка = 0, значит он пуст и подпапок нет
    if (Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(1).size() == 0) {
      System.err.println("нет подпапки!");

      System.err.println("size of files list = " + Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(0).size());

      //нужен отдельный count, так как если метод поставить, то с каждым шагом размер списка уменьшается
      //и в итоге цикл закончиться раньше, чем нам надо
      int count = 0;
      count = (Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(0).size());

      for (int i = 0; i < count; i++) {

        //каждый раз берем нулевой элемент списка, так как после каждого удаления список меньше и меньше
        if (new File(dir + "/" + Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(0).get(0)).exists()) {
          new File(dir + "/" + Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(0).get(0)).delete();

        }
      }

      if (new File(dir).exists()) {
        new File(dir).delete();
      }

      res = "Success!";
    } else {
      System.err.println("есть подпапка!");
      res = "Fail!";
    }
System.err.println("res = " + res);

  }
}
