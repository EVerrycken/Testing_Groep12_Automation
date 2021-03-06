package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddPage extends Page {
    @FindBy(id="naam")
    private WebElement naamField;

    @FindBy(id="prijs")
    private WebElement prijsField;

    @FindBy(id="categorie")
    private WebElement categorieField;

    @FindBy(id="extrainfo")
    private WebElement extrainfoField;

    @FindBy(id="vegetarisch")
    private WebElement vegetarischField;

    @FindBy(id="add")
    private WebElement addButton;


    public AddPage(WebDriver driver) {
        super(driver);
        driver.get(getPath()+"?command=Add");
    }

    public void setNaam(String naam){
        naamField.clear();
        naamField.sendKeys(naam);
    }
    public void setPrijs(String prijs){
        prijsField.clear();
        prijsField.sendKeys(prijs);
    }
    public void setCategorie(String categorie){
        Select select = new Select(categorieField);
        select.selectByValue(categorie.toLowerCase());
//        categorieField.clear();
//        categorieField.sendKeys(categorie);
    }
    public void setExtraInfo(String extrainfo){
        extrainfoField.clear();
        extrainfoField.sendKeys(extrainfo);
    }
    public void setVegetarisch(){
        vegetarischField.click();
    }
    public void submitValid(){
        addButton.click();
    }
    public void submitInvalid(){
        addButton.click();
    }
    public boolean hasErrorMessage (String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
    }
}
