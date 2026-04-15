import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class UseCase17TrainConsistMgmntTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] bogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        Arrays.sort(bogies);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"}, bogies);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] bogies = {"Luxury", "General", "Sleeper", "AC Chair"};
        Arrays.sort(bogies);
        assertArrayEquals(new String[]{"AC Chair", "General", "Luxury", "Sleeper"}, bogies);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] bogies = {"AC Chair", "First Class", "General"};
        Arrays.sort(bogies);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General"}, bogies);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] bogies = {"Sleeper", "AC Chair", "Sleeper", "General"};
        Arrays.sort(bogies);
        assertArrayEquals(new String[]{"AC Chair", "General", "Sleeper", "Sleeper"}, bogies);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] bogies = {"Sleeper"};
        Arrays.sort(bogies);
        assertArrayEquals(new String[]{"Sleeper"}, bogies);
    }
}
