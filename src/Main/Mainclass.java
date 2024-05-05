package Main;

import Service.DoctorService;
import Service.PersonService;
import model.Doctor;
import modelDao.Doctordao;
import modelDao.Persondao;
import model .person;

import java.util.List;
import java.util.Scanner;

public class Mainclass {
    public static Scanner sc= new Scanner(System.in);
    public static PersonService personService;
    public static DoctorService doctorService;

    public static void main(String[] args){
        Persondao persondao=new Persondao();
        Doctordao doctordao=new Doctordao();
        personService=new PersonService(persondao);
        doctorService=new DoctorService(doctordao);
        while (true){
            System.out.println("1 , view all person");
            System.out.println("2 , view all Doctor");
            System.out.println("3 , add new person");
            System.out.println("4 , add new Doctor");
            System.out.println("5 , update person");
            System.out.println("6 , update Doctor");
            System.out.println("7 , delete person");
            System.out.println("8 , delete Doctor");
            System.out.println("9 , exit");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    viewAllperson();
                    break;
                case 2:
                    viewAllDoctor();
                    break;
                case 3:
                    addPerson();
                    break;
                case 4:
                    addDoctor();
                    break;
                case 5:
                    updatePerson();
                    break;
                case 6:
                    updateDoctor();
                    break;
                case 7:
                    deletePerson();
                    break;
                case 8:
                    deleteDoctor();
                    break;
                case 9:
                    System.out.println("Exiting the program");
                    System.exit(4);
                default:
                    System.out.println("plese enter valid number");

            }
        }
    }
    public static void viewAllperson(){
        List<person> p=personService.getallPerson();
        System.out.println("person List");
        for (person pp: p){
            System.out.println(pp);
        }
    }
    public static void viewAllDoctor(){
        List<Doctor> p=doctorService.getallDoctor();
        System.out.println("Doctor List");
        for (Doctor pp: p){
            System.out.println(pp);
        }
    }
    private static void  addPerson(){
        System.out.println("Enter id");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name");
        String name=sc.nextLine();
        System.out.println("Enter email");
        String email= sc.nextLine();
        System.out.println(" Enter Designation");
        String designation= sc.nextLine();
        System.out.println("Enter Address");
        String address= sc.nextLine();
        System.out.println("Enter total bill if exist");
        int bill= sc.nextInt();
        person pp=new
                person(id,name, email,designation,address,bill);
        personService.addPerson(pp);
    }
    private static void addDoctor(){
        System.out.println("Enter id");
        int D_id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name");
        String name=sc.nextLine();
        System.out.println("Enter email");
        String email=sc.nextLine();
        System.out.println("Enter Designation");
        String designation=sc.nextLine();
        System.out.println("Enter patient Id(pid)");
        int pid=sc.nextInt();
        Doctor pp=new Doctor(D_id,name,email,designation,pid);
        doctorService.addDoctor(pp);
    }
    private static void updatePerson(){
        System.out.println("Enter id");
        int id= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name");
        String name=sc.nextLine();
        System.out.println("Enter email");
        String email=sc.nextLine();
        System.out.println("Enter Designation");
        String designation= sc.nextLine();
        System.out.println("Enter Address");
        String address= sc.nextLine();
        System.out.println("Enter total bill if exist");
        int bill = sc.nextInt();
        System.out.println("Enter salary");

        person pp=new
                person(id,name,email,designation,address,bill);
        personService.updatePerson(id,pp);
    }
    private static void updateDoctor(){
        System.out.println("Enter D_id");
        int D_id= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter email");
        String email = sc.nextLine();
        System.out.println("Enter Designation");
        String designation = sc.nextLine();
        System.out.println("Enter patient id(pid)");
        int pid = sc.nextInt();

        Doctor pp=new
                Doctor(D_id,name,email,designation,pid);
        doctorService.updateDoctor(D_id,pp);
    }
    private static void deletePerson(){
        System.out.println("Enter id of the person to delete");
        int id = sc.nextInt();
        personService.deletePerson(id);
        System.out.println("person is deleted successfully");
    }
    private static void deleteDoctor(){
        System.out.println("Enter D_id of the doctor to delete");
        int D_id= sc.nextInt();
        personService.deletePerson(D_id);
        System.out.println("Doctor is deleted successfully");
    }
}
