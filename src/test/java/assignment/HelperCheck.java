package assignment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import authPackage.*;

public class HelperCheck {
    private static AuthSystem authSystem;

    @BeforeAll
    public static void setUp() {
        authSystem = new AuthSystem();
        authSystem.registerUser(new User("user1", "user1@example.com", "password123"));
        authSystem.registerUser(new User("user2", "user2@example.com", "test123"));
    }
    @Test
    public void checkValidEMail() {
        assertEquals(true, authSystem.isValidEmail("user1@example.com"));
        assertEquals(true, authSystem.isValidEmail("anmol@gmail.com"));
        assertEquals(true, authSystem.isValidEmail("Anm#12@example.com"));
        assertEquals(true, authSystem.isValidEmail("anmol.srivastva@accolitedigital.com"));
    }
    @Test
    public void checkInvalidEmails() {
        assertEquals(false, authSystem.isValidEmail("user10@.com"));
        assertEquals(false, authSystem.isValidEmail("@example.com"));
        assertEquals(false, authSystem.isValidEmail("user10example.com"));
        assertEquals(false, authSystem.isValidEmail("user10@examplecom"));
        assertEquals(false, authSystem.isValidEmail("user10@example"));
        assertEquals(false, authSystem.isValidEmail("userexample"));
        assertEquals(false, authSystem.isValidEmail("user10@@example.com"));
        assertEquals(false, authSystem.isValidEmail("user10@somethng@example.com"));
        assertEquals(false, authSystem.isValidEmail(""));
    }
    @Test
    public void emailExistsValid() {
        assertEquals(true, authSystem.isEmailExists("user1@example.com"));
    }
    @Test
    public void emailExistsInValid() {
        assertEquals(false, authSystem.isEmailExists("user5@example.com"));
        assertEquals(false, authSystem.isEmailExists(""));
    }

}
