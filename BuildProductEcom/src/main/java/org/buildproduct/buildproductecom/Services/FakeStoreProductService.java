package org.buildproduct.buildproductecom.Services;

import ch.qos.logback.classic.spi.TurboFilterList;
import org.buildproduct.buildproductecom.dtos.FakeStoreCategoryDto;
import org.buildproduct.buildproductecom.dtos.FakeStoreProductDto;
import org.buildproduct.buildproductecom.models.Category;
import org.buildproduct.buildproductecom.models.products;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{



    private RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<products> getAllProduct() {

        FakeStoreProductDto[] all_product = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );

        List<products> list = new ArrayList<products>();


        for(FakeStoreProductDto ele: all_product){
            products product = new products();
            product.setId(ele.getId());
            product.setTitle(ele.getTitle());
            product.setDescription(ele.getDescription());
            product.setPrice(ele.getPrice());
            product.setImage(ele.getImage());
            Category category = new Category();
            category.setName(ele.getCategory());
            product.setCategory(category);

            list.add(product);

        }




        return list;
    }




    @Override
    public products getSingleProduct(Long id) {
       FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
              "https://fakestoreapi.com/products/"+ id,
               FakeStoreProductDto.class
       );
       products product  = new products();
       product.setId(fakeStoreProductDto.getId());
       product.setTitle(fakeStoreProductDto.getTitle());
       product.setPrice(fakeStoreProductDto.getPrice());
       product.setDescription(fakeStoreProductDto.getDescription());
       product.setImage(fakeStoreProductDto.getImage());

        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());
        return product;
    }


    @Override
    public products createProduct(products newProduct) {

        FakeStoreProductDto Product = new FakeStoreProductDto();
        Product.setId(newProduct.getId());
        Product.setTitle(newProduct.getTitle());
        Product.setPrice(newProduct.getPrice());
        Product.setDescription(newProduct.getDescription());
        Product.setImage(newProduct.getImage());
        Product.setCategory(newProduct.getCategory().getName());


         restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                Product,
                FakeStoreProductDto.class
        );
         return newProduct;
    }


    @Override
    public products deleteProducts(Long id) {
        products product = getSingleProduct(id);
        restTemplate.delete(
                "https://fakestoreapi.com/products/"+id
        );
        return product;


    }
    @Override
    public products updateProduct(products product){
        FakeStoreProductDto newProduct = new FakeStoreProductDto();
        newProduct.setId(product.getId());
        newProduct.setTitle(product.getTitle());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setImage(product.getImage());
        newProduct.setCategory(product.getCategory().getName());

        restTemplate.put(
                "https://fakestoreapi.com/products/" + product.getId(),
                newProduct
        );





        return product;
    }
}
