package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OverviewPage extends Page {
    public OverviewPage(WebDriver driver) {
        super(driver);
        driver.get(getPath()+"?command=Home");
    }
    public boolean containsMealWithName(String name){
        List<WebElement> tds = driver.findElements(By.cssSelector("td"));
        for (WebElement td : tds){
            if (td.getText().equals(name)){
                return true;
            }
        }
        return false;
    }

}
