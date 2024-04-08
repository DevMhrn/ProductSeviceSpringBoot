package org.buildproduct.buildproductecom.dtos;

import lombok.Getter;
import lombok.Setter;
import org.buildproduct.buildproductecom.models.Category;
@Getter
@Setter
public class FakeStoreProductDto {
    private long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;

}
