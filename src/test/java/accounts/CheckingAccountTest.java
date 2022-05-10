package accounts;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CheckingAccountTest {
    // given:
    final private Account account1 = new CheckingAccount(121, 22000);
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
        results.add(!account1.payBoolean(amount1));
        results.add(account1.payBoolean(amount2));

        // then:
        for (Boolean item : results) {
            assertThat(item, is(true));
        }
    }
}