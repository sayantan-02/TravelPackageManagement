package org.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ActivityTest {
    /**
     * Method under test: {@link Activity#addPassenger(Passenger)}
     */
    @Test
    void testAddPassenger() {
        // Arrange
        Activity activity = new Activity("Name", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Name", new ArrayList<>()));

        // Act
        activity.addPassenger(new Passenger("Name", 10));

        // Assert
        assertEquals(1, activity.getPassengers().size());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Activity#getCapacity()}
     *   <li>{@link Activity#getCost()}
     *   <li>{@link Activity#getDescription()}
     *   <li>{@link Activity#getDestination()}
     *   <li>{@link Activity#getName()}
     *   <li>{@link Activity#getPassengers()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        Destination destination = new Destination("Name", new ArrayList<>());

        Activity activity = new Activity("Name", "The characteristics of someone or something", 10.0d, 3, destination);

        // Act
        int actualCapacity = activity.getCapacity();
        double actualCost = activity.getCost();
        String actualDescription = activity.getDescription();
        Destination actualDestination = activity.getDestination();
        String actualName = activity.getName();
        List<Passenger> actualPassengers = activity.getPassengers();

        // Assert
        assertEquals("Name", actualName);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals(10.0d, actualCost);
        assertEquals(3, actualCapacity);
        assertEquals(actualDestination.getActivities(), actualPassengers);
        assertSame(destination, actualDestination);
    }

    /**
     * Method under test:
     * {@link Activity#Activity(String, String, double, int, Destination)}
     */
    @Test
    void testNewActivity() {
        // Arrange
        ArrayList<Activity> activities = new ArrayList<>();
        Destination destination = new Destination("Name", activities);

        // Act
        Activity actualActivity = new Activity("Name", "The characteristics of someone or something", 10.0d, 3,
                destination);

        // Assert
        assertEquals("Name", actualActivity.getName());
        assertEquals("The characteristics of someone or something", actualActivity.getDescription());
        assertEquals(10.0d, actualActivity.getCost());
        assertEquals(3, actualActivity.getCapacity());
        assertEquals(activities, actualActivity.getPassengers());
        assertSame(destination, actualActivity.getDestination());
    }

    /**
     * Method under test: {@link Activity#removePassenger(Passenger)}
     */
    @Test
    void testRemovePassenger() {
        // Arrange
        Activity activity = new Activity("Name", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Name", new ArrayList<>()));

        // Act
        activity.removePassenger(new Passenger("Name", 10));

        // Assert
        assertTrue(activity.getPassengers().isEmpty());
    }
}
