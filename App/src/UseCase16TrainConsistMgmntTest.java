import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UseCase16TrainConsistMgmntTest {

    @Test
    void testSort_BasicSorting() {
        int[] capacities = {72, 56, 24, 70, 60};
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, capacities);
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] capacities = {24, 56, 60, 70, 72};
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, capacities);
    }

    @Test
    void testSort_DuplicateValues() {
        int[] capacities = {72, 56, 56, 24};
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 56, 72}, capacities);
    }

    @Test
    void testSort_SingleElementArray() {
        int[] capacities = {50};
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        assertArrayEquals(new int[]{50}, capacities);
    }

    @Test
    void testSort_AllEqualValues() {
        int[] capacities = {40, 40, 40};
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        assertArrayEquals(new int[]{40, 40, 40}, capacities);
    }
}
