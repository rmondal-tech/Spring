package com.java.spring.dta.jpa.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.java.spring.dta.jpa.entity.Person;


public interface  PersonDaoOrRepo extends JpaRepository<Person, Integer>{

	Person findByPname(String pname);//Query DSL //created method with naming convention

//   @Query("select * from Person where panme= :panme")
//	List<Person> FindByQuery(@Param("name") String pname);
}
