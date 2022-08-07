import java.io.File;
import java.util.ArrayList;

public class Files_Dirs_4_3 {
    public static boolean filesNDirsDel (String dir) {
        try {
        //если главная папка не суещствует - завершаем работу метода
        if (!(new File(dir).exists()))
            return false;

        //создаем список списков для хранения результата метода filesNdirs()
        ArrayList<ArrayList<String>> filesDirsList = new ArrayList<ArrayList<String>>();
        filesDirsList = Files_Dirs_4_2.filesNdirs(dir, "*.*", false);

        //создаем список для хранения имен файлов из первичного двойного списка
        ArrayList<String> get0_List = new ArrayList<>();
        get0_List.addAll(filesDirsList.get(0));

        //проверяем длину списка, в котором хранятся имена подкаталогов. если = 0, значит он пуст и подпапок нет
            if (filesDirsList.get(1).size() == 0) {
                for (int i = 0; i < get0_List.size(); i++) {
                    //удаляем файлы через проход элементов списка
                    if (new File(dir + "/" + get0_List.get(i)).exists()) {
                        new File(dir + "/" + get0_List.get(i)).delete();
                        }
                    }
                    //удаляем основную директорию
                    new File(dir).delete();
                //true - если все файлы и основная директория успешно удалены
                return true;
               }
        } catch (Exception ex) {
            System.err.println("Exception while trying to delete files and main directory - " + ex);
        }
       //false - если не удалось удалить файлы
       return false;
    }
}
