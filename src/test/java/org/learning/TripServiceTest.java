package org.learning;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TripServiceTest {
    private static final User GUEST = null;
    private static final User ANY_USER = new User();
    private static final User REGISTERED_USER = new User();
    private static final User ANOTHER_USER = new User();
    private static final Trip LONDON = new Trip();
    private static final Trip BARCELONA = new Trip();

    @InjectMocks
    private TripService tripService;

    @Mock
    private TripDAO tripDAO;

    @Test
    void should_ThrowsException_When_UserNotLoggedIn() {
        assertThrows(UserNotLoggedInException.class,
                () -> tripService.getTripsByUser(ANY_USER, GUEST));
    }

    @Test
    void should_ReturnNoTrips_When_UserNotFriends() {

        User stranger = UserBuilder.aUser()
                .friendsWith(ANOTHER_USER)
                .withTripsTo(LONDON)
                .build();

        List<Trip> trips = tripService.getTripsByUser(stranger, REGISTERED_USER);
        assertThat(trips).isEmpty();
    }

    @Test
    void should_ReturnTrips_When_UserAreFriends() {
        User friend = UserBuilder.aUser()
                .friendsWith(ANOTHER_USER, REGISTERED_USER)
                .withTripsTo(LONDON, BARCELONA)
                .build();

        given(tripDAO.findTripsBy(friend)).willReturn(friend.getTrips());

        List<Trip> trips = tripService.getTripsByUser(friend, REGISTERED_USER);
        assertThat(trips).containsExactlyInAnyOrder(LONDON, BARCELONA);
    }

}
