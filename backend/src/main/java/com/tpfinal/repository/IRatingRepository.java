package com.tpfinal.repository;

import com.tpfinal.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by joni on 07/07/16.
 */
public interface IRatingRepository extends JpaRepository<Rating, Long> {
}
