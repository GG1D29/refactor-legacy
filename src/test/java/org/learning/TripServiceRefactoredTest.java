package org.learning;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TripServiceRefactoredTest {
    private static final User GUEST = null;
    private static final User ANY_USER = new User();
    private static final User REGISTERED_USER = new User();
    private static final User ANOTHER_USER = new User();
    private static final Trip LONDON = new Trip();
    private User loggedInUser;

    @Test
    void should_ThrowsException_When_UserNotLoggedIn() {
        TripService tripService = new TestableTripService();
        loggedInUser = GUEST;

        assertThrows(UserNotLoggedInException.class,
                () -> tripService.getTripsByUser(ANY_USER));
    }

    @Test
    void should_ReturnNoTrips_When_UserNotFriends() {
        TripService tripService = new TestableTripService();
        loggedInUser = REGISTERED_USER;

        User stranger = new User();
        stranger.addFriend(ANOTHER_USER);
        stranger.addTrip(LONDON);

        List<Trip> trips = tripService.getTripsByUser(stranger);
        assertThat(trips).isEmpty();
    }

    private class TestableTripService extends TripService {
        @Override
        User getLoggedInUser() {
            return loggedInUser;
        }
    }
}