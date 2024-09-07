package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.IProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    private final IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product read(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean delete(Long id) {
        if(this.productRepository.existsById(id)){
            this.productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
