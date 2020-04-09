package utilities;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    private FileInputStream fileInputStream;
    private Logger logger = Logger.getLogger(ExcelReader.class);
    private XSSFWorkbook xssfWorkbook;

    public void readExcelData(String filePath,String sheetName){
        try {
            fileInputStream = new FileInputStream(filePath);
        }catch (FileNotFoundException f)
        {
            logger.error(f.getMessage());
        }
        try {
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
        }catch (IOException i)
        {
            logger.error(i.getMessage());
        }
        XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
        Object excelData[][] = new Object[xssfSheet.getLastRowNum()][xssfSheet.getRow(0).getLastCellNum()];
    //TODO
    }
}
