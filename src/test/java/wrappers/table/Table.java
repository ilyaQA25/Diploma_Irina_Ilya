package wrappers.table;

import wrappers.UiElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private UiElement uiElement;
    private WebDriver driver;
    private List<String> columns;

    /**
     * Данный элемент идентифицируется по тэгу <table></table>
     * @param driver
     * @param by
     */
    public Table(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UiElement(driver, by);
        this.columns = new ArrayList<>();

        for (UiElement element : uiElement.findUiElements(By.tagName("th"))) {
            columns.add(element.getText());
        }
    }

    public Table(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.uiElement = new UiElement(driver, webElement);
    }

    public TableCell getCell(int columnIndex, int rowIndex) {
        TableRow tableRow = getRow(rowIndex);
        return tableRow.getCell(columnIndex);
    }

    public TableCell getCell(String columnName, int rowIndex) {
        int columnIndex = columns.indexOf(columnName);
        return getCell(columnIndex, rowIndex);
    }

    /**
     * Данный метод получает все строки включая Header строку. Поэтому индекс будет считаться с четом этой строки
     * @param index
     * @return
     */
    public TableRow getRow(int index) {
        ArrayList<UiElement> list = (ArrayList<UiElement>) uiElement.findUiElements(By.tagName("tr"));
        return new TableRow(driver, list.get(index));
    }

    public List<TableRow> getRows() {
        List<TableRow> result = new ArrayList<>();
        ArrayList<UiElement> list = (ArrayList<UiElement>) uiElement.findUiElements(By.tagName("tr"));
        for (UiElement row : list) {
            result.add(new TableRow(driver, row));
        }

        return result;
    }

    public TableCell getCell(String targetColumnName, String uniqueValue, int expectedColumnNameIndex) {
        int columnIndex = columns.indexOf(targetColumnName);
        int rowCount = 0;

        for (TableRow row : getRows()) {
            System.out.println(rowCount);
            if (row.getCell(columnIndex).getCellAsUiElement().getText().trim().equals(uniqueValue)) {
                return row.getCell(expectedColumnNameIndex);
            }
            rowCount++;
        }

        return null;
    }
}
