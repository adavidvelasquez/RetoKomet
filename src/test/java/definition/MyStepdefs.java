package definition;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.NextDestinationPage;
import pages.SpaceHomePage;
import utils.PetsModel;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static io.restassured.RestAssured.given;

public class MyStepdefs {
    WebDriver driver= new ChromeDriver();
    LoginPage loginPage=new LoginPage(driver);
    SpaceHomePage spaceHomePage = new SpaceHomePage(driver);;
    NextDestinationPage nextDestinationPage = new NextDestinationPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    String baseUrl ="https://demo.testim.io/login";
    String baseUrlApi ="https://petstore.swagger.io/v2/pet/";
    String baseUrlApiId ="";
    String json ="";


    @Given("ingrese con usuario {string} y contraseña {string}")
    public void ingreseConUsuarioYContraseña(String user, String password) {

        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        driver.manage().window().maximize();
        loginPage.loginToTestimio(user, password);

    }

    @When("ingreso la informacion necesaria del destino")
    public void ingresoLaInformacionNecesariaDelDestino() throws InterruptedException {
        spaceHomePage.SetDates();
        spaceHomePage.setAdultNum();
        spaceHomePage.setChildrenNum();
        nextDestinationPage.setLaunch();
        nextDestinationPage.setPlanetColor();
        nextDestinationPage.setBookButton();
    }

    @Then("procedo con el checkout")
    public void procedoConElCheckout() throws InterruptedException {
        checkoutPage.setCustomerName("Anderson");
        checkoutPage.setCustomerEmail("Anderson@gmail.com");
        checkoutPage.setSocialSec("222-22-2222");
        checkoutPage.setPhoneNum("+1 419-223-1234");
        checkoutPage.payNowAct();
    }



    @When("valido el metodo get")
    public void validoElMetodoGet() {
      given().when().get(baseUrlApiId).then().assertThat().statusCode(200);
    }


    @Given("quiero consultar la mascota con el id {int}")
    public void quieroConsultarLaMascotaConElId(int id) {
        baseUrlApiId=baseUrlApi+id;

    }

    @Then("valido la respuesta en el body")
    public void validoLaRespuestaEnElBody() {
        Response response = given().when().get(baseUrlApiId);
        String bodyAsString= response.getBody().asString();
        System.out.println(bodyAsString);
    }

    @Given("tengo la data para crear la mascota")
    public void tengoLaDataParaCrearLaMascota() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        PetsModel pet = objectMapper.readValue(new File("src/test/resources/data/json.json"), PetsModel.class);
        json = objectMapper.writeValueAsString(pet);
        System.out.println(json);


    }

    @When("valido el metodo post")
    public void validoElMetodoPost() throws IOException {

        Response response = given()
                .contentType(ContentType.JSON)
                .body(json)
                .when().post(baseUrlApi);
        String bodyAsString= response.getBody().asString();
        System.out.println(bodyAsString);
    }

    @Then("valido la respuesta en el body post")
    public void validoLaRespuestaEnElBodyPost() throws IOException {

        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post(baseUrlApi).then().assertThat().statusCode(200);;
    }
   @After
    public void exit(){
       driver.quit();
    }
}
