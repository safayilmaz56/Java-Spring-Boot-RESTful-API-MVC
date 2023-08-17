package com.teknopar.northwindDeneme.apiController;

import com.teknopar.northwindDeneme.model.Product;
import com.teknopar.northwindDeneme.service.abstracts.ProductService;
import com.teknopar.northwindDeneme.utilities.results.DataResult;
import com.teknopar.northwindDeneme.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @GetMapping("/getall")
    public DataResult<List<Product>> getALl(){
        return this.productService.getALl();
    }

    @GetMapping("/getALlDesc")
    public DataResult<List<Product>> getALlSorted(){
        return this.productService.getALlSorted();
    }

    @GetMapping("/getALlByPage")
    public DataResult<List<Product>> getALl(int pageNo, int pageSize){
        return this.productService.getALl(pageNo,pageSize);
    }

    @PostMapping("/add")
    public Result add(Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategory_CategoryId")
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId){
        return this.productService.getByProductNameAndCategory_CategoryId(productName,categoryId);
    }
    @GetMapping("/getByProductNameOrCategory_CategoryId")
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId){
        return this.productService.getByProductNameOrCategory_CategoryId(productName,categoryId);
    }

    @GetMapping("/getByCategoryIdIn")
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories){
        return this.productService.getByCategoryIdIn(categories);
    }
    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(String productName){
        return this.productService.getByProductNameContains(productName);
    }
    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(String productName){
        return this.productService.getByProductNameStartsWith(productName);
    }
    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId){
        return this.productService.getByNameAndCategory(productName,categoryId);
    }
}
