import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ReadXlsxExtended {
   //способ считывания содержимого ячейки зависит от типа данных в ячейке
    //тип содержимого ячейки можно определить методом getCellType()
    public static void main(String[] args) throws IOException {
        //откроем файл из заданного местоположения
        String fileLocation = "workbook.xlsx";
        FileInputStream file = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(file);

        FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
        formulaEvaluator.evaluateAll();

        int totalRowsCount = 100; //число строк, заполненных случайными значениями. Дальше в листе идут формулы
        //извлечем первый лист файла и пройдемся по каждой строке
        Sheet sheet = workbook.getSheetAt(0); //в sheet помещаем текущую книгу нашего ексель файла

        int cellInt = sheet.getRow(100).getCell(0).getCachedFormulaResultType();
        Cell cell4 = sheet.getRow(100).getCell(0);

        /*ТО ЧТО НАДО ДЛЯ ПОЛУЧЕНИЯ ЗНАЧЕНИЯ ЯЧЕЙКИ*/
        System.out.println("cell type = " + (int)formulaEvaluator.evaluate(cell4).getNumberValue());

        ArrayList<Integer> numsFromSheet = new ArrayList<>();
        for (int i=100; i<=109; i++) {
            Cell cellNums = sheet.getRow(i).getCell(3);
            if((int)formulaEvaluator.evaluate(cellNums).getNumberValue()!=0)
                numsFromSheet.add((int)formulaEvaluator.evaluate(cellNums).getNumberValue());
        }
        System.out.println("nums = " + numsFromSheet);
        }
    }
