package org.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GoldPassengerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GoldPassenger#GoldPassenger(String, int, double)}
     *   <li>{@link GoldPassenger#deductBalance(double)}
     *   <li>{@link GoldPassenger#getBalance()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        GoldPassenger actualGoldPassenger = new GoldPassenger("Name", 10, 10.0d);
        actualGoldPassenger.deductBalance(10.0d);

        // Assert that nothing has changed
        assertEquals(1.0d, actualGoldPassenger.getBalance());
    }

    /**
     * Method under test: {@link GoldPassenger#hasSufficientBalance()}
     */
    @Test
    void testHasSufficientBalance() {
        // Arrange, Act and Assert
        assertTrue((new GoldPassenger("Name", 10, 10.0d)).hasSufficientBalance());
        assertFalse((new GoldPassenger("Name", 10, 0.0d)).hasSufficientBalance());
    }
}
