package Service;

import modelDao.Persondao;
import model.person;


import java.util.List;

public class PersonService {
    private Persondao persondao;
    public PersonService(Persondao persondao){
        this.persondao=persondao;
    }
    public List<person> getallPerson(){
        return persondao.getAllperson();
    }
    public void addPerson(person person){
        persondao.addperson(person);
    }
    public void updatePerson(int id, person person){
        persondao.updateperson(id,person);
    }
    public void deletePerson(int id){
        persondao.deletePerson(id);
    }
}
