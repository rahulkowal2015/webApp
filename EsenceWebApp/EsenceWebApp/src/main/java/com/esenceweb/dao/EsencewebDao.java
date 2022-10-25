package com.esenceweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esenceweb.model.Esenceweb;
@Repository
public interface EsencewebDao extends JpaRepository<Esenceweb, Long> {

}
