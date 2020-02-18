package com.projects.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.springboot.app.entity.Family;

public interface FamilyRepository extends JpaRepository<Family, Long> {

}
