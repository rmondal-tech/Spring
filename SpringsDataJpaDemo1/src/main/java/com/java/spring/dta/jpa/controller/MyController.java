package com.java.spring.dta.jpa.controller;

import java.util.ArrayList;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.spring.dta.jpa.dao.PersonDaoOrRepo;
import com.java.spring.dta.jpa.entity.Person;



@Controller
public class MyController {
	static List<Person> personsList=new ArrayList<>();
	
	@Autowired
	private PersonDaoOrRepo personDaoOrRepo;

	@PostMapping("addPerson")
	 public String addPerson(Person p , Model m) //by default use @ModelAttribute for Person
		{
		Person savedEntity = personDaoOrRepo.save(p);
		//personsList.add(p);
		if(savedEntity!=null) {
			m.addAttribute("useMeInJsp",savedEntity);
		}
			return "result";
//we are  storing into any temporary list
		}
	
	
	@GetMapping("getPerson")
	 public String showPerson(Model m)
		{
//fetch all persons from  table		
		personsList=personDaoOrRepo.findAll();// List<Person>  from table
		
			m.addAttribute("personFromDB",personsList);//same needs to be retrieved in jsp
			return "result";
		}	
	
//	get Details by Id
	
	@GetMapping("getDetailsOfOnePerson")
	 public String showDetailsOfOnePerson(@RequestParam int pid, Model m)
		{
//fetch all persons from  table		
		Person onePersonDetails = personDaoOrRepo.getOne(pid);// <Person>  from table
		
			m.addAttribute("personFromDB",onePersonDetails);
			return "result";
		}	
	

//	get Details by other than ID
	
	@GetMapping("getDetailsByName")
	 public String showDetailsByName(@RequestParam String pname, Model m)
		{
//fetch all persons from  table		
		//Person onePersonDetails = personDaoOrRepo.findById(null);// List<Person>  from table
		
		Person onePersonDetails = personDaoOrRepo.findByPname(pname);// List<Person>  from table
	
			m.addAttribute("personFromDB",onePersonDetails);
			return "result";
		}
	
}