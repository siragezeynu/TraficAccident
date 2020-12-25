package com.restapi1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi1.demo.model.Moterist;

public interface MoteristRepository extends JpaRepository<Moterist, Long> {

}
