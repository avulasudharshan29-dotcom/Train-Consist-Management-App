import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

public class UseCase11TrainConsistMgmntTest {

    // Regex patterns
    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile("^TRN-\\d{4}$");
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile("^PET-[A-Z]{2}$");

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TRAIN_ID_PATTERN.matcher("TRN-1234").matches());
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TRAIN_ID_PATTERN.matcher("TRAIN12").matches());
        assertFalse(TRAIN_ID_PATTERN.matcher("TRN12A").matches());
        assertFalse(TRAIN_ID_PATTERN.matcher("1234-TRN").matches());
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(CARGO_CODE_PATTERN.matcher("PET-AB").matches());
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(CARGO_CODE_PATTERN.matcher("PET-ab").matches());   // lowercase
        assertFalse(CARGO_CODE_PATTERN.matcher("PET123").matches());   // digits
        assertFalse(CARGO_CODE_PATTERN.matcher("AB-PET").matches());   // wrong order
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TRAIN_ID_PATTERN.matcher("TRN-123").matches());    // only 3 digits
        assertFalse(TRAIN_ID_PATTERN.matcher("TRN-12345").matches());  // 5 digits
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(CARGO_CODE_PATTERN.matcher("PET-ab").matches());   // lowercase letters
        assertTrue(CARGO_CODE_PATTERN.matcher("PET-FH").matches());    // uppercase letters
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TRAIN_ID_PATTERN.matcher("").matches());
        assertFalse(CARGO_CODE_PATTERN.matcher("").matches());
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TRAIN_ID_PATTERN.matcher("TRN-1234X").matches());  // extra char
        assertFalse(CARGO_CODE_PATTERN.matcher("PET-ABC").matches());  // 3 letters
    }
}
