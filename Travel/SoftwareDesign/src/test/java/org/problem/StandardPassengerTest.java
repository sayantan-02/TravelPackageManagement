package org.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StandardPassengerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StandardPassenger#StandardPassenger(String, int, double)}
     *   <li>{@link StandardPassenger#deductBalance(double)}
     *   <li>{@link StandardPassenger#getBalance()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        StandardPassenger actualStandardPassenger = new StandardPassenger("Name", 10, 10.0d);
        actualStandardPassenger.deductBalance(10.0d);

        // Assert that nothing has changed
        assertEquals(0.0d, actualStandardPassenger.getBalance());
    }

    /**
     * Method under test: {@link StandardPassenger#hasSufficientBalance()}
     */
    @Test
    void testHasSufficientBalance() {
        // Arrange, Act and Assert
        assertTrue((new StandardPassenger("Name", 10, 10.0d)).hasSufficientBalance());
        assertFalse((new StandardPassenger("Name", 10, 0.0d)).hasSufficientBalance());
    }
}
