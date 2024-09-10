package com.academy.sivillageclonebe.option.repository;

import com.academy.sivillageclonebe.option.entity.ProductStocks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductStocksRepository extends JpaRepository<ProductStocks, Long> {

}
