import java.util.LinkedList;
import java.util.List;
public class MaintainOrderedBogieIDs {
    public static void main(String[] args) {
        System.out.println("===");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("===");
        List<String> trainConsist = new LinkedList<>();
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("\nInitial Train Consist:");
        System.out.println(trainConsist);
        trainConsist.add(2, "Pantry Car");
        System.out.println("\nAfter Inserting Pantry Car at position 2:");
        System.out.println(trainConsist);
        ((LinkedList<String>) trainConsist).removeFirst();
        System.out.println("\nAfter Removing First Bogie:");
        System.out.println(trainConsist);
        ((LinkedList<String>) trainConsist).removeLast();
        System.out.println("\nAfter Removing Last Bogie:");
        System.out.println(trainConsist);
        System.out.println("\nFinal Ordered Train Consist:");
        System.out.println(trainConsist);
        System.out.println("\nUC4 ordered operations completed ...");
    }
}