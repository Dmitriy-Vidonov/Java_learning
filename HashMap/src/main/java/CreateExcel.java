import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class CreateExcel {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> finList = new ArrayList<Integer>(ListGen.generateList(1, 10, 100));
        int N=10;
        try {
            //Создание книги Excel
            XSSFWorkbook book = new XSSFWorkbook();
            FileOutputStream fileout = new FileOutputStream("workbook.xlsx");

            //Создание страницы
            XSSFSheet sheet = book.createSheet("Sheet 1");

            int rowsCount;
            //Создаем строки от 1 до 100. заполняем их значениями из массива
            for (rowsCount = 0; rowsCount < 100; rowsCount++) {
                XSSFRow row = sheet.createRow((short)rowsCount);
                XSSFCell cell = row.createCell(0); //создали ячейку
                cell.setCellType(Cell.CELL_TYPE_NUMERIC); //указали тип - числовой
                cell.setCellValue(finList.get(rowsCount)); //занесли рандомное значение
            }
            String strFormula;
            //Проставить формулы подсчета количества вхождений в массив
            for (int i=1; i<=10; i++) {
                //Задаем ячейки с формулами подсчета значений
                XSSFRow row = sheet.createRow((short)rowsCount+i-1);
                XSSFCell cell = row.createCell(0); //создали ячейку
                strFormula = "COUNTIF($A$1:$A$100," + String.valueOf(i) + ")";
                cell.setCellType(Cell.CELL_TYPE_FORMULA); //указали тип - формула
                cell.setCellFormula(strFormula);

                //Проставили во второй столбец значения от 1 до 10
                XSSFCell cell2 = row.createCell(1); //создали ячейку во втором столбце
                cell2.setCellType(Cell.CELL_TYPE_NUMERIC); //указали тип - числовой
                cell2.setCellValue(i);

                //Проставили следующую партию формул - расчет числа вхождений чисел относительно параметра N
                XSSFCell cell3 = row.createCell(2); //создали ячейку в 3-ем столбце
                strFormula = "IF(A" + String.valueOf(100+i) + ">=" + N + ",TRUE())";
                cell3.setCellType(Cell.CELL_TYPE_FORMULA); //указали тип - формула
                cell3.setCellFormula(strFormula);

                //Проставляем партию формул, где получаем числа, соответствующие числу вхождений >= N
                XSSFCell cell4 = row.createCell(3); //создали ячейку в 4-ом столбце
                strFormula = "IF(C" + String.valueOf(100+i) + "=1" + ",B" + String.valueOf(100+i) + ")";
                cell4.setCellType(Cell.CELL_TYPE_FORMULA); //указали тип - формула
                cell4.setCellFormula(strFormula);
            }
            //закрытие книги Excel
            book.write(fileout);
            fileout.close();
        } catch (Exception ex) {
            System.out.println("An error during create excel file - " + ex);
        }
        //считать данные из последнего столбца формул и занести его в массив
    }
}
