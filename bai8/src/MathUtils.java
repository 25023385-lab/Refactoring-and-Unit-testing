import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MathUtils {
    public static int max(int a, int b) {
        if (a >= b) return a;
        return b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider must not be zero");
        }
        return a / b;
    }
}



 class MathUtilsTest {

    // --- SETUP & TEARDOWN ---

    @BeforeAll
    public static void setUp() {
        System.out.println("=== Bắt đầu chạy MathUtilsTest ===");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("=== Kết thúc ===");
    }

    // --- TEST CASES CHO HÀM MAX ---

    @Test
    public void testMax_AGreaterThanB() {
        assertEquals(5, MathUtils.max(5, 3), "Lỗi khi a > b");
    }

    @Test
    public void testMax_AEqualsB() {
        assertEquals(4, MathUtils.max(4, 4), "Lỗi khi a = b");
    }

    @Test
    public void testMax_ALessThanB() {
        assertEquals(8, MathUtils.max(2, 8), "Lỗi khi a < b");
    }

    @Test
    public void testMax_Boundary_MaxInt() {
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, 0));
    }

    @Test
    public void testMax_Boundary_MinInt() {
        assertEquals(0, MathUtils.max(Integer.MIN_VALUE, 0));
    }

    @Test
    public void testMax_Boundary_BothMaxInt() {
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    // --- TEST CASES CHO HÀM DIVIDE ---

    @Test
    public void testDivide_BGreaterThanZero() {
        assertEquals(5, MathUtils.divide(10, 2), "Lỗi khi chia cho số dương");
    }

    @Test
    public void testDivide_BLessThanZero() {
        assertEquals(-5, MathUtils.divide(10, -2), "Lỗi khi chia cho số âm");
    }

    @Test
    public void testDivide_BEqualsZero_ThrowsException() {
        // Bắt ngoại lệ và kiểm tra xem thông báo lỗi có đúng không
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> MathUtils.divide(10, 0),
                "Hàm phải ném ra IllegalArgumentException khi b = 0"
        );

        assertEquals("Divider must not be zero", exception.getMessage());
    }
}