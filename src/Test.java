import java.util.Arrays;
import java.util.List;

/**
 * User
 */
class User {    
    private String userid;
    private String name;
    private int age;
    private String email;
    private String password;
    private Long contact;
    private String address;

    public User(String userid, String name, int age, String email, String password, Long contact, String address)
    {
        this.userid = userid;
        this.name = name;
        this.age = age;
        this.email = email;
        this.contact = contact;
        this.address = address;
    }

    public String getUserId(){
        return userid;
    }

    public void setUserId(String userid){
        this.userid = userid;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setName(int age){
        this.age = age;
    }
    
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Long getContact(){
        return contact;
    }

    public void setContact(Long contact){
        this.contact = contact;
    }
    

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }
}

public class Test {
    public static void main(String[] args) {

        List<User> users = Arrays.asList(
          new User("user1", "Niranjan Kumar", 30, "niranjan@gmail.com", "1234", 9930654578L, "Ratu Road"),
          new User("user2", "Sandeep Kumar Mahato", 29, "sandeep@gmail.com", "1234", 9930654554L, "Harmau Road"),
          new User("user3", "Gautam Kumar", 30, "gautam@gmail.com", "1234", 9930654532L, "Harmau Road"),
          new User("user4", "Pooja Kumari", 30, "pooja@gmail.com", "1234", 99306545987L, "Buti More"),
          new User("user5", "Krishan Mahato", 31, "krishna@gmail.com", "1234", 9930654500L, "Ratu Road"),
          new User("user6", "Laxmi Kumari", 28, "laxmi@gmail.com", "12345", 9930654511L, "Sahajand Chowk")
        );

        // List<User> user = users.stream().
    }
}
