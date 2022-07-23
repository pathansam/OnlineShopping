package com.app.service;

import java.util.List;

import com.app.dto.EmployeeDTO;
import com.app.entities.Employee;

public interface IEmployeeService {
//get all emps
	List<EmployeeDTO> getAllEmpDetails();
	//save new emp details
	EmployeeDTO saveEmpDetails(EmployeeDTO emp);
	//delete emp details
	String deleteEmpDetails(int empId);
	//get emp details by specified id
	EmployeeDTO getEmpDetails(int empId);
	//update existing emp details
	EmployeeDTO  updateEmpDetails(EmployeeDTO updatedDetachedEmp);
	List<EmployeeDTO> getEmpByGreaterSalary(double salary);
	List<EmployeeDTO> getEmpsByDepartmentAndWorkLocation(String dept,String loc);
	int updateEmpSalaryByDepartment(double salIncr,String dept);
}
