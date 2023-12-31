package org.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PremiumPassengerTest {
    /**
     * Method under test: {@link PremiumPassenger#PremiumPassenger(String, int)}
     */
    @Test
    void testNewPremiumPassenger() {
        // Arrange and Act
        PremiumPassenger actualPremiumPassenger = new PremiumPassenger("Name", 10);

        // Assert
        assertEquals("Name", actualPremiumPassenger.getName());
        assertEquals(10, actualPremiumPassenger.getPassengerNumber());
        assertTrue(actualPremiumPassenger.getActivities().isEmpty());
    }
}
