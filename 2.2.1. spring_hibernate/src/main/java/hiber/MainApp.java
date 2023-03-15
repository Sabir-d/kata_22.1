package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.add(new User("Sabir", "Dadashev", "Sabir_93d@mail.ru", new Car("test", 1235)));
        userService.add(new User("Sabir1", "Dadashev1", "Sabir_93d@mail.ru1", new Car("test", 1235)));
        userService.add(new User("Sabir2", "Dadashev2", "Sabir_93d@mail.ru2", new Car("test", 235)));
        userService.add(new User("Sabir3", "Dadashev3", "Sabir_93d@mail.ru3", new Car("test3", 35)));
        List<User> users = userService.listUsers();
        System.out.println("Все пользователи:");
        users.forEach(user -> System.out.println(user));
        users = userService.listUsersCar("test", 1235);
        System.out.println("Пользователи с машиной Модель:Test серия:1235:");
        users.forEach(user -> System.out.println(user));
        context.close();
    }
}
