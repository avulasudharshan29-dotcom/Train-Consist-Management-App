import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase8TrainConsistMgmntTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    private List<Bogie> getSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));
        return bogies;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
        assertTrue(result.stream().allMatch(b -> b.capacity > 70));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
        assertFalse(result.stream().anyMatch(b -> b.capacity == 70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
        assertFalse(result.stream().anyMatch(b -> b.capacity < 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertEquals(2, result.size()); // Sleeper (72), General (90)
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 100)
                .collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 20)
                .collect(Collectors.toList());
        assertEquals(getSampleBogies().size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();
        List<Bogie> result = emptyList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();
        List<Bogie> result = original.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertEquals(4, original.size()); // original list remains intact
    }
}