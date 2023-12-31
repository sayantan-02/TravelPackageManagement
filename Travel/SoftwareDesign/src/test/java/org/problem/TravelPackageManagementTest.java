package org.problem;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TravelPackageManagementTest {
    /**
     * Method under test:
     * {@link TravelPackageManagement#addTravelPackage(TravelPackage)}
     */
    @Test
    void testAddTravelPackage() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();

        // Act
        travelPackageManagement.addTravelPackage(new TravelPackage("Name", 1, new ArrayList<>()));

        // Assert
        assertNull(travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test: {@link TravelPackageManagement#getTravelPackage(String)}
     */
    @Test
    void testGetTravelPackage() {
        // Arrange, Act and Assert
        assertNull((new TravelPackageManagement()).getTravelPackage("java.text"));
    }

    /**
     * Method under test: {@link TravelPackageManagement#getTravelPackage(String)}
     */
    @Test
    void testGetTravelPackage2() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        TravelPackage travelPackage = new TravelPackage("java.text", 1, new ArrayList<>());

        travelPackageManagement.addTravelPackage(travelPackage);

        // Act and Assert
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }


    /**
     * Method under test:
     * {@link TravelPackageManagement#printAvailableActivities(String)}
     */
    @Test
    void testPrintAvailableActivities() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();

        // Act
        travelPackageManagement.printAvailableActivities("java.text");

        // Assert that nothing has changed
        assertNull(travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printAvailableActivities(String)}
     */
    @Test
    void testPrintAvailableActivities2() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(new TravelPackage("Travel package not found.", 1, new ArrayList<>()));

        // Act
        travelPackageManagement.printAvailableActivities("java.text");

        // Assert that nothing has changed
        assertNull(travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printAvailableActivities(String)}
     */
    @Test
    void testPrintAvailableActivities3() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        TravelPackage travelPackage = new TravelPackage("java.text", 1, new ArrayList<>());

        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printAvailableActivities("java.text");

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printAvailableActivities(String)}
     */
    @Test
    void testPrintAvailableActivities4() {
        // Arrange
        ArrayList<Destination> itinerary = new ArrayList<>();
        itinerary.add(new Destination("java.text", new ArrayList<>()));
        TravelPackage travelPackage = new TravelPackage("java.text", 1, itinerary);

        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printAvailableActivities("java.text");

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printAvailableActivities(String)}
     */
    @Test
    void testPrintAvailableActivities5() {
        // Arrange
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("java.text", "The characteristics of someone or something", 10.0d, 3,
                new Destination("java.text", new ArrayList<>())));
        Destination destination = new Destination("java.text", activities);

        ArrayList<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination);
        TravelPackage travelPackage = new TravelPackage("java.text", 1, itinerary);

        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printAvailableActivities("java.text");

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printAvailableActivities(String)}
     */
    @Test
    void testPrintAvailableActivities6() {
        // Arrange
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("java.text", "The characteristics of someone or something", 10.0d, 0,
                new Destination("java.text", new ArrayList<>())));
        Destination destination = new Destination("java.text", activities);

        ArrayList<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination);
        TravelPackage travelPackage = new TravelPackage("java.text", 1, itinerary);

        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printAvailableActivities("java.text");

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test: {@link TravelPackageManagement#printItinerary(String)}
     */
    @Test
    void testPrintItinerary() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();

        // Act
        travelPackageManagement.printItinerary("java.text");

        // Assert that nothing has changed
        assertNull(travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test: {@link TravelPackageManagement#printItinerary(String)}
     */
    @Test
    void testPrintItinerary2() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(new TravelPackage("Travel package not found.", 1, new ArrayList<>()));

        // Act
        travelPackageManagement.printItinerary("java.text");

        // Assert that nothing has changed
        assertNull(travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test: {@link TravelPackageManagement#printItinerary(String)}
     */
    @Test
    void testPrintItinerary3() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        TravelPackage travelPackage = new TravelPackage("java.text", 1, new ArrayList<>());

        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printItinerary("java.text");

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test: {@link TravelPackageManagement#printItinerary(String)}
     */
    @Test
    void testPrintItinerary4() {
        // Arrange
        ArrayList<Destination> itinerary = new ArrayList<>();
        itinerary.add(new Destination("java.text", new ArrayList<>()));
        TravelPackage travelPackage = new TravelPackage("java.text", 1, itinerary);

        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printItinerary("java.text");

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test: {@link TravelPackageManagement#printItinerary(String)}
     */
    @Test
    void testPrintItinerary5() {
        // Arrange
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("java.text", "The characteristics of someone or something", 10.0d, 3,
                new Destination("java.text", new ArrayList<>())));
        Destination destination = new Destination("java.text", activities);

        ArrayList<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination);
        TravelPackage travelPackage = new TravelPackage("java.text", 1, itinerary);

        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printItinerary("java.text");

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printPassengerDetails(String, int)}
     */
    @Test
    void testPrintPassengerDetails() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();

        // Act
        travelPackageManagement.printPassengerDetails("java.text", 10);

        // Assert that nothing has changed
        assertNull(travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printPassengerDetails(String, int)}
     */
    @Test
    void testPrintPassengerDetails2() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(new TravelPackage("Travel package not found.", 1, new ArrayList<>()));

        // Act
        travelPackageManagement.printPassengerDetails("java.text", 10);

        // Assert that nothing has changed
        assertNull(travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printPassengerDetails(String, int)}
     */
    @Test
    void testPrintPassengerDetails3() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        TravelPackage travelPackage = new TravelPackage("java.text", 1, new ArrayList<>());

        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printPassengerDetails("java.text", 10);

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printPassengerDetails(String, int)}
     */
    @Test
    void testPrintPassengerDetails4() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("java.text", 1, new ArrayList<>());
        travelPackage.addPassenger(new Passenger("java.text", 10));

        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printPassengerDetails("java.text", 10);

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printPassengerDetails(String, int)}
     */
    @Test
    void testPrintPassengerDetails5() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("java.text", 1, new ArrayList<>());
        travelPackage.addPassenger(new Passenger("java.text", 1));

        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printPassengerDetails("java.text", 10);

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printPassengerDetails(String, int)}
     */
    @Test
    void testPrintPassengerDetails6() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("java.text", 1, new ArrayList<>());
        travelPackage.addPassenger(new GoldPassenger("java.text", 10, 10.0d));

        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printPassengerDetails("java.text", 10);

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printPassengerDetails(String, int)}
     */
    @Test
    void testPrintPassengerDetails7() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("java.text", 1, new ArrayList<>());
        travelPackage.addPassenger(new StandardPassenger("java.text", 10, 10.0d));

        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printPassengerDetails("java.text", 10);

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printPassengerDetails(String, int)}
     */
    @Test
    void testPrintPassengerDetails8() {
        // Arrange
        Passenger passenger = new Passenger("java.text", 10);
        passenger.addActivity(new Activity("java.text", "The characteristics of someone or something", 10.0d, 3,
                new Destination("java.text", new ArrayList<>())));

        TravelPackage travelPackage = new TravelPackage("java.text", 1, new ArrayList<>());
        travelPackage.addPassenger(passenger);

        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printPassengerDetails("java.text", 10);

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printPassengerDetails(String, int)}
     */
    @Test
    void testPrintPassengerDetails9() {
        // Arrange
        GoldPassenger passenger = new GoldPassenger("java.text", 10, 10.0d);
        passenger.addActivity(new Activity("java.text", "The characteristics of someone or something", 10.0d, 3,
                new Destination("java.text", new ArrayList<>())));

        TravelPackage travelPackage = new TravelPackage("java.text", 1, new ArrayList<>());
        travelPackage.addPassenger(passenger);

        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printPassengerDetails("java.text", 10);

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#printPassengerDetails(String, int)}
     */
    @Test
    void testPrintPassengerDetails10() {
        // Arrange
        StandardPassenger passenger = new StandardPassenger("java.text", 10, 10.0d);
        passenger.addActivity(new Activity("java.text", "The characteristics of someone or something", 10.0d, 3,
                new Destination("java.text", new ArrayList<>())));

        TravelPackage travelPackage = new TravelPackage("java.text", 1, new ArrayList<>());
        travelPackage.addPassenger(passenger);

        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printPassengerDetails("java.text", 10);

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test: {@link TravelPackageManagement#printPassengerList(String)}
     */
    @Test
    void testPrintPassengerList() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();

        // Act
        travelPackageManagement.printPassengerList("java.text");

        // Assert that nothing has changed
        assertNull(travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test: {@link TravelPackageManagement#printPassengerList(String)}
     */
    @Test
    void testPrintPassengerList2() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(new TravelPackage("Travel package not found.", 1, new ArrayList<>()));

        // Act
        travelPackageManagement.printPassengerList("java.text");

        // Assert that nothing has changed
        assertNull(travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test: {@link TravelPackageManagement#printPassengerList(String)}
     */
    @Test
    void testPrintPassengerList3() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        TravelPackage travelPackage = new TravelPackage("java.text", 1, new ArrayList<>());

        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printPassengerList("java.text");

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test: {@link TravelPackageManagement#printPassengerList(String)}
     */
    @Test
    void testPrintPassengerList4() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("java.text", 1, new ArrayList<>());
        travelPackage.addPassenger(new Passenger("java.text", 10));

        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();
        travelPackageManagement.addTravelPackage(travelPackage);

        // Act
        travelPackageManagement.printPassengerList("java.text");

        // Assert that nothing has changed
        assertSame(travelPackage, travelPackageManagement.getTravelPackage("java.text"));
    }

    /**
     * Method under test:
     * {@link TravelPackageManagement#removeTravelPackage(TravelPackage)}
     */
    @Test
    void testRemoveTravelPackage() {
        // Arrange
        TravelPackageManagement travelPackageManagement = new TravelPackageManagement();

        // Act
        travelPackageManagement.removeTravelPackage(new TravelPackage("Name", 1, new ArrayList<>()));

        // Assert
        assertNull(travelPackageManagement.getTravelPackage("java.text"));
    }
}
