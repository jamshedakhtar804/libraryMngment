package com.gfg.demo.manager;

import org.springframework.stereotype.Component;

@Component
public class CalculateManager {


  public String getSum(int a,int b){
    return "Sum of "+a+ " and "+b+" = "+(a+b);
  }
}
