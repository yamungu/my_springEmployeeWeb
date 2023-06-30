package Employee.example.website.Services;

import Employee.example.website.Model.Manager;
import Employee.example.website.Repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ManagerServices {

    @Autowired
    private ManagerRepo managerRepo;

    public List<Manager> getAll() {return managerRepo.findAll();}

    public Manager getManagerById(int id){return managerRepo.findById(id).orElse(null);}

    public void create(Manager manager){ managerRepo.save(manager); }

    public void updateManager(Integer id, Manager manager){
        Manager existingManager = managerRepo.findById(id).orElse(null);
        if (existingManager !=null){
            existingManager.setFirstName(manager.getFirstName());
            existingManager.setLastName(manager.getLastName());
            managerRepo.save(existingManager);
        }
    }
    public void delete(Integer id){managerRepo.deleteById(id);}

}





