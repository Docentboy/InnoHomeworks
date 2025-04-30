package ru.innopolis.homeworks.homework09;

import ru.innopolis.homeworks.homework09.model.Garage;
import ru.innopolis.homeworks.homework09.model.car.Car;
import ru.innopolis.homeworks.homework09.model.car.PerformanceCar;
import ru.innopolis.homeworks.homework09.model.car.ShowCar;
import ru.innopolis.homeworks.homework09.model.race.CasualRace;
import ru.innopolis.homeworks.homework09.model.race.Race;

public class Application {
    public static void main(String[] args) {
        // Создаем несколько автомобилей
        PerformanceCar pCar1 = new PerformanceCar("Nissan", "GT-R", 2020, 400, 3, 80, 100);
        pCar1.addAddon("Turbo");
        pCar1.addAddon("Диски 19");

        ShowCar sCar1 = new ShowCar("Ferrari", "458", 2019, 570, 3, 70, 90, 3);
        sCar1.addStars(1);

        Car myCar = new Car("Volkswagen", "Golf3", 1993, 70, 3, 90, 50);

        // Создаем гонку и регистрируем участников
        Race casualRace = new CasualRace(5000, "Highway Route 66", 100000);
        casualRace.addParticipant(pCar1);
        casualRace.addParticipant(sCar1);
        casualRace.addParticipant(myCar);

        // Создаем гараж и паркуем авто
        Garage garage = new Garage();
        garage.parkCar(pCar1);
        garage.parkCar(sCar1);

        // Модифицируем автомобили в гараже
        garage.modifyCar();

        // Печатаем информацию
        System.out.println("=== Участники ===");
        for (Car car : casualRace.getParticipants()) {
            System.out.println(car.toString());
        }

        System.out.println("\n=== Машины в Гараже ===");
        for (Car car : garage.getParkedCars()) {
            System.out.println(car.toString());
        }

    }
}
