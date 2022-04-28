package datadriven;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadDataConfig {
    XSSFWorkbook wb;
    XSSFSheet sheet1;

    public ReadDataConfig(String excelpath) {
        try {
            File src = new File(excelpath);
            FileInputStream appiumfile = new FileInputStream(src);
            wb = new XSSFWorkbook(appiumfile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getData(int sheetNumber, int row, int column) {
        sheet1 = wb.getSheetAt(0);
        String data = sheet1.getRow(row).getCell(column).getStringCellValue();
        return data;
    }
}