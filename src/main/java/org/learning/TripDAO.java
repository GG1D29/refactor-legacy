package org.learning;

import java.util.List;

public class TripDAO {

    public static List<Trip> findTripsByUser(User user) {
        throw new CollaboratorException("TripDAO should not be invoked on a unit test");
    }

    public List<Trip> findTripsBy(User user) {
        return findTripsByUser(user);
    }
}
