package org.learning;

import java.util.ArrayList;
import java.util.List;

public class TripService {
    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        List<Trip> trips = new ArrayList<>();
        User loggedInUser = getLoggedInUser();
        boolean isFriend = false;
        if (loggedInUser != null) {
            for (User friend : user.getFriends()) {
                if (friend.equals(loggedInUser)) {
                    isFriend = true;
                    break;
                }
            }

            if (isFriend) {
                trips = TripDAO.findTripsByUser(user);
            }

            return trips;
        } else {
            throw new UserNotLoggedInException();
        }

    }

    User getLoggedInUser() {
        return UserSession.getInstance().getLoggedInUser();
    }
}
