package spring.login.springlogin.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.login.springlogin.post.ProductPost;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductList() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void addProduct(Product pd) {
        productRepository.save(pd);
    }

    public void addProduct(ProductPost pd) {
        Product product = new Product();
        product.setName(pd.getName()).setDescription(pd.getDescription()).setQuantity(pd.getQuantity());
        productRepository.save(product);
    }

    public void updateProduct(Product pd) {
        productRepository.save(pd);

    }


}
