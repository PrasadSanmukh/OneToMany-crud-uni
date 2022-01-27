package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.onetomany.AmezonOrder;
import com.ty.onetomany.Item;

public class Test {

	public static void main(String[] args) {
		AmezonOrder a1=new AmezonOrder();
         a1.setId(48);
         a1.setAddress("bengalore");
         a1.setPrice(45000);
         
         Item i1=new Item();
         i1.setId(12);
         i1.setCost(20);
         i1.setName( "pen");
         
         Item i2=new Item();
         i2.setId(13);
         i2.setCost(50);
         i2.setName( "book");
         List<Item> list=new ArrayList<Item>();
         list.add(i1);
         list.add(i2);
         a1.setItem(list);
          
         Orderdao od=new Orderdao();
         od.saveOrder(a1);
	}

}
