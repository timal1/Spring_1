package com.timlad.springweb.service;

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

    public String getTitleById(int id) {
        return productDao.findById(id).getTitle();
    }


    public Product getProductById(int id) {
        return productDao.findById(id);
    }


    public List<Product> getListProduct() {
        return productDao.getProducts();
    }

    public void save(Product product) {
        productDao.saveOrUpdate(product);
    }

    public void deleteById(int id) {
        productDao.deleteById(id);
    }

    public void changeCoast(int id, int delta) {
        productDao.changeCoast(id, delta);
    }

    public void create(Product product) {
        productDao.create(product);
    }
}
