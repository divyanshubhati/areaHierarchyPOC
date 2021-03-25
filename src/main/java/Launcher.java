import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        FileInputStream fis = new FileInputStream(new File("./src/main/main-type-2.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        Service service = new Service();
        service.buildAreaHierarchy(spreadsheet);
    }
}
