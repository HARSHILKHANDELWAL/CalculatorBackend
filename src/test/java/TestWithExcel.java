import CalculatorController.ArthmeticEvaluator;
import CalculatorController.Button;
import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import static org.junit.Assert.assertEquals;


public class TestWithExcel {
    @Test
    public void testCalculateFromExcel() {

        try {
            double expected = 0;
            String current="";
            Button[] currentArr={};
            Gson gson = new Gson();
            FileInputStream file = new FileInputStream(new File("C:/temp/TestCases.xlsx"));
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    if (cell.getColumnIndex() % 2 != 0) {
                        expected= cell.getNumericCellValue();
                        assertEquals(expected, ArthmeticEvaluator.calculate(currentArr), 0.0);
                     }
                    else{
                        Button[] buttons = gson.fromJson(cell.getStringCellValue(), Button[].class);
                        currentArr=buttons;
                    }

                }
                System.out.println(" ");
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPerformOperationFromExcel() {
        try {
            double expected = 0;
            double operand1=0;
            double operand2=0;
            String current="";
            Button[] currentArr={};
            ArthmeticEvaluator arthmeticEvaluator = new ArthmeticEvaluator();
            Gson gson = new Gson();
            FileInputStream file = new FileInputStream(new File("C:/temp/TestCases.xlsx"));
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(1);
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
//                    System.out.println(cell.getColumnIndex());
                    if (cell.getColumnIndex() ==0) {
                        operand1= cell.getNumericCellValue();
                    } else if (cell.getColumnIndex()==2) {
                        operand2=cell.getNumericCellValue();
                    } else if(cell.getColumnIndex()==1){
                        current=cell.getStringCellValue();
                    }
                    else {
                        expected= cell.getNumericCellValue();
                        assertEquals(expected, ArthmeticEvaluator.performOperation(operand1,operand2,current),0.0);
                    }
                }
                System.out.println(" ");
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
