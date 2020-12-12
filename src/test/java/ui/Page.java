package ui;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    WebDriver driver;

    // Verander path naar waar lokaal je chromedriver staat
    String path = "http://localhost:8080/Testing_Groep12_Automation_war_exploded/Controller";

    public Page (WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getPath() {
        return path;
    }

    public String getTitle () {
        return driver.getTitle();
    }
}
