package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setup() {
        // I have an auto id generator built into ProductRepository
        // starts from 0001, 0002, 0003, ...
        // so I deleted everything about the id
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("000000000000-0000-0000-0000-00000000");
        product.setProductName("Shampoo");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductName("Shampoo");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductName("Kecap");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());

        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());

        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindByIdSuccess() {
        Product product = new Product();
        product.setProductName("Shampoo");
        product.setProductQuantity(100);
        productRepository.create(product);

        String product1Id = "0001";
        Product foundProductById = productRepository.findById(product1Id);
        assertEquals(product, foundProductById);
    }

    @Test
    void testFindByIdFail() {
        Product product = new Product();
        product.setProductName("Shampoo");
        product.setProductQuantity(100);
        productRepository.create(product);

        String unexistingProductId = "0002";
        Product foundProductById = productRepository.findById(unexistingProductId);
        assertEquals(null, foundProductById);
    }

    @Test
    void testEdit_productNotFound() {
        Product product = new Product();
        product.setProductName("Shampoo");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product unexistingProduct = new Product();
        unexistingProduct.setProductName("Kecap");
        unexistingProduct.setProductQuantity(50);

        Product editedProduct = productRepository.edit(unexistingProduct);
        assertEquals(null, editedProduct);
    }

    @Test
    void testEdit_productFound() {
        Product product = new Product();
        product.setProductName("Shampoo");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product editedProduct = new Product();
        editedProduct.setProductId(product.getProductId());
        editedProduct.setProductName("Shazam");
        editedProduct.setProductQuantity(10);

        Product returnedProduct = productRepository.edit(editedProduct);
        assertEquals(product, returnedProduct);
        assertEquals("Shazam", returnedProduct.getProductName());
        assertEquals(10, returnedProduct.getProductQuantity());
    }

    @Test
    void testDelete_productFound() {
        Product product = new Product();
        product.setProductName("Shampoo");
        product.setProductQuantity(100);
        productRepository.create(product);

        String productId = product.getProductId();
        boolean productDeleted = productRepository.delete(productId);
        assertTrue(productDeleted);
    }

    @Test
    void testDelete_productNotFound() {
        Product product = new Product();
        product.setProductName("Shampoo");
        product.setProductQuantity(100);
        productRepository.create(product);

        String unexistingProductId = "0000";
        boolean productDeleted = productRepository.delete(unexistingProductId);
        assertFalse(productDeleted);
    }

    @Test
    void testGetSize() {
        assertEquals(0, productRepository.size());

        Product product1 = new Product();
        product1.setProductName("Shampoo");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        assertEquals(1, productRepository.size());

        Product product2 = new Product();
        product2.setProductName("Kecap");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        assertEquals(2, productRepository.size());
    }
}
