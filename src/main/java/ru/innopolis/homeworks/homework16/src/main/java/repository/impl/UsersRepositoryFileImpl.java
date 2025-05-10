package repository.impl;


import model.User;
import repository.UsersRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class UsersRepositoryFileImpl implements UsersRepository {

    private static final List<User> USERS = new ArrayList<>();
    private static final String FILE_PATH = "src/main/resources/users.txt";

    @Override
    public void create(User user) {
        USERS.add(user);
        saveUsers();
    }

    private void saveUsers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : USERS) {
                bw.write(user.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(String id) {
        if (USERS.isEmpty()) {
            findAll();
        }
        return USERS.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Пользователь не найден!"));
    }

    @Override
    public List<User> findAll() {
        if (USERS.isEmpty()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                List<User> usersFromFile = reader.lines()
                        .map(line -> new User())
                        .toList();
                USERS.addAll(usersFromFile);

                return USERS;

            } catch (IOException e) {
                System.out.println("Ошибка чтения файла: " + e.getMessage());
                return Collections.emptyList();
            }
        }
        return USERS;
    }

    @Override
    public void update(User user) {
        deleteById(user.getId());
        create(user);
    }

    @Override
    public void deleteById(String id) {
        USERS.removeIf(u -> u.getId().equals(id));
        saveUsers();
    }

    @Override
    public void deleteAll() {
        USERS.clear();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write("");
            writer.flush();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
