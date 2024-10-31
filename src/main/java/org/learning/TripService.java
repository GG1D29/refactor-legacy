package org.learning;

import java.util.ArrayList;
import java.util.List;

public class TripService {
    private TripDAO tripDAO;

    public TripService() {
        this.tripDAO = new TripDAO();
    }

    public TripService(TripDAO tripDAO) {
        this.tripDAO = tripDAO;
    }

    public List<Trip> getTripsByUser(User user, User loggedInUser) {

        if (loggedInUser == null) {
            throw new UserNotLoggedInException();
        }

        return user.isFriendsWith(loggedInUser)
                ? getTripsBy(user)
                : noTrips();
    }

    List<Trip> noTrips() {
        return new ArrayList<>();
    }

    List<Trip> getTripsBy(User user) {
        return tripDAO.findTripsBy(user);
    }

}
