package Service;

import model.Doctor;
import modelDao.Doctordao;

import java.util.List;

public class DoctorService {
    private Doctordao doctordao;
    public DoctorService(Doctordao doctordao){
        this.doctordao=doctordao;
    }
    public List<Doctor> getallDoctor(){
        return doctordao.getAllDoctor();
    }
    public void addDoctor(Doctor doctor){
        doctordao.addDoctor(doctor);
    }
    public void updateDoctor(int D_id, Doctor doctor){
        doctordao.updateprson(D_id,doctor);
    }
    public  void deleteDoctor(int D_id){
        doctordao.deleteDoctor(D_id);
    }

}
