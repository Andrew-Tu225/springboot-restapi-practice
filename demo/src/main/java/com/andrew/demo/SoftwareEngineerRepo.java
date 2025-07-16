package com.andrew.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftwareEngineerRepo extends JpaRepository<SoftwareEngineer, Integer> {
}
