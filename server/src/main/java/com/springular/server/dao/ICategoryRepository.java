package com.springular.server.dao;

import com.springular.server.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "category", path="category")
public interface ICategoryRepository extends JpaRepository<Category, UUID> {
}
