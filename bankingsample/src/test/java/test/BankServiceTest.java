package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import Repository.AccountRepository;
import exception.BankingException;
import model.Account;
import service.BankService;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    @Mock
    private AccountRepository repository;

    @InjectMocks
    private BankService bankService;

    private Account account;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        account = new Account(1, "Amit", 1000);
    }

    @Test
    void testDeposit() {

        when(repository.findById(1)).thenReturn(account);//mocking

        bankService.deposit(1, 500);

        assertEquals(1500, account.getBalance());

        verify(repository).save(account);
    }
    @Test
    void testWithdrawInsufficientBalance() {

        when(repository.findById(1)).thenReturn(account);

        assertThrows(IllegalArgumentException.class, () ->
                bankService.withdraw(1, 2000)
        );

        verify(repository, never()).save(any());
    }
    @Test
    void testWithdraw() {
    	when(repository.findById(1)).thenReturn(account);
    	bankService.withdraw(1, 100);
    	assertEquals(900,account.getBalance());
    	verify(repository).save(account);
    }
    @Test
    void testWithdrawNegativeAmount() {
    	when(repository.findById(1)).thenReturn(account);
    	assertThrows(IllegalArgumentException.class,()->{
    		bankService.withdraw(1,-10);
    	});
    	verify(repository,never()).save(any());
    }
    @Test
    void testDepositNegativeAmount() {
    	when(repository.findById(1)).thenReturn(account);
    	assertThrows(IllegalArgumentException.class,()->{
    		bankService.deposit(1,-30);
    	});
    	verify(repository,never()).save(any());
    }
    @Test
    void testDepositWithWrongAccountNumber() {
    	when(repository.findById(1)).thenReturn(account);
    	assertThrows(BankingException.class,()->{
    		bankService.deposit(2,100);
    	});
    	verify(repository,never()).save(any());
    }
    @Test
    void testWithdrawWithWrongAccountNumber() {
    	when(repository.findById(1)).thenReturn(account);
    	assertThrows(BankingException.class,()->{
    		bankService.deposit(3, 300);
    	});
    }
  
}
