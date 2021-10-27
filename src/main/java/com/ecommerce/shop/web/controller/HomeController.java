package com.ecommerce.shop.web.controller;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private ProductService productServiceImpl;
    // returns a view. the Spring template resolver resolves the
    // path and appends the .html
    @GetMapping("/index")
    public String getIndex(Model model){
        List<Product> productList = productServiceImpl.findAll();
        model.addAttribute("products", productList);
        return "index";
    }

    @GetMapping("/single/{id}")
    public ModelAndView getSingle(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("single");
        Product product = productServiceImpl.findById(id);
        log.info("view --> {}", modelAndView.getView());
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }

    @GetMapping("/contact")
    public String getContact(){
        return "contact";
    }

    @GetMapping("/product")
    public String getProduct(){
        return "product";
    }

    @GetMapping("/services")
    public String getServices(){
        return "services";
    }

    @GetMapping("/single")
    public String getSingle(){
        return "single";
    }

    // @ResponseBody tells it we're just returning a String
    @GetMapping("/say-hello")
    public @ResponseBody String getWelcomeMessage(){

        return "Welcome to my first spring application";

    }
}
