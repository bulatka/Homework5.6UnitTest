package accounts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountsTest {
    // given:
    private Account account1 = new SavingAccount(1, 22000);
    private Account account2 = new CreditAccount(2);
    private Account account3 = new CheckingAccount(3, 10000);

    @BeforeAll
    public void beforeAll() {
        account2.pay(100000);
    }

    @AfterAll
    public void afterAll() {
        System.out.println("TESTS FINISHED!");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000})
    public void testTransferBooleanChecking(int amount) {
        // when:
        boolean res1 = account3.transferBoolean(account1, amount);
        boolean res2 = account3.transferBoolean(account2, amount);

        // then:
        Assertions.assertTrue(res1);
        Assertions.assertTrue(res2);
    }

    @Test
    public void testPayBooleanChecking() {
        // given:
        int amount1 = 400000;
        int amount2 = 4500;

        // when:
        boolean res1 = account3.payBoolean(amount1);
        boolean res2 = account3.payBoolean(amount2);

        // then:
        Assertions.assertFalse(res1);
        Assertions.assertTrue(res2);
    }

    @ParameterizedTest
    @MethodSource
    public void test
}
