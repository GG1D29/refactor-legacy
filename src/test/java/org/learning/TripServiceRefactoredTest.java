package org.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TripServiceRefactoredTest {
    @Test
    void should_ThrowsException_When_UserNotLoggedIn() {
        TripService tripService = new TestableTripService();

        assertThrows(UserNotLoggedInException.class, () -> tripService.getTripsByUser(null));
    }

    private class TestableTripService extends TripService {
        @Override
        User getLoggedInUser() {
            return null;
        }
    }
}