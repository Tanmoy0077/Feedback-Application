package com.firstapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstapp.model.Department;
import com.firstapp.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository repository;
	
	@Override
	public List<Department> getAllDepartment(){
		return repository.findAll();
	}
	@SuppressWarnings("null")
	@Override
	public boolean saveDept(Department d) {
		try {
			repository.save(d);
			return true;
			}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean deleteDept(long id){
		repository.deleteById(id);

		return true;
	}
	@Override
	public Department findById(long id){
		Optional<Department> opt = repository.findById(id);
		Department d = opt.get();
		return d;
	}
}
