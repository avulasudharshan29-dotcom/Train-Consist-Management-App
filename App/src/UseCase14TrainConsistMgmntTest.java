import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UseCase14TrainConsistMgmntTest {

    @Test
    void testException_ValidCapacityCreation() throws UseCase14TrainConsistMgmnt.InvalidCapacityException {
        UseCase14TrainConsistMgmnt.PassengerBogie bogie =
                new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 50);
        assertEquals("Sleeper", bogie.type);
        assertEquals(50, bogie.capacity);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception ex = assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgmnt.PassengerBogie("AC Chair", -10));
        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception ex = assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgmnt.PassengerBogie("First Class", 0));
        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception ex = assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", -1));
        assertTrue(ex.getMessage().contains("Capacity must be greater than zero"));
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws UseCase14TrainConsistMgmnt.InvalidCapacityException {
        UseCase14TrainConsistMgmnt.PassengerBogie bogie =
                new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 72);
        assertEquals("Sleeper", bogie.type);
        assertEquals(72, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws UseCase14TrainConsistMgmnt.InvalidCapacityException {
        UseCase14TrainConsistMgmnt.PassengerBogie b1 =
                new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 40);
        UseCase14TrainConsistMgmnt.PassengerBogie b2 =
                new UseCase14TrainConsistMgmnt.PassengerBogie("AC Chair", 60);
        UseCase14TrainConsistMgmnt.PassengerBogie b3 =
                new UseCase14TrainConsistMgmnt.PassengerBogie("First Class", 80);

        assertEquals(40, b1.capacity);
        assertEquals(60, b2.capacity);
        assertEquals(80, b3.capacity);
    }
}
