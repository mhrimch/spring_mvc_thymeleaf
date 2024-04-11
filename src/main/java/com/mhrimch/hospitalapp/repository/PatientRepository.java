package com.mhrimch.hospitalapp.repository;

import com.mhrimch.hospitalapp.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByFirstNameContainsIgnoreCaseOrLastNameContainsIgnoreCase(String firstname, String lastname, Pageable pageable);
}
