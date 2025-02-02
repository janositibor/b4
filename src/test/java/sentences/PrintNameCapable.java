package sentences;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public interface PrintNameCapable {

    @BeforeEach
    default void printName(TestInfo testInfo) {
        System.out.println("Test case display name: "
                + testInfo.getDisplayName());
    }
}