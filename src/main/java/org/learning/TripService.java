package org.learning;

import java.util.ArrayList;
import java.util.List;

public class TripService {
    public List<Trip> getTripsByUser(User user) {

        User loggedInUser = getLoggedInUser();
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
        return TripDAO.findTripsByUser(user);
    }

    User getLoggedInUser() {
        return UserSession.getInstance().getLoggedInUser();
    }
}
