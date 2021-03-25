import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Service {
    public Area buildAreaHierarchy(XSSFSheet sheet) {
        Area rootArea = new Area("Root Area", null);

        Iterator rowIterator = sheet.iterator();
        while(rowIterator.hasNext()){
            Row row = (Row)rowIterator.next();
            if(row.getRowNum()==0){
                continue;
            }
            createSubAreas(row, rootArea);
        }

        return rootArea;
    }

    private void createSubAreas(Row row, Area parentReceived){
        Area parent = parentReceived;
        int lastColumn = row.getLastCellNum();
        for(int i = 0; i< lastColumn; i++){
            Cell cell = row.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            if(cell!=null) {
                String areaName = cell.getStringCellValue();
                Area originalArea = findDuplicate(areaName, parent.getChildren());
                if(originalArea == null) {
                    Area area = new Area(areaName, null);
                    parent.getChildren().add(area);
                    parent = area;
                } else {
                    parent = originalArea;
                }
            }else {
                int lastChildrenIndex = parent.getChildren().size()-1;
                if( lastChildrenIndex < 0) {
                    // no child exist
                    return;
                }
                parent = parent.getChildren().get(lastChildrenIndex);
            }
        }
    }

    private Area findDuplicate(String areaName, List<Area> childAreas) {
//        return childAreas.stream().anyMatch(area -> area.getName().equals(childAreas));
        for (Area area : childAreas) {
            if (area.getName().equals(areaName))
                return area;
        }
        return null;
    }
}
