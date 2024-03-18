package assignment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import authPackage.*;

public class LoginCheck {

    private static AuthSystem authSystem;

    @BeforeAll
    public static void setUp() {
        authSystem = new AuthSystem();
        authSystem.registerUser(new User("user1", "user1@example.com", "password123"));
        authSystem.registerUser(new User("user2", "user2@example.com", "test123"));
    }

    @Test
    public void testLoginSuccessful() {
        assertEquals(0, authSystem.Login("user1@example.com", "password123"));
    }

    @Test
    public void testIncorrectPassword() {
        assertEquals(1, authSystem.Login("user1@example.com", "wrongpassword"));
    }

    @Test
    public void testNoSuchUser() {
        assertEquals(2, authSystem.Login("nonexistent@example.com", "password123"));
    }
}
