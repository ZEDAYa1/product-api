package za.ac.cput.service;

import za.ac.cput.domain.Product;

public interface IProductService extends IService<Product, Long>{
    boolean delete(Long id);
}
