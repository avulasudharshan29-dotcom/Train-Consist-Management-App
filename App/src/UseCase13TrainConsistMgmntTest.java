import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

public class UseCase13TrainConsistMgmntTest {

    static class Bogie {
        String type;
        int capacity;
        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    private List<Bogie> createDataset(int size) {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bogies.add(new Bogie("Test", (i % 100) + 1));
        }
        return bogies;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = createDataset(10);
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) filtered.add(b);
        }
        assertTrue(filtered.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = createDataset(10);
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertTrue(filtered.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = createDataset(1000);
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) loopFiltered.add(b);
        }
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertEquals(loopFiltered.size(), streamFiltered.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = createDataset(1000);

        long start = System.nanoTime();
        bogies.stream().filter(b -> b.capacity > 60).collect(Collectors.toList());
        long end = System.nanoTime();

        long elapsed = end - start;
        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = createDataset(100000);
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertFalse(filtered.isEmpty());
        assertTrue(filtered.stream().allMatch(b -> b.capacity > 60));
    }
}
