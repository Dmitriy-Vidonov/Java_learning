import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class workExcel {
    public static void main(String[] args) throws IOException {
        //Создание книги Excel
        XSSFWorkbook book = new XSSFWorkbook();
        FileOutputStream fileout = new FileOutputStream("workbook.xlsx");

        //Создание страницы
        XSSFSheet sheet = book.createSheet("Sheet 1");

        //Создаеем строку. заполняем ее до 12 - случайными значениями
        for (int rowsCount = 0; rowsCount < 12; rowsCount++) {
            XSSFRow row = sheet.createRow((short)rowsCount);
            //внутри каждого цикла создания строки - создаем ячейки - заполняем строку
            for (int columnsCount = 0; columnsCount < 12; columnsCount++) {
                XSSFCell cell = row.createCell(columnsCount); //создали ячейку
                cell.setCellType(Cell.CELL_TYPE_NUMERIC); //указали тип - числовой
                cell.setCellValue((int)(10 + Math.random() * 50)); //занесли рандомное значение
            }
        }
        //закрытие книги Excel
        book.write(fileout);
        fileout.close();
    }
}
