package com.example.demo.DTO;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product {
    private long id;
    private String name;
    private int qty;
    private String thumbnail;
    private String image;
    private int price;
    private String source;
    private String created;
    private String update;
    private String status;
    private String note;
    private long typeId;
    private long sourceId;

}
