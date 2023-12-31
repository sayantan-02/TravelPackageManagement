package org.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TravelPackageTest {
    /**
     * Method under test: {@link TravelPackage#getPassenger(int)}
     */
    @Test
    void testGetPassenger() {
        // Arrange, Act and Assert
        assertNull((new TravelPackage("Name", 1, new ArrayList<>())).getPassenger(10));
    }

    /**
     * Method under test: {@link TravelPackage#getPassenger(int)}
     */
    @Test
    void testGetPassenger2() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Name", 1, new ArrayList<>());
        Passenger passenger = new Passenger("Name", 10);

        travelPackage.addPassenger(passenger);

        // Act and Assert
        assertSame(passenger, travelPackage.getPassenger(10));
    }

    /**
     * Method under test: {@link TravelPackage#getPassenger(int)}
     */
    @Test
    void testGetPassenger3() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Name", 1, new ArrayList<>());
        travelPackage.addPassenger(new Passenger("Name", 1));

        // Act and Assert
        assertNull(travelPackage.getPassenger(10));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TravelPackage#TravelPackage(String, int, List)}
     *   <li>{@link TravelPackage#getName()}
     *   <li>{@link TravelPackage#getPassengerCapacity()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        TravelPackage actualTravelPackage = new TravelPackage("Name", 1, new ArrayList<>());
        String actualName = actualTravelPackage.getName();

        // Assert
        assertEquals("Name", actualName);
        assertEquals(1, actualTravelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printAvailableActivities()}
     */
    @Test
    void testPrintAvailableActivities() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Name", 1, new ArrayList<>());

        // Act
        travelPackage.printAvailableActivities();

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printAvailableActivities()}
     */
    @Test
    void testPrintAvailableActivities2() {
        // Arrange
        ArrayList<Destination> itinerary = new ArrayList<>();
        itinerary.add(new Destination("Available Activities:", new ArrayList<>()));
        TravelPackage travelPackage = new TravelPackage("Name", 1, itinerary);

        // Act
        travelPackage.printAvailableActivities();

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printAvailableActivities()}
     */
    @Test
    void testPrintAvailableActivities3() {
        // Arrange
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Available Activities:", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Available Activities:", new ArrayList<>())));
        Destination destination = new Destination("Available Activities:", activities);

        ArrayList<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination);
        TravelPackage travelPackage = new TravelPackage("Name", 1, itinerary);

        // Act
        travelPackage.printAvailableActivities();

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printAvailableActivities()}
     */
    @Test
    void testPrintAvailableActivities4() {
        // Arrange
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Available Activities:", "The characteristics of someone or something", 10.0d, 0,
                new Destination("Available Activities:", new ArrayList<>())));
        Destination destination = new Destination("Available Activities:", activities);

        ArrayList<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination);
        TravelPackage travelPackage = new TravelPackage("Name", 1, itinerary);

        // Act
        travelPackage.printAvailableActivities();

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printItinerary()}
     */
    @Test
    void testPrintItinerary() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Name", 1, new ArrayList<>());

        // Act
        travelPackage.printItinerary();

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printItinerary()}
     */
    @Test
    void testPrintItinerary2() {
        // Arrange
        ArrayList<Destination> itinerary = new ArrayList<>();
        itinerary.add(new Destination("Name", new ArrayList<>()));
        TravelPackage travelPackage = new TravelPackage("Name", 1, itinerary);

        // Act
        travelPackage.printItinerary();

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printItinerary()}
     */
    @Test
    void testPrintItinerary3() {
        // Arrange
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Activities:", "The characteristics of someone or something", 10.0d, 3,
                new Destination("Activities:", new ArrayList<>())));
        Destination destination = new Destination("Name", activities);

        ArrayList<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination);
        TravelPackage travelPackage = new TravelPackage("Name", 1, itinerary);

        // Act
        travelPackage.printItinerary();

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printPassengerDetails(int)}
     */
    @Test
    void testPrintPassengerDetails() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Name", 1, new ArrayList<>());

        // Act
        travelPackage.printPassengerDetails(10);

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printPassengerDetails(int)}
     */
    @Test
    void testPrintPassengerDetails2() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Name", 1, new ArrayList<>());
        travelPackage.addPassenger(new Passenger("Passenger not found.", 10));

        // Act
        travelPackage.printPassengerDetails(10);

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printPassengerDetails(int)}
     */
    @Test
    void testPrintPassengerDetails3() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Name", 1, new ArrayList<>());
        travelPackage.addPassenger(new Passenger("Passenger not found.", 1));

        // Act
        travelPackage.printPassengerDetails(10);

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printPassengerDetails(int)}
     */
    @Test
    void testPrintPassengerDetails4() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Name", 1, new ArrayList<>());
        travelPackage.addPassenger(new GoldPassenger("Premium Passenger has no balance!", 10, 10.0d));

        // Act
        travelPackage.printPassengerDetails(10);

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printPassengerDetails(int)}
     */
    @Test
    void testPrintPassengerDetails5() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Name", 1, new ArrayList<>());
        travelPackage.addPassenger(new StandardPassenger("Premium Passenger has no balance!", 10, 10.0d));

        // Act
        travelPackage.printPassengerDetails(10);

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printPassengerDetails(int)}
     */
    @Test
    void testPrintPassengerDetails6() {
        // Arrange
        Passenger passenger = new Passenger("Passenger not found.", 10);
        passenger
                .addActivity(new Activity("Premium Passenger has no balance!", "The characteristics of someone or something",
                        10.0d, 3, new Destination("Premium Passenger has no balance!", new ArrayList<>())));

        TravelPackage travelPackage = new TravelPackage("Name", 1, new ArrayList<>());
        travelPackage.addPassenger(passenger);

        // Act
        travelPackage.printPassengerDetails(10);

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printPassengerDetails(int)}
     */
    @Test
    void testPrintPassengerDetails7() {
        // Arrange
        GoldPassenger passenger = new GoldPassenger("Premium Passenger has no balance!", 10, 10.0d);
        passenger
                .addActivity(new Activity("Premium Passenger has no balance!", "The characteristics of someone or something",
                        10.0d, 3, new Destination("Premium Passenger has no balance!", new ArrayList<>())));

        TravelPackage travelPackage = new TravelPackage("Name", 1, new ArrayList<>());
        travelPackage.addPassenger(passenger);

        // Act
        travelPackage.printPassengerDetails(10);

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printPassengerDetails(int)}
     */
    @Test
    void testPrintPassengerDetails8() {
        // Arrange
        StandardPassenger passenger = new StandardPassenger("Premium Passenger has no balance!", 10, 10.0d);
        passenger
                .addActivity(new Activity("Premium Passenger has no balance!", "The characteristics of someone or something",
                        10.0d, 3, new Destination("Premium Passenger has no balance!", new ArrayList<>())));

        TravelPackage travelPackage = new TravelPackage("Name", 1, new ArrayList<>());
        travelPackage.addPassenger(passenger);

        // Act
        travelPackage.printPassengerDetails(10);

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printPassengerList()}
     */
    @Test
    void testPrintPassengerList() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Name", 1, new ArrayList<>());

        // Act
        travelPackage.printPassengerList();

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

    /**
     * Method under test: {@link TravelPackage#printPassengerList()}
     */
    @Test
    void testPrintPassengerList2() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Name", 1, new ArrayList<>());
        travelPackage.addPassenger(new Passenger("Passengers:", 10));

        // Act
        travelPackage.printPassengerList();

        // Assert that nothing has changed
        assertEquals("Name", travelPackage.getName());
        assertEquals(1, travelPackage.getPassengerCapacity());
    }

}
