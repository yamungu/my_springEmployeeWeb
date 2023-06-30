package Employee.example.website.Services;

import Employee.example.website.Model.Employee;
import Employee.example.website.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAll() {return employeeRepo.findAll();}

    public Employee getEmployeeById(int id){return employeeRepo.findById(id).orElse(null);}

    public void create(Employee employee){ employeeRepo.save(employee); }

    public void updateEmployee(Integer id, Employee employee){
        Employee existingEmployee = employeeRepo.findById(id).orElse(null);

        if (existingEmployee !=null){
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPhone(employee.getPhone());
            employeeRepo.save(existingEmployee);
        }
    }
    public void delete(Integer id){employeeRepo.deleteById(id);}

}


