package com.gfg.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Librarian {
    private int librarianId;
    private String name;
    private String contact;
    private String password;
}
