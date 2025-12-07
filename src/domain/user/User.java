package domain.user;

import java.util.Objects;

/*
 * Parent Class to all the roles
*/
public abstract class User {
    public enum Role {
        ADMIN_STAFF,
        ACADEMIC_LEADER,
        LECTURER,
        STUDENT;

        public static Role fromString(String value) {
            if (value == null) return null;
            switch (value.toUpperCase()) {
                case "ADMIN_STAFF":
                    return ADMIN_STAFF;
                case "ACADEMIC_LEADER":
                    return ACADEMIC_LEADER;
                case "LECTURER":
                    return LECTURER;
                case "STUDENT":
                    return STUDENT;
                default:
                    throw new IllegalArgumentException("Unknown role:" + value);
            }
        }
    }

    // Fields
    private String userId;
    private String name;
    private String email;
    private String contactNumber;
    private Role role;
    private String password;

    // Constructors
    public User(
        String name, 
        String email, 
        String contactNumber, 
        Role role, 
        String password
    ) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.role = role;
        this.password = password;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public Role getRole() { return role; }
    public String getEmail() { return email; }
    public String getContactNumber() { return contactNumber; }

    public void setEmail(String newEmail) { this.email = newEmail; }
    public void setContactNumber(String newContactNumber) { this.contactNumber = newContactNumber; }
    public void setRole(Role role) { this.role = role; }
    public void setPassword(String newPassword) { this.password = newPassword; }

    public boolean login(String email, String password) {
        return true;
    }

    public void logout() {

    }

    public void editProfile(String name, String email, String contactNumber) {

    }

    protected boolean validateInput(String input) {
        return true;
    }
}
