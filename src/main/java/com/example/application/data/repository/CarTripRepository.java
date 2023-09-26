package com.example.application.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.application.data.entity.CarTrip;

@Repository
public interface CarTripRepository extends JpaRepository<CarTrip, Long> {
    
}
