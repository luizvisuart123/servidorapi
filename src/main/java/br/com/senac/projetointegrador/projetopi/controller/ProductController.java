package br.com.senac.projetointegrador.projetopi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.projetointegrador.projetopi.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

   
    
	  @GetMapping("/products")
	  public List<String> getAllProducts() {
	      return productService.getAllProducts();
	  }
    
	  @GetMapping("/imc")
	  public String getImc(
			  @RequestParam double peso,
	          @RequestParam double altura,
	          @RequestParam String sexo) {
	      return productService.calculaIMC(peso, altura, sexo);
	  }
	  
	  @GetMapping("/agua")
	  public List<String> getQuantidadeAgua() {
	      return productService.getAllProducts();
	  }
}

