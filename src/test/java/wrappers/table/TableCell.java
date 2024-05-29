package wrappers.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.UiElement;

public class TableCell {
    private UiElement uiElement;
    private WebDriver driver;

    public TableCell(WebDriver driver, UiElement uiElement) {
        this.driver = driver;
        this.uiElement = uiElement;
    }

    public UiElement getCellAsUiElement() {
        return uiElement;
    }

//    public UiElement getCellTitle() {
//        return uiElement.findElement(By.tagName("span"));
//    }
}