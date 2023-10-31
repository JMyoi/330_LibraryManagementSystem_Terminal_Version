
public class Librarian extends User  {
    int employeeId;
    Librarian(){
        employeeId =0;
    }

    Librarian(int Id){
        employeeId = Id;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}