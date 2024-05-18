package com.f1data.f1data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f1data.f1data.entity.CarreraEntity;

@Repository
public interface CarreraRepository extends JpaRepository<CarreraEntity, Long> {

    Page<CarreraEntity> findByNumVueltas(int num_vueltas, Pageable pageable);

}
