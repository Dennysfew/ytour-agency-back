package com.lab.ytour.tour;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    @Query("SELECT t from Tour t WHERE t.description = ?1")
    Optional<Tour> findTourByDescription(String description);

}
