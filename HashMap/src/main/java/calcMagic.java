import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class calcMagic {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> listForCalc = new ArrayList<>(ListGen.generateList(1, 10, 100));
    /*
        //подключаемся к шаблону
        FileInputStream calcInput = new FileInputStream("testing.xlsx");
        XSSFWorkbook calc = new XSSFWorkbook(calcInput);

        FileOutputStream calcOut = new FileOutputStream("testing.xlsx");
        XSSFWorkbook calcWork = new XSSFWorkbook(calcInput);

        //Выбираем страницу
        XSSFSheet sheet = calc.getSheetAt(0);

        for(int rowsCount=0; rowsCount<100; rowsCount++) {
            XSSFRow row = sheet.createRow(rowsCount);
            XSSFCell cell = row.createCell(0);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(listForCalc.get(rowsCount));
        }
        calc.write(calcOut);
        calcOut.close(); */

        try{
            FileInputStream myCalc = new FileInputStream("testing.xlsx");
            XSSFWorkbook calcBook = new XSSFWorkbook(myCalc);
            XSSFSheet calcSheet = calcBook.getSheetAt(0);

            XSSFRow rowInt = calcSheet.getRow(0);
            System.out.println(rowInt);

            Workbook wb = WorkbookFactory.create(new File("testing.xlsx"));
            DataFormatter fmt = new DataFormatter();
            Sheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0, Row.RETURN_BLANK_AS_NULL);
                if (cell!=null) {
                    String value = fmt.formatCellValue(cell);
                    if (! value.trim().isEmpty()) {
                        System.out.println("Cell as string " + value);
                    }
                }
            }


        } catch (Exception ex) {
            System.out.println("Some error during work with calc file - " + ex);
        }
    }
}
