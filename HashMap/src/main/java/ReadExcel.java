import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {
    private File filePath; //путь до файла
    ReadExcel(String filePath) {this.filePath = new File(filePath);} //конструктор

    public Cell getCell(int sheet, int row, int column) {
        Workbook workbook = null;
        try (FileInputStream file = new FileInputStream(filePath)) {
            workbook = new XSSFWorkbook(file);
        } catch (FileNotFoundException e) {
            System.out.println("file is not exists");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook.getSheetAt(sheet).getRow(row).getCell(column);
    }

    public static void main(String[] args) {
        final String filePath = "workbook.xlsx";
        ReadExcel readExcel = new ReadExcel(filePath);
        Cell x = readExcel.getCell(0, 100, 3);
        Cell y = readExcel.getCell(0, 101, 3);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
