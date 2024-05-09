package com.firstapp.service;
import java.util.List;
import com.firstapp.model.Department;
/* We need an interface that would contain abstract method for example DepartmentService which returns
 * data in form of list of type Department. since it is an interface we need to inherit through DepartmentServiceImpl which
 * is associated with @Service annotation. */
public interface DepartmentService {
	List<Department> getAllDepartment();
	public boolean saveDept(Department d);
	public boolean deleteDept(long id);
	public Department findById(long id);
}
