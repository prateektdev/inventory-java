package com.research.inventory.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class InventoryController {

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }
         
    @RequestMapping(value="/products",method = RequestMethod.GET)
    public String productsPage(){
        return "products";
    }
    
    @RequestMapping(value="/add-product",method = RequestMethod.GET)
    public String addProductsPage(){
        return "add-product";
    }
    
    @RequestMapping(value="/users",method = RequestMethod.GET)
    public String usersPage(){
        return "user";
    }
    
    @RequestMapping(value="/add-user",method = RequestMethod.GET)
    public String addUsersPage(){
        return "add-user";
    }
    
    @RequestMapping(value="/orders",method = RequestMethod.GET)
    public String ordersPage(){
        return "orders";
    }
    
    @RequestMapping(value="/stock",method = RequestMethod.GET)
    public String stockPage(){
        return "stock";
    }
    @RequestMapping(value="/404",method = RequestMethod.GET)
    public String errorPage(){
        return "404";
    }
}