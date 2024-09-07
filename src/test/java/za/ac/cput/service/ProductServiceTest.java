package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    private static Product product1, product2, product3;

    @BeforeEach
    void setUp() {
        product1 = new Product.Builder()
                .setProductId(1L)
                .setName("Golfer t-shirt")
                .setDescription("Black medium shirt.")
                .setPrice(200)
                .setStock(10)
                .setCategoryId(1L)
                .setCreatedAt(LocalDate.now().atStartOfDay())
                .setUpdatedAt(LocalDate.now().atStartOfDay())
                .setImagePath("path/to/image.jpg")
                .build();
//        product1 = ProductFactory.buildProduct(
//                1L,
//                "Golfer t-shirt",
//                "Black medium shirt.",
//                200,
//                10,
//                1L,
//                LocalDate.now().atStartOfDay(),
//                LocalDate.now().atStartOfDay(),
//                "path/to/image.jpg"
//        );

        product2 = new Product.Builder()
                .setProductId(1L)
                .setName("V-neck t-shirt")
                .setDescription("Blue slim fit shirt.")
                .setPrice(150)
                .setStock(15)
                .setCategoryId(1L)
                .setCreatedAt(LocalDate.now().atStartOfDay())
                .setUpdatedAt(LocalDate.now().atStartOfDay())
                .setImagePath("path/to/image.jpg")
                .build();
//        product2 = ProductFactory.buildProduct(
//                1L,
//                "V-neck t-shirt",
//                "Blue slim fit shirt",
//                150,
//                15,
//                1L,
//                LocalDate.now().atStartOfDay(),
//                LocalDate.now().atStartOfDay(),
//                "path/to/image.jpg"
//        );

        product3 = new Product.Builder()
                .setProductId(1L)
                .setName("Crew neck t-shirt")
                .setDescription("Green slim fit shirt")
                .setPrice(125)
                .setStock(20)
                .setCategoryId(1L)
                .setCreatedAt(LocalDate.now().atStartOfDay())
                .setUpdatedAt(LocalDate.now().atStartOfDay())
                .setImagePath("path/to/image.jpg")
                .build();
//        product3 = ProductFactory.buildProduct(
//                1L,
//                "Crew neck t-shirt",
//                "Green slim fit shirt",
//                125,
//                20,
//                1L,
//                LocalDate.now().atStartOfDay(),
//                LocalDate.now().atStartOfDay(),
//                "path/to/image.jpg"
//        );
    }

    @Order(1)
    @Test
    void create() {
        Product createdProduct1 = productService.create(product1);
        assertNotNull(createdProduct1);
        assertEquals(product1.getName(), createdProduct1.getName());
        System.out.println("Product 1: "+ createdProduct1);

        Product createdProduct2 = productService.create(product2);
        assertNotNull(createdProduct2);
        assertEquals(product2.getName(), createdProduct2.getName());
        System.out.println("Product 2: "+ createdProduct2);

        Product createdProduct3 = productService.create(product3);
        assertNotNull(createdProduct3);
        assertEquals(product3.getName(), createdProduct3.getName());
        System.out.println("Product 3: "+ createdProduct3);
    }

    @Order(2)
    @Test
    void read() {
        Product createProduct1 = productService.create(product1);
        Product readProduct1 = productService.read(product1.getProductId());
        assertNotNull(readProduct1);
        assertEquals(createProduct1.getProductId(), readProduct1.getProductId());
        System.out.println("Read product 1:"+ readProduct1);

        Product createProduct2 = productService.create(product2);
        Product readProduct2 = productService.read(product2.getProductId());
        assertNotNull(readProduct2);
        assertEquals(createProduct2.getProductId(), readProduct2.getProductId());
        System.out.println("Read product 2:"+ readProduct2);
    }

    @Order(3)
    @Test
    void update() {
        Product createProduct2 = productService.create(product2);
        System.out.println("Product 2 before update: "+ product2);
        createProduct2 = new Product.Builder()
                .copy(createProduct2)
                .setDescription("Blue V-neck t-shirt. Slim fit, medium. ")
                .build();
        Product updateProduct2 = productService.update(createProduct2);
        assertNotNull(updateProduct2);
        assertEquals(createProduct2.getDescription(), updateProduct2.getDescription());
        System.out.println("Product 2 after update: "+ updateProduct2);
    }

    @Order(5)
    @Test
    void delete() {
        Product createProduct3 = productService.create(product3);
        System.out.println("Product to be deleted: "+ createProduct3);
        boolean deleteProduct = productService.delete(createProduct3.getProductId());
        assertTrue(deleteProduct);
        System.out.println("Deleted status:"+ deleteProduct);
    }

    @Order(4)
    @Test
    void getAll() {
        Product createProduct1 = productService.create(product1);
        Product createProduct2 = productService.create(product2);
        Product createProduct3 = productService.create(product3);
        List<Product> productList = productService.getAll();
        assertFalse(productList.isEmpty());
        System.out.println(productList);
    }
}