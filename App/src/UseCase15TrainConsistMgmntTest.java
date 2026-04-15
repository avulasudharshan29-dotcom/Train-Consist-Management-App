import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UseCase15TrainConsistMgmntTest {

    @Test
    void testCargo_SafeAssignment() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie =
                new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie =
                new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertNull(bogie.cargo); // cargo not assigned due to exception
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie =
                new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie1 =
                new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        bogie1.assignCargo("Petroleum");

        UseCase15TrainConsistMgmnt.GoodsBogie bogie2 =
                new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        bogie2.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie1.cargo);
        assertNull(bogie2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie =
                new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        // No direct assertion for finally block, but program continues safely
        assertNull(bogie.cargo);
    }
}
