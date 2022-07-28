import java.io.File;
import java.util.Arrays;

public class Files_Dirs_4_3_TEST {
    public static void main(String[] args) {
        String path = "./folder for delete";
        File root = new File(path);
        boolean flag = true;

        //проверка на наличие подкаталога
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
        }

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
        }
    }
}
