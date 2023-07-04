package Employee.example.website.Controller;

import Employee.example.website.Model.Employee;
import Employee.example.website.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@ComponentScan
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping
    public List<Employee>getAll(){
        return employeeServices.getAll();}

    @GetMapping("/{id}")
    public Employee getCustomerById(@PathVariable Integer id){
        return employeeServices.getEmployeeById(id);
    }

    @PostMapping
    public void create(@RequestBody Employee employee){
        employeeServices.create(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Integer id,@RequestBody Employee employee){
        employeeServices.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){employeeServices.delete(id);}

}


