package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.EmployeeRepository;
import com.app.dto.EmployeeDTO;
import com.app.entities.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	// dep : emp repo.
	@Autowired
	private EmployeeRepository empRepo;
	// dep : model mapper for mapping dto --- entity
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<EmployeeDTO> getAllEmpDetails() {
		// TODO Auto-generated method stub
		List<Employee> list = empRepo.findAll();
		List<EmployeeDTO> temp = new ArrayList<>();
		list.forEach(e->temp.add(mapper.map(e, EmployeeDTO.class)));
		return temp;
//		return list.forEach(e-> mapper.map(e, EmployeeDTO.class));
	}

	@Override
	public EmployeeDTO saveEmpDetails(EmployeeDTO empDto) {
		// map dto --> entity
		Employee employee = mapper.map(empDto, Employee.class);
		//persist emp details in the db
		Employee persistentEmp = empRepo.save(employee);// method rets PERSISTENT emp ref
		// map entity --> dto
		return mapper.map(persistentEmp, EmployeeDTO.class);
	}// in case of no errs : hib auto dirty chking @ session.flush ---tx.commit
		// --inserts rec --L1 cache destroyed -- pooled out db cn rets to the pool
		// --rets DETACHED pojo to the caller

	@Override
	public String deleteEmpDetails(int empId) {
		String mesg = "Deletion of emp details failed!!!!!!!!!!!";

		if (empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
			mesg = "Emp details deleted successfully , for emp id :" + empId;
		}

		return mesg;
	}

	@Override
	public EmployeeDTO getEmpDetails(int empId) {
		// TODO Auto-generated method stub
		Employee employee = empRepo.getById(empId);
		employee.getJoinDate();
		return mapper.map(employee, EmployeeDTO.class);
		// .orElseThrow(() -> new ResourceNotFoundException("Invalid emp id !!!!!!" +
		// empId));
	}

	@Override
	public EmployeeDTO updateEmpDetails(EmployeeDTO updatedDetachedEmp) {
		// TODO Auto-generated method stub
		Employee emp = mapper.map(updatedDetachedEmp, Employee.class);
//		 Optional<Employee> e = empRepo.findById(emp.getEmpId());
//		   emp.setImagePath(e.get().getImagePath());
		Employee temp = empRepo.save(emp);
		
		return mapper.map(temp, EmployeeDTO.class);
	}
	
	
	@Override
	public List<EmployeeDTO> getEmpByGreaterSalary(double salary) {
		List<Employee> list = empRepo.findBySalaryGreaterThan(salary);
		List<EmployeeDTO> temp = new ArrayList<>();
		list.forEach(e-> temp.add(mapper.map(e, EmployeeDTO.class)));
		return temp;
	}

	@Override
	public List<EmployeeDTO> getEmpsByDepartmentAndWorkLocation(String dept, String loc) {
		List<Employee> list = empRepo.findByDepartmentAndWorkLocation(dept, loc);
		List<EmployeeDTO> temp = new ArrayList<>();
		list.forEach(e-> temp.add(mapper.map(e, EmployeeDTO.class)));
		return temp;
	}

	@Override
	public int updateEmpSalaryByDepartment(double salIncr, String dept) {
		return empRepo.updateEmpSalaryByDept(salIncr, dept);
		
	}

}
