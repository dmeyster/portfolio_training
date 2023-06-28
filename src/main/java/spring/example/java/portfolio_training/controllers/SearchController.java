package spring.example.java.portfolio_training.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.example.java.portfolio_training.beans.Product;
import spring.example.java.portfolio_training.repository.ProductRepository;

import java.util.List;

@Controller
public class SearchController {

    private final ProductRepository productRepository;

    public SearchController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model){
        System.out.println("in search controller");
        System.out.println("search criteria: "+search);

        List<Product> products = productRepository.findByNameLike(search);
        model.addAttribute("products", products);
        return "search";
    }
}

