package spring.login.springlogin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.login.springlogin.entity.Product;
import spring.login.springlogin.entity.ProductService;
import spring.login.springlogin.post.ProductPost;

import javax.validation.Valid;

@org.springframework.stereotype.Controller
public class Controller {


    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public String getInventory(Model model) {
        model.addAttribute("products", productService.getProductList());
        return "inventory";
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.POST)
    public String addProduct(@Valid ProductPost post, BindingResult bindingResult, Model model) {
        productService.addProduct(post);
        model.addAttribute("name", post.getName());
        model.addAttribute("quantity", post.getQuantity());
        model.addAttribute("description", post.getDescription());
        model.addAttribute("products", productService.getProductList());
        return "inventory";
    }


}
