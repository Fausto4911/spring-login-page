package spring.login.springlogin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.login.springlogin.entity.Product;
import spring.login.springlogin.entity.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Controller
public class Controller {




    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public String getInventory(Model model) {
        productService.addProduct(new Product("crema pepe", (long) 5,"la mejor crema papa"));
        productService.addProduct(new Product("crema cebolla", (long) 10,"la mejor crema DE CEBOLLA "));
        productService.addProduct(new Product("pollo victorina", (long) 2,"pollo que te fascina ay que ricooooooo!"));
        model.addAttribute("products", productService.getProductList());
        System.out.println("la creta");
        return "inventory";
    }

//    @RequestMapping(value = "/home", method = RequestMethod.POST)
//    public String homePage(HttpServletRequest request, Model model) {
//        String name = request.getParameter("username");
//        if (name.equals("emma")) {
//            model.addAttribute("username", name);
//            return "home";
//        }
//        else return "error";
//    }

//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public String getHome() {
//        return "home";
//    }
//


}
