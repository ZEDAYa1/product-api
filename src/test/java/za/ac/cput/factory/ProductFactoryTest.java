package za.ac.cput.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Product;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {
    @Test
    void buildProduct() {
        Product product = ProductFactory.buildProduct(
                1L,
                "Golfer",
                "White Golf t-shirt. Slim fit.",
                150,
                30,
                1L,
                LocalDate.now().atStartOfDay(),
                LocalDate.now().atStartOfDay(),
                "path/to/image.jpg"
        );
        assertNotNull(product);
        System.out.println("Build product: "+ product.toString());
    }
}