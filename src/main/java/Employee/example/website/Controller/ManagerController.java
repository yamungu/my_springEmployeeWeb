package Employee.example.website.Controller;

//import Employee.example.website.Model.Employee;
import Employee.example.website.Model.Manager;
import Employee.example.website.Services.EmployeeServices;
import Employee.example.website.Services.ManagerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@RestController
@RequestMapping("/api/v1/Manager")
public class ManagerController {
    @Autowired
    private ManagerServices managerServices;

    @GetMapping("/all")
    public List<Manager> getAll(){
        return managerServices.getAll();}

    @GetMapping("/{id}")
    public Manager getManagerById(@PathVariable Integer id){return managerServices.getManagerById(id);
    }

    @PostMapping("/save")
    public void create(@RequestBody Manager manager){
        managerServices.create(manager);
    }

    @PutMapping("/{id}")
    public void updateManager(@PathVariable Integer id,@RequestBody Manager manager){
        managerServices.updateManager(id,manager);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){managerServices.delete(id);}






}



