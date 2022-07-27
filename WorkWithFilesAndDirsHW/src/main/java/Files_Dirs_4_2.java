import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Files_Dirs_4_2 {
    public static ArrayList filesNdirs (String path, String extens, boolean flag) {
        File root = new File(path);

        ArrayList<File> subDirFilesList = new ArrayList<>(); //в список занесли список файлов
        ArrayList<File> subDirsList = new ArrayList<>(); //в список занесли список каталогов

        subDirFilesList.addAll(List.of(root.listFiles((directory, name) -> name.endsWith(extens))));
        subDirsList.addAll(List.of(root.listFiles((directory) -> directory.isDirectory())));

        if (flag == true) { //ищем файлы в подкаталогах и подподкаталоги
            for (File fileLoop : root.listFiles((directory) -> directory.isDirectory())) {
                subDirFilesList.addAll(Arrays.asList(fileLoop.listFiles((directory, name) -> name.endsWith(extens))));
                subDirsList.addAll(Arrays.asList(fileLoop.listFiles((directory) -> directory.isDirectory())));
            }
        }

        //перевести список типов File (все файлы) в список типов String
        ArrayList<String> listOfStringFiles = new ArrayList<>();
        for (File loopStringFiles : subDirFilesList) {
            listOfStringFiles.addAll(Collections.singleton(loopStringFiles
                    .toString().substring(loopStringFiles.toString()
                            .lastIndexOf('/') + 1)));
        }

        //перевести список типов File (все папки и подподпапки) в список типов String
        ArrayList<String> listOfStringDirs = new ArrayList<>();
        for (File loopStringDirs : subDirsList) {
            listOfStringDirs.addAll(Collections.singleton(loopStringDirs
                    .toString().substring(loopStringDirs.toString()
                            .lastIndexOf('/') + 1)));
        }

        ArrayList<ArrayList<String>> finalPrint = new ArrayList<ArrayList<String>>();
        finalPrint.add(listOfStringFiles);
        finalPrint.add(listOfStringDirs);

        return finalPrint;
    }
}
