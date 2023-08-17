package com.teknopar.northwindDeneme.service.abstracts;

import com.teknopar.northwindDeneme.model.Product;
import com.teknopar.northwindDeneme.utilities.results.DataResult;
import com.teknopar.northwindDeneme.utilities.results.Result;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {

    DataResult<List<Product>> getALl();
    DataResult<List<Product>> getALlSorted();
    DataResult<List<Product>> getALl(int pageNo,int pageSize);
    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName,int categoryId);

    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);


    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
   // DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
