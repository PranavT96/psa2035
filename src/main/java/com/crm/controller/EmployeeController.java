package com.crm.controller;

import com.crm.payload.EmployeeDto;
import com.crm.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/api/v1/employee
@RestController //We have not used controller here, because we are calling this URL through an API.
@RequestMapping("/api/v1/employee")

public class EmployeeController {

    //Create constructor rather than using @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //create method to add employee
    @PostMapping("/add")
    //http://localhost:8080/api/v1/employee/add
    //We have used ResponseEntity to return the status code as 201(created).
    public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeDto dto, BindingResult result){//@RequestBody copies the JSON content into Java object / Entity/Dto object.(Here Dto object is used)

        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        EmployeeDto employeeDto = employeeService.addEmployee(dto);//controller send the Entity object to the service layer, service layer will take the data with the help of repository saves that into the database.
       // return new ResponseEntity<>("saved", HttpStatus.CREATED);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/v1/employee?id=1 query parameters
    @DeleteMapping
   public ResponseEntity<String> deleteEmployee(@RequestParam Long id){//To read query parameters we use @RequestParam, the url id must match with Long id.
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);//status code = 200

   }
   @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestParam Long id, @RequestBody EmployeeDto dto){
        //The @RequestBody annotation extracts the request body and maps it to the EmployeeDto class fields.
        //Reads the JSON payload from the request body.
       //Converts the JSON into an EmployeeDto object.
       //Makes the updated data easily accessible in the method via the dto object.
       //Keeps the API and database structure decoupled by using a DTO instead of the entity directly.

       EmployeeDto employeeDto = employeeService.updateEmployee(id, dto);
       return new ResponseEntity<>(employeeDto, HttpStatus.OK);

    }

    //http://localhost:8080/api/v1/employee?pageSize=3&pageNo=1&sortBy=emailId&sortDir=desc
    @GetMapping
    public ResponseEntity<List<EmployeeDto> >getEmployee(//Pagination and sorting
            @RequestParam (name="pageSize",required=false,defaultValue="5")int pageSize,
            @RequestParam (name="pageNo",required=false,defaultValue="0")int pageNo,
            @RequestParam (name="sortBy",required=false,defaultValue="name")String sortBy,
            @RequestParam (name="sortDir",required=false,defaultValue="asc")String sortDir
    )
    {
        List<EmployeeDto> employeesDto=employeeService.getEmployee(pageNo, pageSize, sortBy, sortDir);

        return new ResponseEntity<>(employeesDto,HttpStatus.OK);
    }

//    http://localhost:8080/api/v1/employee/employeesId/1
    @GetMapping("/employeesId/{empId}")
    public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable long empId){
        EmployeeDto employeesDto=employeeService.getEmployeeById(empId);

        return new ResponseEntity<>(employeesDto, HttpStatus.OK);
    }


}
