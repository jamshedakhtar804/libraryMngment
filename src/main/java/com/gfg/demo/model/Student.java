package com.gfg.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Builder
@Setter
@Getter
public class Student {
  private int studentId;
  private String name;
  private String contact;
  private String branch;
  private String accountStatus;
  private Date registeredOn;
  private String password;

}
