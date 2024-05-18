package com.f1data.f1data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f1data.f1data.entity.TrazadoEntity;

@Repository
public interface TrazadoRepository extends JpaRepository<TrazadoEntity, Long> {

    Page<TrazadoEntity> findByNumMetros(int num_metros, Pageable pageable);

}
