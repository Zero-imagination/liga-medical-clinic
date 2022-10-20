package liga.medical.medicalmonitoring.core.antisolid;

public class AntiS {
    public void readUser(){
        getConnectionDB();
        System.out.println("User has been successfully created");
    }
    public void getConnectionDB(){
        System.out.println("Data base connection");
    }
    public void addProductUserCart(){
        readUser();
        System.out.println("User cart updated");
    }
}
