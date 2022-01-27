package com.flamexander.cloud.service.product;
// часть МС, для того, чтобы достать продукты из базы
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
