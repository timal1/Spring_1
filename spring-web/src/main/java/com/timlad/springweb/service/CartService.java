package com.timlad.springweb.service;

import com.timlad.springweb.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private List<ProductDto> cart = new ArrayList<>();

    public List<ProductDto> loadCart() {
        return cart;
    }

    public void addProductToCart(ProductDto productDto) {
        for (ProductDto p: cart
             ) {
            if (productDto.getId() == p.getId()) {
                p.setAmount(p.getAmount() + 1);
                return;
            }
        }
        cart.add(productDto);
    }

    public void deleteProductFromCart(Long id) {

        ProductDto productDto = new ProductDto();

        for (ProductDto p: cart
        ) {
            if (p.getId() == id ) {
                productDto = p;
            }
        }
        cart.remove(productDto);
    }

    public void changeAmountProduct(Long productId, int delta) {

        for (ProductDto p: cart
        ) {
            if (p.getId() == productId & p.getAmount() == 1 & delta == -1) {
                p.setAmount(1);
                return;
            }
            if (p.getId() == productId & p.getAmount() >= 1) {
                p.setAmount(p.getAmount() + delta);
                return;
            }

        }
    }
}
