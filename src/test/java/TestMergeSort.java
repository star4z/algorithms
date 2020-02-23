import org.junit.jupiter.api.BeforeEach;

public class TestMergeSort extends TestSort {
    @BeforeEach
    public void setup() {
        sort = new InsertionSort();
    }
}
