package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {
    @InjectMocks
    ProductServiceImpl productService = new ProductServiceImpl();

    @BeforeEach
    void setup() {}

    @Test
    void testCreate() {
        Product product = new Product();
        product.setProductName("Book");
        product.setProductQuantity(10);

        Product createdProduct = productService.create(product);

        assertEquals(product, createdProduct);
        assertEquals(1, productService.getProductRepository().size());
    }

    @Test
    void testFindAll() {
        Product product1 = new Product();
        product1.setProductName("Book");
        product1.setProductQuantity(10);
        Product createdProduct1 = productService.create(product1);

        Product product2 = new Product();
        product2.setProductName("Pencil");
        product2.setProductQuantity(20);
        Product createdProduct2 = productService.create(product2);

        Product product3 = new Product();
        product3.setProductName("Eraser");
        product3.setProductQuantity(40);
        Product createdProduct3 = productService.create(product3);

        List<Product> productList = productService.findAll();

        assertEquals(createdProduct1, productList.get(0));
        assertEquals(createdProduct2, productList.get(1));
        assertEquals(createdProduct3, productList.get(2));
        assertEquals(3, productService.getProductRepository().size());
    }

    @Test
    void testFindById() {
        Product product1 = new Product();
        product1.setProductName("Book");
        product1.setProductQuantity(10);
        Product createdProduct1 = productService.create(product1);

        Product product2 = new Product();
        product2.setProductName("Pencil");
        product2.setProductQuantity(20);
        Product createdProduct2 = productService.create(product2);

        Product product3 = new Product();
        product3.setProductName("Eraser");
        product3.setProductQuantity(40);
        Product createdProduct3 = productService.create(product3);

        String product1Id = product1.getProductId();
        String product2Id = product2.getProductId();
        String product3Id = product3.getProductId();

        assertEquals(createdProduct1, productService.findById(product1Id));
        assertEquals(createdProduct2, productService.findById(product2Id));
        assertEquals(createdProduct3, productService.findById(product3Id));
    }

    @Test
    void testEdit() {
        Product product = new Product();
        product.setProductName("Book");
        product.setProductQuantity(10);
        Product createdProduct = productService.create(product);

        String nameBeforeEdit = createdProduct.getProductName();
        int quantityBeforeEdit = createdProduct.getProductQuantity();

        assertEquals("Book", nameBeforeEdit);
        assertEquals(10, quantityBeforeEdit);

        Product editedProduct = new Product();
        editedProduct.setProductId(product.getProductId());
        editedProduct.setProductName("Books");
        editedProduct.setProductQuantity(100);
        productService.edit(editedProduct);

        Product result = productService.findAll().getFirst();

        assertEquals(1, productService.getProductRepository().size());
        assertEquals("Books", result.getProductName());
        assertEquals(100, result.getProductQuantity());
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductName("Book");
        product.setProductQuantity(10);
        Product createdProduct = productService.create(product);

        assertEquals(1, productService.getProductRepository().size());

        String createdProductId = createdProduct.getProductId();
        productService.delete(createdProductId);

        assertEquals(0, productService.getProductRepository().size());
    }
}
