import org.junit.jupiter.api.BeforeEach;

import java.util.List;

/**
 * This test is should fail
 */
public class DummyTest extends TestSort {
    @BeforeEach
    public void setup() {
        sort = new Sort() {
            @Override
            public <T extends Comparable<T>> List<T> sort(List<T> unsortedList) {
                return unsortedList;
            }
        };
    }
}
