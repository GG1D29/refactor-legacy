package org.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TripServiceRefactoredTest {
    private static final User GUEST = null;
    private static final User ANY_USER = new User();
    private User loggedInUser;

    @Test
    void should_ThrowsException_When_UserNotLoggedIn() {
        TripService tripService = new TestableTripService();
        loggedInUser = GUEST;

        assertThrows(UserNotLoggedInException.class,
                () -> tripService.getTripsByUser(ANY_USER));
    }

    private class TestableTripService extends TripService {
        @Override
        User getLoggedInUser() {
            return loggedInUser;
        }
    }
}