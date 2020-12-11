package ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ui.AddPage;
import ui.OverviewPage;
import ui.Page;
import static org.junit.Assert.*;

public class MaaltijdoverzichtSteps {
    private WebDriver driver;
    private String path = "http://localhost:8080/Testing_Groep12_Automation_war_exploded/Controller";

    private Page currentPage;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "/Users/.../web3pers/chromedriver");
        // windows: gebruik dubbele \\ om pad aan te geven
        // hint: zoek een werkende test op van web 2 ...
        System.setProperty("webdriver.chrome.driver", "/Users/Arno/documents/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void clean() {
        driver.get(path+"?command=RemoveAll");
        driver.quit();
    }

    @Given("dat er maaltijden op het menu staan")
    public void er_staan_maaltijden_op_het_menu(){
        AddPage page = PageFactory.initElements(driver, AddPage.class);
        page.setNaam("Broodje ham & kaas");
        page.setCategorie("Broodje");
        page.setPrijs(Double.toString(2.8));
        page.setExtraInfo("");
        page.submitValid();

        page = PageFactory.initElements(driver, AddPage.class);
        page.setNaam("Broodje eiersalade");
        page.setCategorie("Broodje");
        page.setPrijs(Double.toString(3.2));
        page.setExtraInfo("Vegetarisch");
        page.submitValid();
    }
    @When("Jan op het menu kijkt")
    public void jan_kijkt_op_het_menu(){
        currentPage = PageFactory.initElements(driver, OverviewPage.class);
    }
    @Then("worden alle maaltijden getoond die op het menu staan")
    public void alle_maaltijden_worden_getoont(){
        assertEquals("Testing-Groep 12-Automation - Home", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsMealWithName("Broodje ham & kaas"));
        assertTrue(((OverviewPage)currentPage).containsMealWithName("Broodje eiersalade"));
    }
}
