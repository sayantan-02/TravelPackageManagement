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

class DestinationTest {
    /**
     * Method under test: {@link Destination#addActivity(Activity)}
     */
    @Test
    void testAddActivity() {
        // Arrange
        Destination destination = new Destination("Name", new ArrayList<>());

        // Act
        destination.addActivity(new Activity("Name", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Name", new ArrayList<>())));

        // Assert
        assertEquals(1, destination.getActivities().size());
    }

    /**
     * Method under test: {@link Destination#addActivity(Activity)}
     */
    @Test
    void testAddActivity2() {
        try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {
            Runtime runtime = mock(Runtime.class);
            doNothing().when(runtime).exit(anyInt());
            mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
            ArrayList<Activity> activities = new ArrayList<>();
            Destination destination = new Destination("org.example.Activity", activities);
            Destination destination2 = new Destination("Name", new ArrayList<>());
            Activity activity = new Activity("Name", "The characteristics of someone or something", 10.0d, 3, destination2);
            destination.addActivity(activity);
            verify(runtime).exit(anyInt());
            mockRuntime.verify(Runtime::getRuntime);
            assertEquals("Name", activity.getName());
            assertEquals("The characteristics of someone or something", activity.getDescription());
            assertEquals("org.example.Activity", destination.getName());
            assertEquals(10.0d, activity.getCost());
            assertEquals(3, activity.getCapacity());
            assertTrue(destination.getActivities().isEmpty());
            assertEquals(activities, activity.getPassengers());
            assertSame(destination2, activity.getDestination());
        }
        // Arrange
        // Act
        // Assert that nothing has changed
    }

    /**
     * Method under test: {@link Destination#getActivity(String)}
     */
    @Test
    void testGetActivity() {
        // Arrange, Act and Assert
        assertNull((new Destination("Name", new ArrayList<>())).getActivity("Activity Name"));
    }

    /**
     * Method under test: {@link Destination#getActivity(String)}
     */
    @Test
    void testGetActivity2() {
        // Arrange
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Name", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Name", new ArrayList<>())));

        // Act and Assert
        assertNull((new Destination("Name", activities)).getActivity("Activity Name"));
    }

    /**
     * Method under test: {@link Destination#getActivity(String)}
     */
    @Test
    void testGetActivity3() {
        // Arrange
        ArrayList<Activity> activities = new ArrayList<>();
        Activity activity = new Activity("Activity Name", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Name", new ArrayList<>()));

        activities.add(activity);

        // Act and Assert
        assertSame(activity, (new Destination("Name", activities)).getActivity("Activity Name"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Destination#Destination(String, List)}
     *   <li>{@link Destination#getActivities()}
     *   <li>{@link Destination#getName()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        ArrayList<Activity> activities = new ArrayList<>();

        // Act
        Destination actualDestination = new Destination("Name", activities);
        List<Activity> actualActivities = actualDestination.getActivities();

        // Assert
        assertEquals("Name", actualDestination.getName());
        assertSame(activities, actualActivities);
    }

    /**
     * Method under test: {@link Destination#removeActivity(Activity)}
     */
    @Test
    void testRemoveActivity() {
        // Arrange
        Destination destination = new Destination("Name", new ArrayList<>());

        // Act
        destination.removeActivity(new Activity("Name", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Name", new ArrayList<>())));

        // Assert
        assertTrue(destination.getActivities().isEmpty());
    }
}
