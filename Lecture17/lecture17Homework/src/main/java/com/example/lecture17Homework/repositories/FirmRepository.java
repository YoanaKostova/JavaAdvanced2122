package com.example.lecture17Homework.repositories;

import com.example.lecture17Homework.models.Firm;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirmRepository extends CrudRepository<Firm, Long> {

    List<Firm> findByName(String name);

    @Modifying
    @Query("UPDATE Firm SET city = :city WHERE id = :id")
    void changeCity( Long id, String city);

    @Modifying
    @Query("UPDATE Firm SET employees = :employees WHERE id = :id")
    void changeEmployees( Long id, int employees);
}
