package com.greatlearning.lab5.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.lab5.entity.Student;
import com.greatlearning.lab5.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list") 
	public String listStudents(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "student-list";
	}

	@RequestMapping("/new")
	public String showFormForAdd(Model model) {
		Student student = new Student();

		model.addAttribute("newStudent", true);
		model.addAttribute("student", student);

		return "student-detail";
	}

	@RequestMapping("/edit")
	public String showFormForEdit(@RequestParam("id") int id, Model model) {
		Student student = studentService.findById(id);

		model.addAttribute("newStudent", false);
		model.addAttribute("student", student);

		return "student-detail";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		Student student = null;

		if (id == 0) {
			student = new Student(name, department, country);
		} else {
			student = studentService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		}
		studentService.save(student);

		return "redirect:/students/list";
	}

	@RequestMapping("/delete")
	public String showFormForDelete(@RequestParam("id") int id) {
		studentService.deleteById(id);

		return "redirect:/students/list";
	}
}
