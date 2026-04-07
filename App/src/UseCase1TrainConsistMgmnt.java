import java.util.ArrayList;
import java.util.List;


public class UseCase1TrainConsistMgmnt {
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================");

        List<String> trainConsist = new ArrayList<>();


        System.out.println("\nTrain initialized successfully ...");


        System.out.println("Initial Bogie Count : " + trainConsist.size());


        System.out.println("Current Train Consist : " + trainConsist);


        System.out.println("\nSystem ready for operations ...");
    }
}