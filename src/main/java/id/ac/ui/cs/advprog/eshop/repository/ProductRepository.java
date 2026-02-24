package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
  private List<Product> productData = new ArrayList<>();
  private int idCounter = 1;

  public Product create(Product product) {
    String productId = String.format("%04d", idCounter);
    product.setProductId(productId);
    idCounter++;

    productData.add(product);
    return product;
  }

  public Iterator<Product> findAll() {
    return productData.iterator();
  }

  public Product findById(String productId) {
    for (int repoIndex = 0; repoIndex < productData.size(); repoIndex++) {
      if (productData.get(repoIndex).getProductId().equals(productId)) {
        return productData.get(repoIndex);
      }
    }
    return null;
  }

  public Product edit(Product updatedProduct) {
    Product product = findById(updatedProduct.getProductId());
    if (product != null) {
      product.setProductName(updatedProduct.getProductName());
      product.setProductQuantity(updatedProduct.getProductQuantity());
    }
    return product;
  }

  public boolean delete(String productId) {
    return productData.removeIf(product -> product.getProductId().equals(productId));
  }

  public int size() {
    return productData.size();
  }
}
