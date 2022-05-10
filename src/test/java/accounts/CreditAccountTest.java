package accounts;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreditAccountTest {
    // given:
    final private Account account1 = new CreditAccount(122);
    final private List<Boolean> results = new ArrayList<>();

    @BeforeAll
    public void beforeAll() {
        System.out.println("TESTS STARTED!");
    }

    @AfterAll
    public void afterAll() {
        System.out.println("TESTS FINISHED!");
    }

    @Test
    public void testPayBoolean() {
        // given:
        int amount1 = 4000000;
        int amount2 = 4500;

        // when:
        results.add(account1.payBoolean(amount1));
        results.add(account1.payBoolean(amount2));

        // then:
        for (Boolean item : results) {
            Assertions.assertTrue(item);
        }
    }
}
