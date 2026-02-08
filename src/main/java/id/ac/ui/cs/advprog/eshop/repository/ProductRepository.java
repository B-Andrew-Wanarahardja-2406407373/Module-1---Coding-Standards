package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    private int idCounter = 1;

    public Product create(Product product) {
        String productId = String.format("%04d",idCounter);
        product.setProductId(productId);
        idCounter++;

        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String productId) {
        for (int repoIndex=0 ; repoIndex<productData.size() ; repoIndex++) {
            if (productData.get(repoIndex).getProductId().equals(productId)) {
                return productData.get(repoIndex);
            }
        }
        return null;
    }
    public void edit(Product updatedProduct) {
        Product product = findById(updatedProduct.getProductId());
        if (product != null) {
            product.setProductName(updatedProduct.getProductName());
            product.setProductQuantity(updatedProduct.getProductQuantity());
        }
    }
}
