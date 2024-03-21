package com.example.department.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.department.entity.Department;
import com.example.department.repo.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepo depatRepo;

	@Override
	public List<Department> getAllDepartments() {
		return depatRepo.findAll();
	}

	@Override
	public Department getDepartmentById(Long id) {
		return depatRepo.findById(id).orElse(null);
	}

	@Override
	public Department createDepartment(Department department) {
		return depatRepo.save(department);
	}

	@Override
	public Department updateDepartment(Long id, Department department) {
		Optional<Department> optionalDepartment = depatRepo.findById(id);
		if(optionalDepartment.isPresent()) {
			Department existingDepartment = optionalDepartment.get();
			existingDepartment.setDeptId(department.getDeptId());
			existingDepartment.setDeptName(department.getDeptName());
			existingDepartment.setDeptCode(department.getDeptCode());
			existingDepartment.setDeptAddress(department.getDeptAddress());
			return depatRepo.save(existingDepartment);
			
		}
		return null;
	}

	@Override
	public void deleteDepartment(Long id) {
		depatRepo.deleteById(id);
		
	}

	
}
