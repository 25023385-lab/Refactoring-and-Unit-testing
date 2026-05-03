

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/*Test case EP
TC1: gpa = -1 → Exception
TC2: gpa = 3.0 → "Yếu"
TC3: gpa = 5.5 → "Trung bình"
TC4: gpa = 7.0 → "Khá"
TC5: gpa = 9.0 → "Giỏi"
TC6: gpa = 11 → Exception*/
/*Biên dưới
TC7: gpa = 0.0 → "Yếu"
TC8: gpa = -0.1 → Exception
 Biên 5.0
TC9: gpa = 4.9 → "Yếu"
TC10: gpa = 5.0 → "Trung bình" (theo spec)
TC11: gpa = 5.1 → "Trung bình"

TC10 sẽ FAIL → phát hiện bug

Biên 6.5
TC12: gpa = 6.4 → "Trung bình"
TC13: gpa = 6.5 → "Khá"
TC14: gpa = 6.6 → "Khá"
Biên 8.0
TC15: gpa = 7.9 → "Khá"
TC16: gpa = 8.0 → "Giỏi"
TC17: gpa = 8.1 → "Giỏi"
Biên trên
TC18: gpa = 10.0 → "Giỏi"
TC19: gpa = 10.1 → Exception*/
public class GradeClassifierTest {
    @Test
    void test_yeu(){
        assertEquals("Yếu" , GradeClassifier.classifyGrade(3.0));
    }
    @Test
    void test_tb(){
        assertEquals("Trung bình" , GradeClassifier.classifyGrade(5.5));
    }
    @Test
    void testEP_Kha() {
        assertEquals("Khá", GradeClassifier.classifyGrade(7.0));
    }

    @Test
    void testEP_Gioi() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(9.0));
    }

    // ===== BVA =====
    @Test
    void testBoundary_0() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(0.0));
    }

    @Test
    void testBoundary_5() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.0));
    }

    @Test
    void testBoundary_6_5() {
        assertEquals("Khá", GradeClassifier.classifyGrade(6.5));
    }

    @Test
    void testBoundary_8() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(8.0));
    }

    @Test
    void testBoundary_10() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(10.0));
    }
}
