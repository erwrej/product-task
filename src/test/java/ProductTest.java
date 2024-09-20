import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    Product dough;
    Product flour;
    Product eggs;
    Product water;
    Product caffeine;
    Product wheat;
    Product vanilla;
    Product cocoa;
    Product cake;

    @BeforeEach
    void createProducts() {
        dough = new Product("Тесто");
        flour = new Product("Мука");
        eggs = new Product("Яйца");
        water = new Product("Вода");
        caffeine = new Product("Кофеин");
        wheat = new Product("Пшеница");
        vanilla = new Product("Ванилин");
        cocoa = new Product("Какао");
        cake = new Product("Торт");
    }


    @Test
    void fourOfSixProductsShouldBeAdded() {
        assertAll(
                () -> assertTrue(dough.addProduct(flour)),
                () -> assertTrue(dough.addProduct(eggs)),
                () -> assertTrue(dough.addProduct(water)),
                () -> assertFalse(flour.addProduct(dough)),
                () -> assertTrue(flour.addProduct(wheat)),
                () -> assertFalse(wheat.addProduct(dough))
        );
    }

    @Test
    void allProductsShouldBeAdded() {
        assertAll(
                () -> assertTrue(cake.addProduct(vanilla)),
                () -> assertTrue(cake.addProduct(cocoa)),
                () -> assertTrue(cake.addProduct(dough)),
                () -> assertTrue(cocoa.addProduct(caffeine)),
                () -> assertTrue(cocoa.addProduct(water)),
                () -> assertTrue(dough.addProduct(flour)),
                () -> assertTrue(dough.addProduct(eggs)),
                () -> assertTrue(dough.addProduct(water))
        );
    }

    @Test
    void productTreeStructureShouldBeCorrect() {
        dough.addProduct(flour);
        dough.addProduct(eggs);
        eggs.addProduct(water);
        water.addProduct(dough);
        water.addProduct(eggs);

        assertAll(
                () -> assertEquals(2, dough.getChildProducts().size()),
                () -> assertTrue(dough.getChildProducts().contains(flour)),
                () -> assertTrue(dough.getChildProducts().contains(eggs)),
                () -> assertEquals(0, flour.getChildProducts().size()),
                () -> assertEquals(1, eggs.getChildProducts().size()),
                () -> assertEquals(0, water.getChildProducts().size()),
                () -> assertTrue(eggs.getChildProducts().contains(water))
        );
    }
}
