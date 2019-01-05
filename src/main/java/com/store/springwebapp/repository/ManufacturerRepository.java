package com.store.springwebapp.repository;

import com.store.springwebapp.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
    @Query("FROM Manufacturer WHERE name = :name")
    Manufacturer findByName(@Param("name") String name);
}
