package edu.webclass.restapi.Product.Management.System.repository;

import edu.webclass.restapi.Product.Management.System.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductRepository {
    public static ArrayList<Product> products = new ArrayList<>();
    public static int lastIndex = 0;

    public ProductRepository() {
        products.add(new Product("Mobile", "Samsung", 50000000));
        products.add(new Product("Cacke", "TITOP!", 10000));
    }

    public boolean createNewProduct(Product product) {
        products.add(product);
        if (ProductRepository.lastIndex == ProductRepository.products.size()) {
            return true;
        } else {
            return false;
        }
    }

    public List<Product> findAllProducts() {
        return products;
    }

    public static class NotFoundException extends Exception {
        private final int status;

        public NotFoundException(String message, int status) {
            super(message);
            this.status = status;
        }
    }

    public Product findProductById(String productId) throws NotFoundException {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        throw new NotFoundException("The Product with the product ID '" + productId + "' was not found", 404);
    }
}
