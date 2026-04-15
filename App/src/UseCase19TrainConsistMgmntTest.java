import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class UseCase19TrainConsistMgmntTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};
        Arrays.sort(bogies);
        assertTrue(UseCase19TrainConsistMgmnt.binarySearch(bogies, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};
        Arrays.sort(bogies);
        assertFalse(UseCase19TrainConsistMgmnt.binarySearch(bogies, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};
        Arrays.sort(bogies);
        assertTrue(UseCase19TrainConsistMgmnt.binarySearch(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};
        Arrays.sort(bogies);
        assertTrue(UseCase19TrainConsistMgmnt.binarySearch(bogies, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogies = {"BG101"};
        Arrays.sort(bogies);
        assertTrue(UseCase19TrainConsistMgmnt.binarySearch(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] bogies = {};
        Arrays.sort(bogies);
        assertFalse(UseCase19TrainConsistMgmnt.binarySearch(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] bogies = {"BG309","BG101","BG550","BG205","BG412"};
        Arrays.sort(bogies); // Ensure sorted before search
        assertTrue(UseCase19TrainConsistMgmnt.binarySearch(bogies, "BG205"));
    }
}
