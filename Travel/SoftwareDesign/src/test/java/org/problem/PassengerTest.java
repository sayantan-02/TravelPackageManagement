package org.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class PassengerTest {
    /**
     * Method under test: {@link Passenger#addActivity(Activity)}
     */
    @Test
    void testAddActivity() {
        // Arrange
        Passenger passenger = new Passenger("Name", 10);

        // Act
        passenger.addActivity(new Activity("Name", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Name", new ArrayList<>())));

        // Assert
        assertEquals(1, passenger.getActivities().size());
    }

    /**
     * Method under test: {@link Passenger#addActivity(Activity)}
     */
    @Test
    void testAddActivity2() {
        try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {
            Runtime runtime = mock(Runtime.class);
            doNothing().when(runtime).exit(anyInt());
            mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
            Passenger passenger = new Passenger("Name", 10);
            ArrayList<Activity> activities = new ArrayList<>();
            Destination destination = new Destination("Name", activities);
            Activity activity = new Activity("Name", "The characteristics of someone or something", 10.0d, 0, destination);
            passenger.addActivity(activity);
            verify(runtime).exit(anyInt());
            mockRuntime.verify(Runtime::getRuntime);
            assertEquals("Name", activity.getName());
            assertEquals("Name", passenger.getName());
            assertEquals("The characteristics of someone or something", activity.getDescription());
            assertEquals(0, activity.getCapacity());
            assertEquals(10, passenger.getPassengerNumber());
            assertEquals(10.0d, activity.getCost());
            assertEquals(activities, activity.getPassengers());
            Destination destination2 = activity.getDestination();
            List<Activity> expectedActivities = destination2.getActivities();
            assertEquals(expectedActivities, passenger.getActivities());
            assertSame(destination, destination2);
        }
        // Arrange
        // Act
        // Assert that nothing has changed
    }

    /**
     * Method under test: {@link Passenger#getActivity(String)}
     */
    @Test
    void testGetActivity() {
        // Arrange, Act and Assert
        assertNull((new Passenger("Name", 10)).getActivity("Activity Name"));
    }

    /**
     * Method under test: {@link Passenger#getActivity(String)}
     */
    @Test
    void testGetActivity2() {
        // Arrange
        Passenger passenger = new Passenger("Name", 10);
        passenger.addActivity(new Activity("Name", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Name", new ArrayList<>())));

        // Act and Assert
        assertNull(passenger.getActivity("Activity Name"));
    }

    /**
     * Method under test: {@link Passenger#getActivity(String)}
     */
    @Test
    void testGetActivity3() {
        // Arrange
        Passenger passenger = new Passenger("Name", 10);
        Activity activity = new Activity("Activity Name", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Name", new ArrayList<>()));

        passenger.addActivity(activity);

        // Act and Assert
        assertSame(activity, passenger.getActivity("Activity Name"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Passenger#Passenger(String, int)}
     *   <li>{@link Passenger#getActivities()}
     *   <li>{@link Passenger#getName()}
     *   <li>{@link Passenger#getPassengerNumber()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Passenger actualPassenger = new Passenger("Name", 10);
        actualPassenger.getActivities();
        String actualName = actualPassenger.getName();

        // Assert
        assertEquals("Name", actualName);
        assertEquals(10, actualPassenger.getPassengerNumber());
    }

    /**
     * Method under test: {@link Passenger#removeActivity(Activity)}
     */
    @Test
    void testRemoveActivity() {
        // Arrange
        Passenger passenger = new Passenger("Name", 10);

        // Act
        passenger.removeActivity(new Activity("Name", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Name", new ArrayList<>())));

        // Assert
        assertTrue(passenger.getActivities().isEmpty());
    }
}
