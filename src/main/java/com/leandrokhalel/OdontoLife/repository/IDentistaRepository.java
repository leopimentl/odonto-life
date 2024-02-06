package com.leandrokhalel.OdontoLife.repository;

import com.leandrokhalel.OdontoLife.model.Dentista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDentistaRepository extends JpaRepository<Dentista, Long> {

    Page<Dentista> findAllByAtivoTrue(Pageable pageable);
}
