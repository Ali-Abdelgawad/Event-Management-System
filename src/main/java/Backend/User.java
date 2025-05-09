
package Backend;
import java.time.LocalDate;

public abstract class User {
    protected String username;
    protected String password;
    protected LocalDate dateOfBirth;

    public User(String username, String password, LocalDate dateOfBirth) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    

    public String getUsername() {
        return username;
    }

    public boolean login(String user, String pass) {
        return this.username.equals(user) && this.password.equals(pass);
    }
}
