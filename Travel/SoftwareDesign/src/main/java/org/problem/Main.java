// Design, implement a software system that allows travel agencies to maintain their travel packages' itinerary and passengers.
package org.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class for managing travel packages, including adding, removing, and printing details.
 */
class TravelPackageManagement {
    private List<TravelPackage> travelPackages;

    /**
     * Initializes the TravelPackageManagement with an empty list of travel packages.
     */
    public TravelPackageManagement() {
        this.travelPackages = new ArrayList<>();
    }

    /**
     * Adds a travel package to the list.
     *
     * @param travelPackage The travel package to be added.
     */
    public void addTravelPackage(TravelPackage travelPackage) {
        travelPackages.add(travelPackage);
    }
    /**
     * Removes a travel package from the list.
     *
     * @param travelPackage The travel package to be removed.
     */
    public void removeTravelPackage(TravelPackage travelPackage) {
        travelPackages.remove(travelPackage);
    }

    /**
     * Retrieves a travel package by its name.
     *
     * @param packageName The name of the travel package to be retrieved.
     * @return The travel package with the specified name, or null if not found.
     */
    public TravelPackage getTravelPackage(String packageName) {
        for (TravelPackage travelPackage : travelPackages) {
            if (travelPackage.getName().equals(packageName)) {
                return travelPackage;
            }
        }
        return null;
    }

    /**
     * Prints the itinerary of a travel package, including destinations and activities.
     *
     * @param packageName The name of the travel package.
     */
    public void printItinerary(String packageName) {
        TravelPackage travelPackage = getTravelPackage(packageName);
        if (travelPackage != null) {
            travelPackage.printItinerary();
        } else {
            System.out.println("Travel package not found.");
        }
    }
    /**
     * Prints the passenger list of a travel package, including package details and passenger information.
     *
     * @param packageName The name of the travel package.
     */
    public void printPassengerList(String packageName) {
        TravelPackage travelPackage = getTravelPackage(packageName);
        if (travelPackage != null) {
            travelPackage.printPassengerList();
        } else {
            System.out.println("Travel package not found.");
        }
    }

    /**
     * Prints the details of an individual passenger, including activities they have signed up for.
     *
     * @param packageName   The name of the travel package.
     * @param passengerNumber The number of the passenger.
     */
    public void printPassengerDetails(String packageName, int passengerNumber) {
        TravelPackage travelPackage = getTravelPackage(packageName);
        if (travelPackage != null) {
            travelPackage.printPassengerDetails(passengerNumber);
        } else {
            System.out.println("Travel package not found.");
        }
    }

    /**
     * Prints details of all activities that still have spaces available.
     *
     * @param packageName The name of the travel package.
     */
    public void printAvailableActivities(String packageName) {
        TravelPackage travelPackage = getTravelPackage(packageName);
        if (travelPackage != null) {
            travelPackage.printAvailableActivities();
        } else {
            System.out.println("Travel package not found.");
        }
    }
}

/**
 * Represents a travel package with a name, passenger capacity, itinerary, and list of passengers.
 */
class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    /**
     * Initializes a travel package with the given parameters.
     *
     * @param name             The name of the travel package.
     * @param passengerCapacity The passenger capacity of the travel package.
     * @param itinerary        The list of destinations in the itinerary.
     */
    public TravelPackage(String name, int passengerCapacity, List<Destination> itinerary) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = itinerary;
        this.passengers = new ArrayList<>();
    }

    /**
     * Gets the name of the travel package.
     *
     * @return The name of the travel package.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the passenger capacity of the travel package.
     *
     * @return The passenger capacity.
     */
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * Adds a passenger to the travel package.
     *
     * @param passenger The passenger to be added.
     */
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    /**
     * Removes a passenger from the travel package.
     *
     * @param passenger The passenger to be removed.
     */
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }

    /**
     * Retrieves a passenger by their number.
     *
     * @param passengerNumber The number of the passenger to be retrieved.
     * @return The passenger with the specified number, or null if not found.
     */
    public Passenger getPassenger(int passengerNumber) {
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerNumber() == passengerNumber) {
                return passenger;
            }
        }
        return null;
    }

    /**
     * Prints the itinerary of the travel package, including destinations and activities.
     */
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            System.out.println("Activities:");
            for (Activity activity : destination.getActivities()) {
                System.out.println("Name: " + activity.getName());
                System.out.println("Cost: " + activity.getCost());
                System.out.println("Capacity: " + activity.getCapacity());
                System.out.println("Description: " + activity.getDescription());
            }
        }
    }

    /**
     * Prints the passenger list of the travel package, including package details and passenger information.
     */
    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers: " + passengers.size());
        System.out.println("Passengers:");
        for (Passenger passenger : passengers) {
            System.out.println("Name: " + passenger.getName());
            System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        }
    }

    /**
     * Prints the details of an individual passenger, including activities they have signed up for.
     *
     * @param passengerNumber The number of the passenger.
     */
    public void printPassengerDetails(int passengerNumber) {
        Passenger passenger = getPassenger(passengerNumber);
        if (passenger != null) {
            System.out.println("Name: " + passenger.getName());
            System.out.println("Passenger Number: " + passenger.getPassengerNumber());
            if (passenger instanceof StandardPassenger) {
                System.out.println("Balance: " + ((StandardPassenger) passenger).getBalance());
            }
            else if(passenger instanceof GoldPassenger) {
                System.out.println("Balance: " + ((GoldPassenger) passenger).getBalance());
            }
            else{
                System.out.println("Premium Passenger has no balance!");
            }
            System.out.println("Activities:");
            for (Activity activity : passenger.getActivities()) {
                System.out.println("Activity: " + activity.getName());
                System.out.println("Destination: " + activity.getDestination().getName());
                if (passenger instanceof StandardPassenger) {
                    System.out.println("Price: " + activity.getCost());
                }
                else if(passenger instanceof GoldPassenger) {
                    System.out.println("Price: " + (activity.getCost() - (activity.getCost() * 0.1)));
                }
                else{
                    System.out.println("Premium Passenger doesn't have to pay!");
                }
            }
        } else {
            System.out.println("Passenger not found.");
        }
    }

    /**
     * Prints details of all activities that still have spaces available.
     */
    public void printAvailableActivities() {
        System.out.println("Travel Package: " + name);
        System.out.println("Available Activities:");
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                if (activity.getCapacity() > activity.getPassengers().size()) {
                    System.out.println("Activity: " + activity.getName());
                    System.out.println("Destination: " + destination.getName());
                    System.out.println("Spaces Available: " + (activity.getCapacity() - activity.getPassengers().size()));
                }
            }
        }
    }
}

/**
 * Represents a destination with a name and a list of activities.
 */
class Destination {
    private String name;
    private List<Activity> activities;

    /**
     * Initializes a destination with the given parameters.
     *
     * @param name      The name of the destination.
     * @param activities The list of activities available at the destination.
     */
    public Destination(String name, List<Activity> activities) {
        this.name = name;
        this.activities = activities;
    }

    /**
     * Gets the name of the destination.
     *
     * @return The name of the destination.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of activities available at the destination.
     *
     * @return The list of activities.
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * Adds an activity to the destination.
     *
     * @param activity The activity to be added.
     */
    public void addActivity(Activity activity) {
        if(name.equals(activity.getDestination().getName())){ //Point No. 3
            activities.add(activity);
        }
        else{
            System.out.println("Cannot add the same activity to multiple destination!");
            System.exit(0);
        }
    }

    /**
     * Removes an activity from the destination.
     *
     * @param activity The activity to be removed.
     */
    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * Retrieves an activity by its name.
     *
     * @param activityName The name of the activity to be retrieved.
     * @return The activity with the specified name, or null if not found.
     */
    public Activity getActivity(String activityName) {
        for (Activity activity : activities) {
            if (activity.getName().equals(activityName)) {
                return activity;
            }
        }
        return null;
    }
}

/**
 * Represents an activity with a name, description, cost, capacity, destination, and list of passengers.
 */
class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;
    private List<Passenger> passengers;

    /**
     * Initializes an activity with the given parameters.
     *
     * @param name        The name of the activity.
     * @param description The description of the activity.
     * @param cost        The cost of the activity.
     * @param capacity    The capacity of the activity.
     * @param destination The destination where the activity takes place.
     */
    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.passengers = new ArrayList<>();
    }

    /**
     * Gets the name of the activity.
     *
     * @return The name of the activity.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the activity.
     *
     * @return The description of the activity.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the cost for the activity.
     *
     * @return The  cost for the activity.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Gets the capacity for the activity.
     *
     * @return The capacity for the activity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the Destination for the activity.
     *
     * @return The  destination for the activity.
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * Adds a passenger to the activity.
     *
     * @param passenger The passenger to be added.
     */
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    /**
     * Removes a passenger from the activity.
     *
     * @param passenger The passenger to be removed.
     */
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }


    /**
     * Gets the list of passengers signed up for the activity.
     *
     * @return The list of passengers.
     */
    public List<Passenger> getPassengers() {
        return passengers;
    }
}

/**
 * Represents a passenger with a name, passenger number, and a list of activities they have signed up for.
 */
class Passenger {
    private String name;
    private int passengerNumber;
    private List<Activity> activities;

    /**
     * Initializes a passenger with the given parameters.
     *
     * @param name            The name of the passenger.
     * @param passengerNumber The number of the passenger.
     */
    public Passenger(String name, int passengerNumber) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.activities = new ArrayList<>();
    }

    /**
     * Gets the name of the passenger.
     *
     * @return The name of the passenger.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the passenger number.
     *
     * @return The passenger number.
     */
    public int getPassengerNumber() {
        return passengerNumber;
    }

    /**
     * Adds an activity to the list of activities the passenger has signed up for.
     *
     * @param activity The activity to be added.
     */
    public void addActivity(Activity activity) {
        if(activity.getCapacity() > activity.getPassengers().size()){ //Point no. 5
            activities.add(activity);
        }
        else{
            System.out.println("Activity is Full!");
            System.exit(0);
        }
    }

    /**
     * Removes an activity from the list of activities the passenger has signed up for.
     *
     * @param activity The activity to be removed.
     */
    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * Retrieves an activity by its name.
     *
     * @param activityName The name of the activity to be retrieved.
     * @return The activity with the specified name, or null if not found.
     */
    public Activity getActivity(String activityName) {
        for (Activity activity : activities) {
            if (activity.getName().equals(activityName)) {
                return activity;
            }
        }
        return null;
    }

    /**
     * Gets the list of activities the passenger has signed up for.
     *
     * @return The list of activities.
     */
    public List<Activity> getActivities() {
        return activities;
    }
}

/**
 * Represents a standard passenger with a balance for activity payments.
 */
class StandardPassenger extends Passenger {
    private double balance;

    /**
     * Initializes a standard passenger with the given parameters.
     *
     * @param name            The name of the passenger.
     * @param passengerNumber The number of the passenger.
     * @param balance         The balance for activity payments.
     */
    public StandardPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber);
        this.balance = balance;
    }

    /**
     * Gets the balance for activity payments.
     *
     * @return The balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deducts a specified amount from the balance.
     *
     * @param amount The amount to be deducted.
     */
    public void deductBalance(double amount) {
        balance -= amount;
    }

    /**
     * Checks if the passenger has sufficient balance for activity payments.
     *
     * @return true if the balance is greater than zero, false otherwise.
     */
    public boolean hasSufficientBalance(){
        if(balance == 0){
            return false;
        }
        return true;
    }
}

/**
 * Represents a gold passenger with a balance and a discount on activity payments.
 */
class GoldPassenger extends Passenger {
    private double balance;

    /**
     * Initializes a gold passenger with the given parameters.
     *
     * @param name            The name of the passenger.
     * @param passengerNumber The number of the passenger.
     * @param balance         The balance for activity payments.
     */
    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber);
        this.balance = balance;
    }

    /**
     * Gets the balance for activity payments.
     *
     * @return The balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deducts a discounted amount from the balance based on a 10% discount.
     *
     * @param amount The original amount to be deducted.
     */
    public void deductBalance(double amount) {
        balance -= amount * 0.9;
    }

    /**
     * Checks if the gold passenger has sufficient balance for activity payments.
     *
     * @return true if the balance is greater than zero, false otherwise.
     */
    public boolean hasSufficientBalance(){
        if(balance == 0){
            return false;
        }
        return true;
    }
}

/**
 * Represents a premium passenger with no specific restrictions (attributes).
 */
class PremiumPassenger extends Passenger {
    public PremiumPassenger(String name, int passengerNumber) {
        super(name, passengerNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create travel packages, destinations, activities, and passengers
        Destination destination1 = new Destination("Destination 1", new ArrayList<>());
        Destination destination2 = new Destination("Destination 2", new ArrayList<>());

        Activity activity1 = new Activity("Activity 1", "Description 1", 100.0, 10, destination1);
        Activity activity2 = new Activity("Activity 2", "Description 2", 200.0, 20, destination1);
        Activity activity3 = new Activity("Activity 3", "Description 3", 300.0, 30, destination2);
        Activity activity4 = new Activity("Activity 4", "Description 4", 400.0, 40, destination2);

        destination1.addActivity(activity1);
        destination1.addActivity(activity2);
        // destination2.addActivity(activity2);
        destination2.addActivity(activity3);
        destination2.addActivity(activity4);

        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination1);
        itinerary.add(destination2);

        TravelPackage travelPackage = new TravelPackage("Travel Package 1", 100, itinerary);

        Passenger passenger1 = new StandardPassenger("Passenger 1", 1, 1000.0);
        Passenger passenger2 = new GoldPassenger("Passenger 2", 2, 2000.0);
        Passenger passenger3 = new PremiumPassenger("Passenger 3", 3);

        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage.addPassenger(passenger3);

        passenger1.addActivity(activity1);
        passenger1.addActivity(activity3);

        passenger2.addActivity(activity2);
        passenger2.addActivity(activity4);

        // Create travel package management system
        TravelPackageManagement management = new TravelPackageManagement();
        management.addTravelPackage(travelPackage);

        // Test the functionality of the travel package management system
        management.printItinerary("Travel Package 1");
        management.printPassengerList("Travel Package 1");
        management.printPassengerDetails("Travel Package 1", 1);
        management.printAvailableActivities("Travel Package 1");
    }
}

