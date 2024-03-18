package assignment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import authPackage.*;

public class ForgotPass {
    private static AuthSystem authSystem;

    @BeforeAll
    public static void setUp() {
        authSystem = new AuthSystem();
        authSystem.registerUser(new User("user1", "user1@example.com", "password123"));
        authSystem.registerUser(new User("user2", "user2@example.com", "test123"));
    }
    @Test
    public void testForgotPassValidEmail() {
        assertEquals(0, authSystem.ForgotPassword("user1@example.com","newpass123"));
    }
    @Test
    public void testForgotPassInvalidEmail() {
        assertEquals(2, authSystem.ForgotPassword("user10@example.com","newpass123"));
    }
    @Test
    public void testForgotPassInvalidPassword() {
        assertEquals(1, authSystem.ForgotPassword("user1@example.com","123"));
    }
    @Test
    public void testForgotPassNullPassword() {
        assertEquals(1, authSystem.ForgotPassword("user1@example.com",""));
    }
    @Test
    public void testForgotPassNullEmail() {
        assertEquals(2, authSystem.ForgotPassword("","pass123"));
    }

}
