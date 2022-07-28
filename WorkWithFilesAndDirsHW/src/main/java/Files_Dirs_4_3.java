import java.io.File;
import java.util.Arrays;

public class Files_Dirs_4_3 {

    public static String smartDel(String dir) {
        File root = new File(dir);
        boolean flag = true;

        try {
            for (File subDirsLoop : root.listFiles(File::isDirectory)) {
                if (Arrays.asList(subDirsLoop) != null)
                    flag = false;
            }
        } catch (NullPointerException nullEx) {
            System.err.println("NullPointer exception while trying analyze content of directory - " + nullEx);
        } catch (Exception ex) {
            System.err.println("Exception while trying analyze content of directory - " + ex);
        }

        try {
            //пробежаться по всем файлам и удалить их
            if (flag == true) {
                for (File filesDel : root.listFiles()) {
                    if (filesDel.exists()) //перед удалением проверили, есть ли файл
                        filesDel.delete();
                }
                if (root.exists()) //проверили наличие директории перед удалением
                    root.delete();
            }
        } catch (Exception ex) {
            System.err.println("Exception while trying to delete files and root dir itself - " + ex);
        }

        if (root.exists() != true)
            return "Success!";
        else return "Fail!";
    }
}
