package ui.steps;

import io.cucumber.datatable.DataTable;
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

import java.util.List;

import static org.junit.Assert.*;

public class MaaltijdoverzichtSteps {
    private WebDriver driver;

    // Verander path naar waar lokaal je chromedriver staat
    private String path = "http://localhost:8080/Testing_Groep12_Automation_war_exploded/Controller";

    private Page currentPage;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "/Users/.../web3pers/chromedriver");
        // windows: gebruik dubbele \\ om pad aan te geven
        // hint: zoek een werkende test op van web 2 ...
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arno\\Documents\\chromedriver.exe");
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
        page.setCategorie("broodje");
        page.setPrijs(Double.toString(2.8));
        page.setExtraInfo("geen info");
        page.submitValid();

        page = PageFactory.initElements(driver, AddPage.class);
        page.setNaam("Broodje eiersalade");
        page.setCategorie("broodje");
        page.setPrijs(Double.toString(3.2));
        page.setExtraInfo("geen info");
        page.setVegetarisch();
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

    @Given("er geen maaltijden op het menu staan")
    public void er_staan_geen_maaltijden_op_het_menu(){
        currentPage = PageFactory.initElements(driver, OverviewPage.class);
    }
    @Then("krijgt Jan een melding dat er momenteel nog geen maaltijden op het menu staan")
    public void foutmelding_nog_geen_maaltijden_op_het_menu(){
        assertEquals("Testing-Groep 12-Automation - Home", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsAlert("Er zijn momenteel geen beschikbare maaltijden op het menu"));
    }

    @Then("zou Jan de maaltijden te zien moeten krijgen met de extra informatie")
    public void zouDeMaaltijdenTeZienMoetenKrijgenMetDeExtraInformatie() {
        currentPage = PageFactory.initElements(driver, OverviewPage.class);
        assertEquals("Testing-Groep 12-Automation - Home", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsMealWithName("Broodje brie met walnoten"));
        assertTrue(((OverviewPage)currentPage).containsMealWithExtraInfo("Broodje brie met walnoten", "noten gluten", ""));
        assertTrue(((OverviewPage)currentPage).containsMealWithExtraInfo("Broodje Veggylicious", "gluten", "Vegetarisch"));
        assertTrue(((OverviewPage)currentPage).containsMealWithExtraInfo("Frikandel", "", ""));

        assertTrue(((OverviewPage)currentPage).containsMealWithName("Broodje Veggylicious"));
        assertTrue(((OverviewPage)currentPage).containsMealWithName("Frikandel"));
    }

    @Given("dat er maaltijden zijn met extra informatie")
    public void datErMaaltijdenZijnMetExtraInformatie(DataTable table) {
        AddPage page = PageFactory.initElements(driver, AddPage.class);
        List<List<String>> data = table.asLists();
        for (List<String> l : data){
            page.setNaam(l.get(0).toLowerCase());
            page.setCategorie(l.get(1).toLowerCase());
            page.setPrijs(l.get(2));
            if (l.get(3) != null){
                page.setExtraInfo(l.get(3).toLowerCase());
            }
            if (l.get(4) != null){
                page.setVegetarisch();
            }
            page.submitValid();
            page = PageFactory.initElements(driver, AddPage.class);
        }
    }

    @Given("er is een {string} met informatie over {string} en of het {string} is")
    public void erIsEenMetInformatieOverEnOfHetIs(String meal, String allergies, String vegetarian) {
        AddPage page = PageFactory.initElements(driver, AddPage.class);
        page.setNaam(meal.toLowerCase());
        page.setCategorie("Broodje");
        page.setPrijs("1");
        page.setExtraInfo(allergies.toLowerCase());
        page.setVegetarisch();
        page.submitValid();
    }
    @Then("zou Jan de {string} te zien moeten krijgen met informatie over {string} en {string}")
    public void zouJanDeTeZienMoetenKrijgenMetInformatieOverEn(String meal, String allergies, String vegetarian) {
        currentPage = PageFactory.initElements(driver, OverviewPage.class);
        assertEquals("Testing-Groep 12-Automation - Home", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsMealWithName(meal));
        assertTrue(((OverviewPage)currentPage).containsMealWithExtraInfo(meal, allergies, vegetarian));
    }

    @Given("Er is een {string} met een {string}")
    public void erIsEenMetEen(String meal, String price) {
        AddPage page = PageFactory.initElements(driver, AddPage.class);
        page.setNaam(meal);
        page.setCategorie("Broodje");
        page.setPrijs(price);
        page.setExtraInfo("");
        page.submitValid();
    }
    @Then("Ziet Jan de {string} met een {string}")
    public void zietJanDeMetEen(String meal, String price) {
        currentPage = PageFactory.initElements(driver, OverviewPage.class);
        assertEquals("Testing-Groep 12-Automation - Home", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsMealWithPrice(meal, price));
    }
}
