package com.swag_labs.stepdef;

import com.swag_labs.pageobjects.BurgerMenuOptionsPageObject;
import io.cucumber.java.en.*;

public class BurgerMenuOptions {

    BurgerMenuOptionsPageObject burgerMenuOptionsPageObject = new BurgerMenuOptionsPageObject();

    @Given("user clicks on the {string}")
    @And("user click on {string}")
    @When("^user clicks on \"([^\"]*)\"$")
    public void user_clicks_on_the_burgerMenu(String clickedElement) {
        burgerMenuOptionsPageObject.clickOnElement(clickedElement);
    }

    @Then("user is redirected to the home page")
    public void user_is_redirected_to_the_home_page() {
        burgerMenuOptionsPageObject.confirmRedirectToProductsPage();
    }

    @And("items are removed from the cart")
    public void items_are_removed_from_the_cart() {
        burgerMenuOptionsPageObject.removeItemsFromCart();
    }

    @And("^user is redirected to \"([^\"]*)\" home page with title \"([^\"]*)\"$")
    public void user_is_redirected_to_sauce_labs_home_page(String saucelabs, String title) {
        burgerMenuOptionsPageObject.sauceLabsHomePage(saucelabs, title);
    }

    @Then("login page is displayed")
    public void login_page_is_displayed(){
        burgerMenuOptionsPageObject.loginPage();
    }
}