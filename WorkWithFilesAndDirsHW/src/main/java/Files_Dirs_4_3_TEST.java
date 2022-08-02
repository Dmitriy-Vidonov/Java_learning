import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Files_Dirs_4_3_TEST {
    public static void main(String[] args) {
        String path = "./test_dir";
        File root = new File(path);
        boolean flag = true;

        //проверка на наличие подкаталога
        //System.out.println(Files_Dirs_4_2.filesNdirs(path, "*.*", false).get(1));
        if (Files_Dirs_4_2.filesNdirs(path, "*.*", false).get(1).toString() == "[]") {
            //System.err.println("Подкаталогов нет!");
            try {
                for (File filesDel : root.listFiles()) {
                    if (filesDel.exists())
                        filesDel.delete();
                }
            } catch (Exception ex) {
                System.err.println("Exception while trying to delete files - " + ex);
            }

            try {
                if (root.exists())
                    root.delete(); //удаление каталога
                System.out.println("Success!");
            } catch (Exception ex1) {
                System.err.println("Exception while trying to delete directory - " + ex1);
            }

        } else System.out.println("Fail!");

        /*проверка на наличие подкаталога
        try {
            for(File subDirsLoop : root.listFiles(File::isDirectory)) {
                if (Arrays.asList(subDirsLoop) != null) {
                    // System.out.println("есть подкаталог!");
                    flag = false;
                }
            }
        }
        catch (NullPointerException nullEx) {
            System.err.println("NullPointer exception while trying analyze content of directory - " + nullEx);
        }
        catch (Exception ex) {
            System.err.println("Exception while trying analyze content of directory - " + ex);
        } */

        /*
        try {
            //пробежаться по всем файлам и удалить их
            if (flag == true) { //если нет подкаталогов, удаляем файлы и каталог
                for (File filesDel : root.listFiles()) {
                    if (filesDel.exists())
                        filesDel.delete();
                }
                if (root.exists())
                    root.delete(); //удаление каталога
            }
        } catch (Exception ex) {
            System.err.println("Exception while trying to delete files and root dir itself - " + ex);
        }*/
    }
}
