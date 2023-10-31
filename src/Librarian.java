
public class Librarian extends User  {
    String employeeId;
    Librarian(){
        employeeId ="";
    }

    Librarian(String Id, String name){
        super(name);
        employeeId = Id;
    }

    public String getEmployeeId() {
        return employeeId;
    }
    public void printInfo(){
        super.printInfo();
        System.out.println("Employee Id: "+this.employeeId);
    }
}