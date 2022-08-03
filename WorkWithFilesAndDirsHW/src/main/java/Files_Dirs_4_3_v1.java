import java.io.File;

public class Files_Dirs_4_3_v1 {
    public static String filesNDirsDel (String dir) {
        String res = "";
        File root = new File(dir);

        try {
            if (Files_Dirs_4_2.filesNdirs(dir, "*.*", false).get(1).toString() == "[]") {

                for (File filesDel : root.listFiles()) { //удаление файлов
                    if (filesDel.exists())
                        filesDel.delete();
                }

                if (root.exists())
                    root.delete(); //удаление каталога
                res = "Success!";
            } else res = "Fail!";

        } catch (Exception ex) {
            System.out.println("Exception while trying to delete files and main directory - " + ex);
        }
        return res;
    }
}
