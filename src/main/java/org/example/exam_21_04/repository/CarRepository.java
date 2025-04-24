package org.example.exam_21_04.repository;

import org.example.exam_21_04.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    List<Car> findByYearGreaterThanEqual(int year);
    List<Car> findByPriceBetween(double min, double max);
    List<Car> findByYearGreaterThanEqualAndPriceBetween(int year, double min, double max);
}
