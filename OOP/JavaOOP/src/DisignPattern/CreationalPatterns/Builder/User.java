package DisignPattern.CreationalPatterns.Builder;

public class User {

    private String firstName; // required
    private String lastName; // required
    private int age; // optional
    private String phone; // optional
    private String address; // optional

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private User user;

        private UserBuilder() {
            this.user = new User();
        }

        public UserBuilder withAge(int age) {
            this.user.age = age;
            return this;
        }

        public UserBuilder withPhone(String phone) {
            this.user.phone = phone;
            return this;
        }

        public UserBuilder withAddress(String address) {
            this.user.address = address;
            return this;
        }

        public User build() {
            return this.user;
        }
    }
}