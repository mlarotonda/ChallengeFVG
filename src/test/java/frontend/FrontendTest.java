package frontend;

import frontend.pages.CartPage;
import frontend.pages.HomePage;
import frontend.pages.ItemPage;
import frontend.pages.ResultsPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FrontendTest extends Config {

    @Test
    public void frontend_casoDeUso1() {
        String product = "Heladera Samsung";

        HomePage homePage = new HomePage(getDriver());
        homePage.closeModalButton()
                .searchForProduct(product);
        new ResultsPage(getDriver()).clickSecondItem();
        new ItemPage(getDriver()).clickComprarButton();
        CartPage cartPage = new CartPage(getDriver());

        Assertions.assertTrue(cartPage.isProductDisplayed(product),
                "El producto '" + product + "' no se encontró en el carrito.");
        getDriver().quit();
    }

    @Test
    public void frontend_casoDeUso2() {
        //Entrar a una categoria de productos, ordenar por 'Menor precio' y validar que el precio del primer producto sea menor que el siguiente
        String category = "TV y Audio";
        String brand = "LG";
        String sortOption = "Menor precio";

        HomePage homePage = new HomePage(getDriver());
        homePage.closeModalButton()
                .hoverCategories()
                .hoverCategory(category)
                .clickBrand(brand);
        ResultsPage resultsPage = new ResultsPage(getDriver());
        resultsPage.clickSortBy()
                .clickOption(sortOption);

        Assertions.assertTrue(resultsPage.getFirstPrice() <= resultsPage.getSecondPrice(),
                "El precio del primer producto $'" + resultsPage.getFirstPrice() + "' no es menor o igual al precio del segundo $'" + resultsPage.getSecondPrice());
        getDriver().quit();
    }

}
