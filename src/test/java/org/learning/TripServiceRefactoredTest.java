package org.learning;

import org.junit.jupiter.api.BeforeEach;
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
    private static final Trip BARCELONA = new Trip();
    private User loggedInUser;
    private TripService tripService;

    @BeforeEach
    void setUp() {
        tripService = new TestableTripService();
        loggedInUser = REGISTERED_USER;
    }

    @Test
    void should_ThrowsException_When_UserNotLoggedIn() {
        loggedInUser = GUEST;

        assertThrows(UserNotLoggedInException.class,
                () -> tripService.getTripsByUser(ANY_USER));
    }

    @Test
    void should_ReturnNoTrips_When_UserNotFriends() {

        User stranger = new User();
        stranger.addFriend(ANOTHER_USER);
        stranger.addTrip(LONDON);

        List<Trip> trips = tripService.getTripsByUser(stranger);
        assertThat(trips).isEmpty();
    }

    @Test
    void should_ReturnTrips_When_UserAreFriends() {

        User friend = new User();
        friend.addFriend(ANOTHER_USER);
        friend.addFriend(REGISTERED_USER);
        friend.addTrip(LONDON);
        friend.addTrip(BARCELONA);

        List<Trip> trips = tripService.getTripsByUser(friend);
        assertThat(trips).containsExactlyInAnyOrder(LONDON, BARCELONA);
    }

    private class TestableTripService extends TripService {
        @Override
        User getLoggedInUser() {
            return loggedInUser;
        }

        @Override
        List<Trip> getTripsBy(User user) {
            return user.getTrips();
        }
    }
}