package org.learning;

public class UserBuilder {
    private User[] friends = new User[]{};
    private Trip[] trips = new Trip[]{};

    public static UserBuilder aUser() {
        return new UserBuilder();
    }

    public UserBuilder friendsWith(User... users) {
        this.friends = users;
        return this;
    }

    public UserBuilder withTripsTo(Trip... trips) {
        this.trips = trips;
        return this;
    }

    public User build() {
        User user = new User();
        addFriendsTo(user);
        addTripsTo(user);

        return user;
    }

    private void addFriendsTo(User user) {
        for (User friend : friends) {
            user.addFriend(friend);
        }
    }

    private void addTripsTo(User user) {
        for (Trip trip : trips) {
            user.addTrip(trip);
        }
    }

}
