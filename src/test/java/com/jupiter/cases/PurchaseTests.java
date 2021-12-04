package com.jupiter.cases;

import com.jupiter.common.BaseTest;
import com.jupiter.common.Utils;
import com.jupiter.models.ProductInfo;
import com.jupiter.pages.CartPage;
import com.jupiter.pages.HomePage;
import com.jupiter.pages.ShopPage;
import org.junit.Assert;
import org.junit.Test;

import static com.jupiter.common.Pages.*;

public class PurchaseTests extends BaseTest {

    @Test
    public void TC_03_Verify_Items_In_Cart() {
        HomePage homePage = (HomePage) jupterPageFactory.getWebPage(HOME_PAGE);
        homePage.clickStartShoppingBtn();

        ShopPage shopPage = (ShopPage) jupterPageFactory.getWebPage(SHOP_PAGE);
        for (ProductInfo product : dataProvider.getProductInfoListTC3()) {
            shopPage.purchase(product.productName, product.quantity);
        }
        shopPage.clickCartBtn();

        CartPage cartPage = (CartPage) jupterPageFactory.getWebPage(CART_PAGE);
        for (ProductInfo product : dataProvider.getProductInfoListTC3()) {
            Assert.assertEquals(product.price, shopPage.getProductPrice(product.productName));
            Assert.assertEquals(product.price, cartPage.getProductPrice(product.productName));
            Assert.assertEquals(product.productName, cartPage.getProductName(product.productName));
            Assert.assertEquals(Integer.toString(product.quantity), cartPage.getProductQuantity(product.productName));
        }
    }

    @Test
    public void TC_04_Verify_All_Items_Sum_In_Cart() {
        HomePage homePage = (HomePage) jupterPageFactory.getWebPage(HOME_PAGE);
        homePage.clickStartShoppingBtn();

        ShopPage shopPage = (ShopPage) jupterPageFactory.getWebPage(SHOP_PAGE);
        for (ProductInfo product : dataProvider.getProductInfoListTC4()) {
            shopPage.purchase(product.productName, product.quantity);
        }
        shopPage.clickCartBtn();

        CartPage cartPage = (CartPage) jupterPageFactory.getWebPage(CART_PAGE);
        float totalPrice = 0f;
        for (ProductInfo product : dataProvider.getProductInfoListTC4()) {
            Assert.assertEquals(product.productName, cartPage.getProductName(product.productName));
            Assert.assertEquals(product.price, shopPage.getProductPrice(product.productName));
            Assert.assertEquals(product.price, cartPage.getProductPrice(product.productName));
            Assert.assertEquals(Integer.toString(product.quantity), cartPage.getProductQuantity(product.productName));
            float subtotal = Utils.calculateSubtotal(product.price, product.quantity);
            Assert.assertEquals(Utils.reFormatFloat(subtotal), cartPage.getProductSubtotal(product.productName));
            totalPrice += subtotal;
        }
        Assert.assertEquals(Utils.reFormatTotalPrice(Utils.convertPrecision(totalPrice)), cartPage.getTotalPrice());
    }
}
