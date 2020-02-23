import org.junit.jupiter.api.BeforeEach;

public class TestInsertionSort extends TestSort {
    @BeforeEach
    public void setup() {
        sort = new InsertionSort();
    }
}
