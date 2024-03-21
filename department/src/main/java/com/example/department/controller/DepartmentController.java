package com.example.department.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.department.entity.Department;
import com.example.department.services.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/Departments")
	public List<Department> getAllDepartments(){
		return deptService.getAllDepartments();

}
	@GetMapping("/dept/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		return deptService.getDepartmentById(id);
	}
	@PostMapping
	public Department createDepartment(@RequestBody Department department) {
		return deptService.createDepartment(department);
	}
	@PutMapping("/{id}")
	public Department updateDepartment(@PathVariable Long id,@RequestBody Department updatedDepartment) {
		return deptService.updateDepartment(id,updatedDepartment);
	}
	@DeleteMapping("/{id}")
	public void deleteDepartment(@PathVariable Long id) {
		deptService.deleteDepartment(id);
	}
}
