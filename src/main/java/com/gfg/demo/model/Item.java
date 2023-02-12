package com.gfg.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class Item {
    @NotNull
    private int itemId;
    private String name;
    private String author;
    private String publisher;
    private String category;
    private int availableCopies;
}
