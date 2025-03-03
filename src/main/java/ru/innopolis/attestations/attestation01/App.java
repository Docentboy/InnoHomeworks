package ru.innopolis.attestations.attestation01;

import ru.innopolis.attestations.attestation01.model.User;
import ru.innopolis.attestations.attestation01.repository.UsersRepository;
import ru.innopolis.attestations.attestation01.repository.impl.UsersRepositoryFileImpl;

import java.time.LocalDateTime;
import java.util.UUID;

public class App {


    public static void main(String[] args) {
        UsersRepository repository = new UsersRepositoryFileImpl();

        User user1 = new User(UUID.randomUUID().toString(), LocalDateTime.now(),
                "user_123", "pass_456", "pass_456", "Иванов", "Иван", "Иванович", 30, true);
        User user2 = new User(UUID.randomUUID().toString(), LocalDateTime.now(),
                "user_456", "pass_789", "pass_789", "Петров", "Петр", null, 25, false);

        repository.create(user1);
        repository.create(user2);

        System.out.println("Все пользователи:");
        repository.findAll().forEach(u -> System.out.println(u.toFileString()));

        System.out.println("Поиск пользователя по ID:");
        System.out.println(repository.findById(user1.getId()).toFileString());

        System.out.println("Обновление пользователя:");
        user1 = new User(user1.getId(), LocalDateTime.now(), "updated_user", "new_pass", "new_pass", "Иванов", "Иван", "Иванович", 35, true);
        repository.update(user1);
        System.out.println(repository.findById(user1.getId()).toFileString());

        System.out.println("Удаление пользователя по ID:");
        repository.deleteById(user2.getId());
        repository.findAll().forEach(u -> System.out.println(u.toFileString()));

        System.out.println("Удаление всех пользователей:");
        repository.deleteAll();
        System.out.println("Оставшиеся пользователи: " + repository.findAll().size());
    }

}
