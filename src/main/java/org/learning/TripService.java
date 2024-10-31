package org.learning;

import java.util.ArrayList;
import java.util.List;

public class TripService {
    private TripDAO tripDAO;

    public TripService(TripDAO tripDAO) {
        this.tripDAO = tripDAO;
    }

    public List<Trip> getTripsByUser(User user, User loggedInUser) {

        validate(loggedInUser);

        return user.isFriendsWith(loggedInUser)
                ? getTripsBy(user)
                : noTrips();
    }

    private void validate(User loggedInUser) {
        if (loggedInUser == null) {
            throw new UserNotLoggedInException();
        }
    }

    private List<Trip> noTrips() {
        return new ArrayList<>();
    }

    private List<Trip> getTripsBy(User user) {
        return tripDAO.findTripsBy(user);
    }

}
