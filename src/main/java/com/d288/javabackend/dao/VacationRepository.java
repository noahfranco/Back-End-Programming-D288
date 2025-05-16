package com.d288.javabackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.d288.javabackend.entities.Vacation;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface VacationRepository extends JpaRepository<Vacation, Long> {

}
