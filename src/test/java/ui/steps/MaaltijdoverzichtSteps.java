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
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arno\\Documents\\chromedriver.exe"
        //System.setProperty("webdriver.chrome.driver", "C:\Users\user1\Desktop\TI\Jaar 1 Sem 2\Web2\chromedriverR.exe");
        driver = new ChromeDriver();
    }
    @After
    public void clean() {
        driver.get(path+"?command=RemoveAll");
        driver.quit();
    }

    @Given("dat er maaltijden op het menu staan")
    public void dat_er_maaltijden_op_het_menu_staan() {
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
    public void jan_op_het_menu_kijkt() {
        currentPage = PageFactory.initElements(driver, OverviewPage.class);
    }
    @Then("worden alle maaltijden getoond die op het menu staan")
    public void worden_alle_maaltijden_getoond_die_op_het_menu_staan() {
        assertEquals("Testing-Groep 12-Automation - Home", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsMealWithName("Broodje ham & kaas"));
        assertTrue(((OverviewPage)currentPage).containsMealWithName("Broodje eiersalade"));
    }

    @Given("er geen maaltijden op het menu staan")
    public void er_geen_maaltijden_op_het_menu_staan() {
        currentPage = PageFactory.initElements(driver, OverviewPage.class);
    }
    @Then("krijgt Jan een melding dat er momenteel nog geen maaltijden op het menu staan")
    public void krijgt_jan_een_melding_dat_er_momenteel_nog_geen_maaltijden_op_het_menu_staan(){
        assertEquals("Testing-Groep 12-Automation - Home", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsAlert("Er zijn momenteel geen beschikbare maaltijden op het menu"));
    }

    @Given("er is een {string} met informatie over {string} en of het {string} is")
    public void er_is_een_met_informatie_over_en_of_het_is(String meal, String allergies, String vegetarian) {
        AddPage page = PageFactory.initElements(driver, AddPage.class);
        page.setNaam(meal.toLowerCase());
        page.setCategorie("Broodje");
        page.setPrijs("1");
        page.setExtraInfo(allergies.toLowerCase());
        page.setVegetarisch();
        page.submitValid();
    }
    @Then("zou Jan de {string} te zien moeten krijgen met informatie over {string} en {string}")
    public void zou_jan_de_te_zien_moeten_krijgen_met_informatie_over_en(String meal, String allergies, String vegetarian) {
        currentPage = PageFactory.initElements(driver, OverviewPage.class);
        assertEquals("Testing-Groep 12-Automation - Home", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsMealWithName(meal));
        assertTrue(((OverviewPage)currentPage).containsMealWithExtraInfo(meal, allergies, vegetarian));
    }

    @Given("er is een {string} met een {string}")
    public void er_is_een_met_een(String meal, String price) {
        AddPage page = PageFactory.initElements(driver, AddPage.class);
        page.setNaam(meal);
        page.setCategorie("Broodje");
        page.setPrijs(price);
        page.setExtraInfo("");
        page.submitValid();
    }
    @Then("ziet Jan de {string} met een {string}")
    public void ziet_jan_de_met_een(String meal, String price) {
        currentPage = PageFactory.initElements(driver, OverviewPage.class);
        assertEquals("Testing-Groep 12-Automation - Home", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsMealWithPrice(meal, price));
    }

    @Given("er verschillende categorieën maaltijden zijn")
    public void er_verschillende_categorieën_maaltijden_zijn() {
        AddPage page = PageFactory.initElements(driver, AddPage.class);
        page.setNaam("Lasagne");
        page.setCategorie("pasta");
        page.setPrijs(Double.toString(4));
        page.setExtraInfo("geen info");
        page.submitValid();

        page = PageFactory.initElements(driver, AddPage.class);
        page.setNaam("Broodje martino");
        page.setCategorie("broodje");
        page.setPrijs(Double.toString(2.8));
        page.setExtraInfo("geen info");
        page.submitValid();

        page = PageFactory.initElements(driver, AddPage.class);
        page.setNaam("Tomatensoep");
        page.setCategorie("soep");
        page.setPrijs(Double.toString(3.2));
        page.setExtraInfo("geen info");
        page.submitValid();

        page = PageFactory.initElements(driver, AddPage.class);
        page.setNaam("Broodje mozzarella");
        page.setCategorie("broodje");
        page.setPrijs(Double.toString(2.5));
        page.setExtraInfo("geen info");
        page.setVegetarisch();
        page.submitValid();

    }
    @Then("zal hij de maaltijden verdeeld zien per categorie")
    public void zal_hij_de_maaltijden_verdeeld_zien_per_categorie() {
        assertEquals("Testing-Groep 12-Automation - Home", driver.getTitle());
        OverviewPage page = PageFactory.initElements(driver, OverviewPage.class);
        page.sortAllItems();
        assertTrue(((OverviewPage)currentPage).containsMealWithCategoryOnPosition("Broodje martino","broodje",2));
        assertTrue(((OverviewPage)currentPage).containsMealWithCategoryOnPosition("Broodje mozzarella","broodje",3));
        assertTrue(((OverviewPage)currentPage).containsMealWithCategoryOnPosition("Lasagne","pasta",4));
        assertTrue(((OverviewPage)currentPage).containsMealWithCategoryOnPosition("Tomatensoep","soep",5));
    }


    /*@Given("dat er maaltijden zijn met extra informatie")
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
    }*/
}
