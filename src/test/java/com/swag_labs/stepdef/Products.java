package com.swag_labs.stepdef;

import org.testng.Assert;

import com.swag_labs.pageobjects.ProductsPageObject;

import io.cucumber.java.en.*;

public class Products {
    
    ProductsPageObject productsPageObject = new ProductsPageObject();

    @Given("user is on the products page")
    public void user_is_on_the_products_page(){
        Assert.assertTrue(productsPageObject.productsPage(), "Failed. Product page not successfully verified");
    }

    @When("all products are displayed")
    public void all_products_are_displayed(){
        Assert.assertTrue(productsPageObject.allProductsAreDisplayed(), "Failed. Not all products are displayed");
    }

    @Then("verify each product has a name, image, description, price and button")
    public void verify_each_product_has_a_name_image_description_price_and_button() {
        productsPageObject.verifyProductDetails();
    }
}
