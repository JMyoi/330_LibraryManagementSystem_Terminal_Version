import java.util.UUID;
public class Librarian extends User  {
    UUID employeeId;
    Librarian(){
        employeeId = UUID.randomUUID();
    }

    Librarian( String name, String pass){
        super(name, pass);
        employeeId = UUID.randomUUID();
    }

    public UUID getId() {
        return employeeId;
    }
    public void printInfo(){
        super.printInfo();
        System.out.println("Employee Id: "+this.employeeId);
    }
}

