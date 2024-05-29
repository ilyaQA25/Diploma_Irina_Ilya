package wrappers.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.UiElement;

import java.util.ArrayList;

public class TableRow {
    private UiElement uiElement;
    private WebDriver driver;

    public TableRow(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UiElement(driver, by);
    }

    public TableRow(WebDriver driver, UiElement uiElement) {
        this.uiElement = uiElement;
    }

    public TableCell getCell(int index) { // не находит ячейки относительно ряда!!!!!
        ArrayList<UiElement> list = (ArrayList<UiElement>) uiElement.findUiElements(By.xpath("./descendant::td"));
        return new TableCell(driver, list.get(index));
    }
}
