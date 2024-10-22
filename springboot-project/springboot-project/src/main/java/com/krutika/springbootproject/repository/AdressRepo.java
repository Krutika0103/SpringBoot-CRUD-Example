package com.krutika.springbootproject.repository;

import com.krutika.springbootproject.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdressRepo extends JpaRepository<Adress , Long> {
    List<Adress> findAllByAddressId(Long addressId);
}
