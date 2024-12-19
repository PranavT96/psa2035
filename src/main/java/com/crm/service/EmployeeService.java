package com.crm.service;

import com.crm.entity.Employee;
import com.crm.exception.ResourceNotFound;
import com.crm.payload.EmployeeDto;
import com.crm.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class EmployeeService {


    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper; //First we need to create the modelMapper method in crmApplication/Configuration class, then only we can create the object of modelMapper.

    //Use Constructor based dependency injection, rather than using @Autowired on it.
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    //create add Employee method for Employee entity/dto
    public EmployeeDto addEmployee(EmployeeDto dto) {

        // Implement logic to save employee to database
        Employee employee= mapToEntity(dto); //Converts Dto to entity to save in Database.

        Employee emp = employeeRepository.save(employee); //Saves entity in database
        EmployeeDto employeeDto = mapToDto(emp);//Converts entity to Dto, to return saved content to controller.

       // employeeDto.setDate(new Date());//This is not a column in the database it just returns the date information.
        return employeeDto; //This returns the saved content to the controller.

    }


    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    //public void updateEmployee(Long id, EmployeeDto dto){
       // Optional<Employee> opEmp = employeeRepository.findById(id);
       // Employee employee = opEmp.get();//Actual data coming from database.

        //this is the data that need to be updated
        //employee.setName(dto.getName());
        //employee.setEmailId(dto.getEmailId());
        //employee.setMobile(dto.getMobile());
        //employeeRepository.save(employee);

  //  }
    
    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
        Employee employee = mapToEntity(dto);
        employee.setId(id); //The id is the primary key of the Employee entity and uniquely identifies the record in the database.
        //Even though the id is not set via mapToEntity or mapToDto, it is explicitly set in the updateEmployee method:
        //employee.setId(id);
        //This ensures that the Employee entity receives the correct id from the method parameter, overriding any missing or null values that would have been set during mapping.

        Employee updateEmployee = employeeRepository.save(employee);
        EmployeeDto employeeDto = mapToDto(updateEmployee);

        //employeeDto.setDate(new Date());
        return employeeDto;

    }
    
    

    public List<EmployeeDto> getEmployee(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort=sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

        Pageable page = PageRequest.of(pageNo, pageSize, sort);

        //using Stream Api
        Page<Employee> all=employeeRepository.findAll(page);//Its return type is Page<Employee> of Employees and not list of Employees
        //We need to convert this page content into a List<Employee>
        List<Employee> employees = all.getContent();
        List<EmployeeDto> dto=employees.stream().map(e->mapToDto(e)).collect(Collectors.toList());

        return dto;
    }

    public EmployeeDto getEmployeeById(long empId) {

        Employee employee = employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFound("record not found with id: " + empId));//used supplier () concept.

        EmployeeDto dto = mapToDto(employee);
        return dto;
    }

 EmployeeDto mapToDto(Employee employee){//This method converts entity to dto object.
//        EmployeeDto dto = new EmployeeDto();
//       dto.setId(employee.getId());
//        dto.setName(employee.getName());
//        dto.setEmailId(employee.getEmailId());
//        dto.setMobile(employee.getMobile());
     EmployeeDto dto = modelMapper.map(employee, EmployeeDto.class); //Using ModelMapper streamlines the conversion of objects like Employee to EmployeeDto by automating the mapping process.
     //You should use ModelMapper when your objects have similar structures, field names match, and you want to minimize boilerplate code.
     return dto;
    }

    Employee mapToEntity(EmployeeDto dto){//This method converts dto to entity.
//        Employee emp = new Employee();
//        emp.setId(dto.getId());
//        emp.setName(dto.getName());
//        emp.setEmailId(dto.getEmailId());
//        emp.setMobile(dto.getMobile());
        Employee emp = modelMapper.map(dto, Employee.class);
        return emp;
    }


}
