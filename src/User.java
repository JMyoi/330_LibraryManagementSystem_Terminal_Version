public class User {
    private String name;
    private String password;

    public User() {
        name = "";
        password = "";
    }

    public User(String name, String pass) {
        this.name = name;
        this.password = pass;
    }

    public String getName() {
        return name;
    }
    public boolean authenticate(String pass){
        return password.equals(pass);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void printInfo(){
        System.out.println("Name: "+this.name);
    }

}