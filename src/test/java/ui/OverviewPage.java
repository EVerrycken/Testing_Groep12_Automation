package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OverviewPage extends Page {
    @FindBy(id="sort")
    WebElement link;

    public OverviewPage(WebDriver driver) {
        super(driver);
        driver.get(getPath()+"?command=Home");
    }
    public boolean containsMealWithName(String name){
        List<WebElement> tds = driver.findElements(By.cssSelector("td"));
        for (WebElement td : tds){
            if (td.getText().toLowerCase().equals(name.toLowerCase())){
                return true;
            }
        }
        return false;
    }
    public boolean containsMealWithExtraInfo(String name, String allergies, String vegetarian){
        List<WebElement> trs = driver.findElements(By.cssSelector("tr"));
        for (WebElement tr : trs){
            if (tr.getText().toLowerCase().contains(name.toLowerCase()) && tr.getText().toLowerCase().contains(allergies.toLowerCase())){
                if (!vegetarian.trim().isEmpty()){
                    if (tr.getText().toLowerCase().contains(vegetarian.toLowerCase())){
                        return true;
                    }
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
    public boolean containsMealWithPrice(String meal, String price){
        price = price.replace(".", ",");
        List<WebElement> trs = driver.findElements(By.cssSelector("tr"));
        for (WebElement tr : trs){
            if (tr.getText().toLowerCase().contains(meal.toLowerCase()) && (tr.getText().toLowerCase().contains(price))){
                return true;
            }
        }
        return false;
    }
    public boolean containsAlert(String alert){
        WebElement alertElement = driver.findElement(By.className("alert"));
        return alertElement.getText().equals(alert);
    }

    public void sortAllItems(){
        link.click();
    }
}
