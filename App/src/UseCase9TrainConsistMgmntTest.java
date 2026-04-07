import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase9TrainConsistMgmntTest {

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
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));
        return bogies;
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> grouped = getSampleBogies().stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> grouped = getSampleBogies().stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<Bogie>> grouped = getSampleBogies().stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertEquals(3, grouped.size()); // Sleeper, AC Chair, First Class
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();
        Map<String, List<Bogie>> grouped = emptyList.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> singleList = Collections.singletonList(new Bogie("Sleeper", 80));
        Map<String, List<Bogie>> grouped = singleList.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertEquals(1, grouped.size());
        assertTrue(grouped.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<Bogie>> grouped = getSampleBogies().stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertTrue(grouped.keySet().containsAll(Arrays.asList("Sleeper", "AC Chair", "First Class")));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        Map<String, List<Bogie>> grouped = getSampleBogies().stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
        assertEquals(1, grouped.get("First Class").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();
        Map<String, List<Bogie>> grouped = original.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertEquals(5, original.size()); // original list remains intact
    }
}