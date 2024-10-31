package org.learning;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Trip> trips = new ArrayList<>();
    private List<User> friends = new ArrayList<>();

    public void addFriend(User user) {
        friends.add(user);
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public List<User> getFriends() {
        return friends;
    }

}
