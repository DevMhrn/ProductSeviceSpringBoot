package org.buildproduct.buildproductecom.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class products {
    private long id;
    private String title;
    private String description;
    private double price;
    private Category category;
    private String image;

}




