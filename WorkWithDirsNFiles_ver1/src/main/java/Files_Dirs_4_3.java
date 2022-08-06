import java.io.File;

public class Files_Dirs_4_3 {
    public static String filesNDirsDel (String dir) {
        String res = "";

        try {
            //проверка наличия субдиректории по размеру списка, в котором хранятся имена субдиректорий
            if (Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(1).size() == 0) {
                int count = 0; //переменная для инициализации цикла прохода по всем элементам списка файлов
                count = (Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(0).size());

                for (int i = 0; i < count; i++) {
                    //проверка и удаление очередного элемента в списке файлов на удаление
                    if (new File(dir + "/" + Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(0).get(0)).exists()) {
                        new File(dir + "/" + Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(0).get(0)).delete();
                    }
                }
                //проверка существования директории после удаления файлов и ее удаление
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
