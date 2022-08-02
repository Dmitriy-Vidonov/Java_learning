import java.io.File;

public class Files_Dirs_4_3_v1 {
    public static String filesNDirsDel (String dir) {
        String res = "";
        File root = new File(dir);

        if (Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(1).toString() == "[]") {
            try {
                for (File filesDel : root.listFiles()) { //удаление файлов
                    if (filesDel.exists())
                        filesDel.delete();
                }
            } catch (Exception ex) {
                System.err.println("Exception while trying to delete files - " + ex);
            }

            try {
                if (root.exists())
                    root.delete(); //удаление каталога
                res = "Success!";
            } catch (Exception ex1) {
                System.err.println("Exception while trying to delete directory - " + ex1);
            }

        } else res = "Fail!";

        return res;
    }
}
