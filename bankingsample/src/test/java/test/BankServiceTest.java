package test;

import org.junit.jupiter.api.*;

import exception.BankingException;
import service.BankService;

import static org.junit.jupiter.api.Assertions.*;

	class BankServiceTest {

	    private BankService bank;

	    @BeforeEach
	    void setup() {
	        bank = new BankService();
	        bank.createAccount(1, "Amit", 1000);
	    }

	    @Test
	    void testDeposit() {
	        bank.deposit(1, 500);
	        assertEquals(1500, bank.getAccount(1).getBalance());
	    }

	    @Test
	    void testWithdraw() {
	        bank.withdraw(1, 300);
	        assertEquals(700, bank.getAccount(1).getBalance());
	    }

	    @Test
	    void testInsufficientBalance() {
	        assertThrows(BankingException.class, () ->
	                bank.withdraw(1, 3000)
	        );
	    }

	    @Test
	    void testDuplicateAccount() {
	        assertThrows(BankingException.class, () ->
	                bank.createAccount(1, "Test", 500)
	        );
	    }
	    @Test 
	    void testwrongAccountWithdraw(){
	    	assertThrows(BankingException.class,()->{
	    		bank.withdraw(2,100);
	    	});
	    }
	    @Test
	    void testWrongAccountDeposit() {
	    	assertThrows(BankingException.class,()->{
	    		bank.deposit(2, 200);
	    	});
	    }
	    @Test
	    void testWithdrawWithNegativeAmount() {
	    	assertThrows(BankingException.class,()->{
	    		bank.withdraw(1, -20);
	    	});
	    }
	    @Test
	    void testDepositWithNegativeAmount() {
	    	assertThrows(BankingException.class,()->{
	    		bank.deposit(1, -30);
	    	});
	    }
	}



