package id.ac.ui.cs.advprog.eshop.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
  Product product;

  @BeforeEach
  void setup() {
    this.product = new Product();
    this.product.setProductId("000000000000-0000-0000-0000-00000000");
    this.product.setProductName("Shampoo");
    this.product.setProductQuantity(100);
  }

  @Test
  void testGetProductId() {
    assertEquals("000000000000-0000-0000-0000-00000000", this.product.getProductId());
  }

  @Test
  void testGetProductName() {
    assertEquals("Shampoo", this.product.getProductName());
  }

  @Test
  void testGetProductQuantity() {
    assertEquals(100, this.product.getProductQuantity());
  }
}
