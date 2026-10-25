package com.portfolio.esg_tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EsgRepository extends JpaRepository<EsgEntity, Long> {
    List<EsgEntity> findByTicker(String ticker);
}