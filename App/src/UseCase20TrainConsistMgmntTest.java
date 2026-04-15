import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UseCase20TrainConsistMgmntTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] bogies = {};
        assertThrows(IllegalStateException.class,
                () -> UseCase20TrainConsistMgmnt.searchBogie(bogies, "BG101"));
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogies = {"BG101","BG205"};
        assertDoesNotThrow(() -> UseCase20TrainConsistMgmnt.searchBogie(bogies, "BG101"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogies = {"BG101","BG205","BG309"};
        assertTrue(UseCase20TrainConsistMgmnt.searchBogie(bogies, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogies = {"BG101","BG205","BG309"};
        assertFalse(UseCase20TrainConsistMgmnt.searchBogie(bogies, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogies = {"BG101"};
        assertTrue(UseCase20TrainConsistMgmnt.searchBogie(bogies, "BG101"));
    }
}
