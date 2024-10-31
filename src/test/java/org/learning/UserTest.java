package org.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    private static final User TRISHA = new User();
    private static final User PAUL = new User();

    @Test
    void isFriends_With_AnotherUser() {
        User user = UserBuilder.aUser()
                .friendsWith(TRISHA)
                .build();

        assertFalse(user.isFriendsWith(PAUL));
        assertTrue(user.isFriendsWith(TRISHA));
    }
}