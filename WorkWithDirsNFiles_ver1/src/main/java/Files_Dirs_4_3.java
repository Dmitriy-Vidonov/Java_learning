import java.io.File;
import java.util.ArrayList;

public class Files_Dirs_4_3 {
    public static String filesNDirsDel (String dir) {
        String res = "";
        try {
            ArrayList<ArrayList<String>> filesDirsList = new ArrayList<ArrayList<String>>();
            filesDirsList = Files_Dirs_4_2.filesNdirs(dir, "*.*", false);
            //проверяем длину списка, в котором хранятся имена подкаталогов. если = 0, значит он пуст и подпапок нет
            if (filesDirsList.get(1).size() == 0) {
                for (int i = 0; i < filesDirsList.get(0).size(); i++) {
                    //удаляем файлы через проход элементов списка
                    if (new File(dir + "/" + filesDirsList.get(0).get(i)).exists()) {
                        new File(dir + "/" + filesDirsList.get(0).get(i)).delete();
                    }
                }
                //удаляем основную директорию
                if (new File(dir).exists()) {
                    new File(dir).delete();
                }
                res = "Success!";
            } else {
                res = "Fail!";
            }
        } catch (Exception ex) {
            System.err.println("Exception while trying to delete files and main directory - " + ex);
        }
        return res;
    }
}
