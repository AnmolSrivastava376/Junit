package assignment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import authPackage.*;

public class RegisterCheck {
    private static AuthSystem authSystem;

    @BeforeAll
    public static void setUp() {
        authSystem = new AuthSystem();
        authSystem.registerUser(new User("user1", "user1@example.com", "password123"));
        authSystem.registerUser(new User("user2", "user2@example.com", "test123"));
    }
    @Test
    public void testRegisterSuccessful() {
        assertEquals(0, authSystem.registerUser(new User("user3","user3@example.com","pass123")));
    }
    @Test
    public void testRegisterEmailExists() {
    	assertEquals(2, authSystem.registerUser(new User("user3","user2@example.com","pass123")));
    }
    @Test
    public void testInvalidEmail() {
    	assertEquals(1, authSystem.registerUser(new User("user3","user3example.com","pass123")));
    }
    @Test
    public void testPasswordSuccessful() {
        assertEquals(3, authSystem.registerUser(new User("user4","user4@example.com","p123")));
    }
}
