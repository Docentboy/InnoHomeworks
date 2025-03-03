package ru.innopolis.attestations.attestation01.model;

import java.time.LocalDateTime;

public class User {
    private String id;
    private LocalDateTime dateAdded;
    private String login;
    private String password;
    private String confirmPassword;
    private String lastName;
    private String firstName;
    private String middleName;
    private Integer age;
    private boolean isWorker;

    public User(String id, LocalDateTime dateAdded, String login, String password, String confirmPassword,
                String lastName, String firstName, String middleName, Integer age, boolean isWorker) {
        this.id = id;
        this.dateAdded = dateAdded;
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
        this.isWorker = isWorker;
    }

    public User() {

    }

    public String getId() { return id; }
    public String toFileString() {
        return String.join("|", id, dateAdded.toString(), login, password, confirmPassword,
                lastName, firstName, middleName != null ? middleName : "",
                age != null ? age.toString() : "", String.valueOf(isWorker));
    }

    public static User fromFileString(String line) {
        String[] parts = line.split("\\|");
        return new User(
                parts[0], LocalDateTime.parse(parts[1]), parts[2], parts[3], parts[4],
                parts[5], parts[6], parts[7].isEmpty() ? null : parts[7],
                parts[8].isEmpty() ? null : Integer.parseInt(parts[8]),
                Boolean.parseBoolean(parts[9])
        );
    }
}
