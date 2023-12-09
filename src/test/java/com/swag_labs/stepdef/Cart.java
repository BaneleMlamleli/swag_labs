package com.swag_labs.stepdef;

import com.swag_labs.pageobjects.CartPageObject;

import io.cucumber.java.en.*;

public class Cart {

    CartPageObject cart = new CartPageObject();

    @Given("user adds Backpack and T-Shirt in the cart")
    public void user_purchase_two_items() {
        cart.addToCart();
    }

    @When("user click on the Cart")
    public void user_click_on_the_cart() {
        cart.clickCart();
    }

    @Then("user verify items and quantity")
    public void user_verify_items_and_quantity() {
        cart.verifyItemsAndQuantity();
    }
    
    @And("click on Continue Shopping to go back to the products page")
    public void go_back_to_the_products_page() {
        cart.productsPage();        
    }
    
}
