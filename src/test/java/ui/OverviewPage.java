package ui;

import org.openqa.selenium.WebDriver;

public class OverviewPage extends Page {
    public OverviewPage(WebDriver driver) {
        super(driver);
        driver.get(getPath());
    }
}
