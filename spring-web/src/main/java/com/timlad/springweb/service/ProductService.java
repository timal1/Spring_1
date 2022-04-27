package com.timlad.springweb.service;

import com.timlad.springweb.data.Customer;
import com.timlad.springweb.data.Product;
import com.timlad.springweb.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    private  ProductDao<Product> productDao;

    @Autowired
    public void setProductDao(ProductDao<Product> productDao) {
        this.productDao = productDao;
    }

    public String getTitleById(Long id) {
        return productDao.findById(id).getTitle();
    }


    public Product getProductById(Long id) {
        return productDao.findById(id);
    }


    public List<Product> getListProduct() {
        return productDao.getProducts();
    }

    public List<Customer> getCustomersByProductId(Long idProduct) {
        return productDao.getCustomersByProductId(idProduct);
    }

    public void saveOrUpdate(Product product) {
        productDao.saveOrUpdate(product);
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    public void changeCoast(Long id, double delta) {
        productDao.changeCoast(id, delta);
    }

    public void create(Product product) {
        productDao.create(product);
    }
}
