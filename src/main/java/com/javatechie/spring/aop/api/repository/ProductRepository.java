package com.javatechie.spring.aop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.spring.aop.api.model.Product;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
