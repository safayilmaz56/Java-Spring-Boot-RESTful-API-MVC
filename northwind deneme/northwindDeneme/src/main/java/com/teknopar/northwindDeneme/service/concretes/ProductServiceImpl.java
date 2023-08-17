package com.teknopar.northwindDeneme.service.concretes;

import com.teknopar.northwindDeneme.model.Product;
import com.teknopar.northwindDeneme.repository.ProductRepository;
import com.teknopar.northwindDeneme.service.abstracts.ProductService;
import com.teknopar.northwindDeneme.utilities.results.DataResult;
import com.teknopar.northwindDeneme.utilities.results.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public DataResult<List<Product>> getALl() {
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll());
    }

    @Override
    public DataResult<List<Product>> getALlSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll(sort));
    }

    @Override
    public DataResult<List<Product>> getALl(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll(pageable).getContent());
    }

    @Override
    public Result add(Product product) {
        this.productRepository.save(product);
        return new SuccessResult("Ürün Eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productRepository.getByProductName(productName),"Data listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productRepository.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByProductNameOrCategory_CategoryId(productName,categoryId));
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByCategoryIn(categories),"Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByProductNameContains(productName),"Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByProductNameStartsWith(productName),"Data Listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productRepository.getByNameAndCategory(productName,categoryId),"Data Listelendi");
    }
}
