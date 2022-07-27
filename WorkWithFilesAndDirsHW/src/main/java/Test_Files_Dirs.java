import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test_Files_Dirs {

    public static void main(String[] args) throws IOException {

        String path = "."; //указание адреса папки
        String extens = ".xml"; //маска для поиска расширения
        boolean flag = true; //флажок

        File root = new File(path); //задали первичный адрес
       // File[] findFiles = root.listFiles((directory, name) -> name.endsWith(extens)); //в массив занесли список файлов
       // File[] findDirs = root.listFiles((directory) -> directory.isDirectory()); //в массив занесли список каталогов

        ArrayList<File> subDirFilesList = new ArrayList<>(); //в список занесли список файлов
        ArrayList<File> subDirsList = new ArrayList<>(); //в список занесли список каталогов

        subDirFilesList.addAll(List.of(root.listFiles((directory, name) -> name.endsWith(extens))));
        subDirsList.addAll(List.of(root.listFiles((directory) -> directory.isDirectory())));
        // subDirFilesList.addAll(Arrays.asList(findFiles));
        //  subDirsList.addAll(Arrays.asList(findDirs));

        System.out.println("subDirFilesList = " + subDirFilesList);
        System.out.println("subDirsList = " + subDirsList);


        if (flag == true) { //ищем файлы в подкаталогах и подподкаталоги
            for (File fileLoop : root.listFiles((directory) -> directory.isDirectory())) {
               // File[] tempForFiles = fileLoop.listFiles((directory, name) -> name.endsWith(extens));
                subDirFilesList.addAll(Arrays.asList(fileLoop.listFiles((directory, name) -> name.endsWith(extens))));
              //  File[] tempForDirs = fileLoop.listFiles((directory) -> directory.isDirectory());
                subDirsList.addAll(Arrays.asList(fileLoop.listFiles((directory) -> directory.isDirectory())));
            }
        }

        /*
        //перевели массив типов File в массив типов String, с очисткой имен файлов от адресов
        String[] filesArray = new String[findFiles.length];
        for (int i = 0; i < findFiles.length; i++) {
            filesArray[i] = findFiles[i].toString().substring(findFiles[i].toString().lastIndexOf('/') + 1);
        }
        System.out.println("filesArray = " + Arrays.asList(filesArray));
        */

        //перевести список типов File (все файлы) в список типов String
        ArrayList<String> listOfStringFiles = new ArrayList<>();
        for (File loopStringFiles : subDirFilesList) {
            listOfStringFiles.addAll(Collections.singleton(loopStringFiles
                    .toString().substring(loopStringFiles.toString()
                            .lastIndexOf('/') + 1)));
        }
        //System.out.println(listOfStringFiles);

        //перевести список типов File (все папки и подподпапки) в список типов String
        ArrayList<String> listOfStringDirs = new ArrayList<>();
        for (File loopStringDirs : subDirsList) {
            listOfStringDirs.addAll(Collections.singleton(loopStringDirs
                    .toString().substring(loopStringDirs.toString()
                            .lastIndexOf('/') + 1)));
        }
        //System.out.println(listOfStringDirs);

        ArrayList<ArrayList<String>> finalPrint = new ArrayList<ArrayList<String>>();
        finalPrint.add(listOfStringFiles);
        finalPrint.add(listOfStringDirs);

        System.out.println(finalPrint);
    }
}
