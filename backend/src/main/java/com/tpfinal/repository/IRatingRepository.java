package com.tpfinal.repository;

import com.tpfinal.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRatingRepository extends JpaRepository<Rating, Long> {
    public Rating save(Rating rating);
}
