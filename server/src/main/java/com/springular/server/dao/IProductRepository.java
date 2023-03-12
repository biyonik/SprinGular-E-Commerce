package com.springular.server.dao;

import com.springular.server.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "product", path="product")
public interface IProductRepository extends JpaRepository<Product, UUID> {
}
