import java.util.LinkedHashSet;
import java.util.Set;


public class PreserveInsertionOrderofBogies {
    public static void main(String[] args) {
        System.out.println("===");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("===");

        // LinkedHashSet preserves order and ensures uniqueness
        Set<String> formation = new LinkedHashSet<>();

        // Attach bogies in order
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Attempt to attach a duplicate bogie
        formation.add("Sleeper"); // Duplicate entry ignored

        // Display final formation
        System.out.println("\nFinal Train Formation:");
        System.out.println(formation);

        System.out.println("\nNote:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println("\nUC5 formation setup completed ...");
    }
}