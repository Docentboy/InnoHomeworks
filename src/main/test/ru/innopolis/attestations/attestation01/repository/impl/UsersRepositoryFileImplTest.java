package ru.innopolis.attestations.attestation01.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.innopolis.attestations.attestation01.model.User;
import ru.innopolis.attestations.attestation01.repository.UsersRepository;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryFileImplTest {
    private UsersRepository repository;

    @BeforeEach
    void setUp() {
        repository = new UsersRepositoryFileImpl();
        repository.deleteAll(); // Очистка перед тестами
    }

    @Test
    void testCreateAndFindById() {
        User user = new User(UUID.randomUUID().toString(), LocalDateTime.now(),
                "user_test", "pass_123", "pass_123", "Иванов", "Иван", null, 28, true);
        repository.create(user);
        assertNotNull(repository.findById(user.getId()));
    }

    @Test
    void testDeleteById() {
        User user = new User(UUID.randomUUID().toString(), LocalDateTime.now(),
                "user_test", "pass_123", "pass_123", "Иванов", "Иван", null, 28, true);
        repository.create(user);
        repository.deleteById(user.getId());
        assertThrows(NoSuchElementException.class, () -> repository.findById(user.getId()));
    }

    @Test
    void testFindAll() {
        User user1 = new User(UUID.randomUUID().toString(), LocalDateTime.now(),
                "user1", "pass1", "pass1", "Петров", "Петр", null, 30, false);
        User user2 = new User(UUID.randomUUID().toString(), LocalDateTime.now(),
                "user2", "pass2", "pass2", "Сидоров", "Алексей", null, 25, true);
        repository.create(user1);
        repository.create(user2);
        assertEquals(2, repository.findAll().size());
    }

    @Test
    void testUpdate() {
        User user = new User(UUID.randomUUID().toString(), LocalDateTime.now(),
                "user_old", "pass_old", "pass_old", "Смирнов", "Олег", null, 40, false);
        repository.create(user);
        User updatedUser = new User(user.getId(), LocalDateTime.now(),
                "user_new", "pass_new", "pass_new", "Смирнов", "Олег", null, 42, true);
        repository.update(updatedUser);
        assertEquals("user_new", repository.findById(user.getId()).toFileString().split("\\|")[2]);
    }
}