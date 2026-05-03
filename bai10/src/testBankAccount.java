
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*1. deposit(double amount)
EP
TC1: amount = -10 → Exception
TC2: amount = 0 → Exception
TC3: amount = 100 → balance tăng
BVA (biên = 0)
TC4: amount = -0.01 → Exception
TC5: amount = 0 → Exception
TC6: amount = 0.01 → balance tăng
2. withdraw(double amount) (giả sử balance = 100)
EP
TC1: amount = -10 → Exception
TC2: amount = 0 → Exception
TC3: amount = 150 → false
TC4: amount = 50 → true
TC5: amount = 100 → true
BVA
quanh 0
TC6: amount = -0.01 → Exception
TC7: amount = 0 → Exception
TC8: amount = 0.01 → true
quanh balance = 100
TC9: amount = 99.99 → true
TC10: amount = 100 → true
TC11: amount = 100.01 → false*/
public class testBankAccount {
    private BankAccount acc;
    @BeforeEach
    void setup(){
        acc = new BankAccount("1","Bách",500);
    }
    @Test
    void deposit1(){
        assertThrows(IllegalArgumentException.class , ()-> acc.deposit(-10));
    }
    @Test
    void deposit2(){
        assertThrows(IllegalArgumentException.class , () -> acc.deposit(0));
    }
    @Test
    void deposit3(){
        acc.deposit(100);
        assertEquals(600,acc.getBalance());
    }
    @Test
    void deposit_boundary_above_zero() {
        acc.deposit(0.01);
        assertEquals(500.01, acc.getBalance());
    }
    @Test
    void withdraw_negative() {
        assertThrows(IllegalArgumentException.class, () -> acc.withdraw(-10));
    }

    @Test
    void withdraw_zero() {
        assertThrows(IllegalArgumentException.class, () -> acc.withdraw(0));
    }

    @Test
    void withdraw_exceed_balance() {
        boolean result = acc.withdraw(600);
        assertFalse(result);
        assertEquals(500, acc.getBalance()); // không đổi
    }

    @Test
    void withdraw_valid() {
        boolean result = acc.withdraw(200);
        assertTrue(result);
        assertEquals(300, acc.getBalance());
    }

    @Test
    void withdraw_equal_balance() {
        boolean result = acc.withdraw(500);
        assertTrue(result);
        assertEquals(0, acc.getBalance());
    }

    @Test
    void withdraw_boundary_above_balance() {
        boolean result = acc.withdraw(500.01);
        assertFalse(result);
    }
    @Test
    void test(){
        BankAccount acc2 = new BankAccount("2" , "Bách", 0);
        assertEquals(0,acc2.getBalance());
        acc2.deposit(500);
        assertTrue(acc2.withdraw(200));
        assertFalse(acc2.withdraw(400));
        assertEquals(300,acc2.getBalance());
    }
}
