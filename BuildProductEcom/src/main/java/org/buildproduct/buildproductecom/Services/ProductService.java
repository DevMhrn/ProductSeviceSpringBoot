package org.buildproduct.buildproductecom.Services;
import org.buildproduct.buildproductecom.dtos.FakeStoreProductDto;
import org.buildproduct.buildproductecom.models.products;

import java.util.List;

public interface ProductService {
    List<products> getAllProduct();
    products getSingleProduct(Long id);
    products createProduct(products product);

    products deleteProducts(Long id);

    products updateProduct(products product);


}
