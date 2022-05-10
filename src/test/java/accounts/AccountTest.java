package accounts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountTest {
    // given:
    final private Account account1 = new SavingAccount(1, 22000);
    final private Account account2 = new CreditAccount(2);
    final private Account account3 = new CheckingAccount(3, 20000);
    final private List<Boolean> results = new ArrayList<>();

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
    public void testTransfer(int amount) {
        // when:
        results.add(account1.transferBoolean(account2, amount));
        results.add(account1.transferBoolean(account3, amount));
        results.add(account2.transferBoolean(account1, amount));
        results.add(account2.transferBoolean(account3, amount));
        results.add(account3.transferBoolean(account1, amount));
        results.add(account3.transferBoolean(account2, amount));

        // then:
        for (Boolean item : results) {
            assertThat(item, is(true));
        }
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    public void testTransfer(Account account, int amount) {
        //then
        assertThatCode(() -> account3.transfer(account, amount)).doesNotThrowAnyException();
    }

    public Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(account1, 4500),
                Arguments.of(account1, -2597),
                Arguments.of(account1, 4000000),
                Arguments.of(account2, 4500),
                Arguments.of(account2, 4000000),
                Arguments.of(account2, -2597)
        );
    }
}