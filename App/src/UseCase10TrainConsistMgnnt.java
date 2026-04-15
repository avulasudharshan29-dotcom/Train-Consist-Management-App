import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

class UseCase10TrainConsistMgnntTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    private int aggregateSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)
        );
        assertEquals(222, aggregateSeats(bogies));
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("AC Chair", 30),
                new Bogie("First Class", 20)
        );
        assertEquals(100, aggregateSeats(bogies));
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Collections.singletonList(new Bogie("Sleeper", 72));
        assertEquals(72, aggregateSeats(bogies));
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        assertEquals(0, aggregateSeats(bogies));
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        Bogie sleeper = new Bogie("Sleeper", 72);
        Bogie acChair = new Bogie("AC Chair", 56);
        List<Bogie> bogies = Arrays.asList(sleeper, acChair);
        int total = aggregateSeats(bogies);
        assertEquals(sleeper.capacity + acChair.capacity, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 10),
                new Bogie("AC Chair", 20),
                new Bogie("First Class", 30)
        );
        assertEquals(60, aggregateSeats(bogies));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        int beforeSize = bogies.size();
        aggregateSeats(bogies);
        int afterSize = bogies.size();

        assertEquals(beforeSize, afterSize);
    }

    @Test
    void testReduce_NumericAggregationValidation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 40),
                new Bogie("AC Chair", 35),
                new Bogie("First Class", 25)
        );
        int expectedSum = 40 + 35 + 25;
        assertEquals(expectedSum, aggregateSeats(bogies));
    }
}