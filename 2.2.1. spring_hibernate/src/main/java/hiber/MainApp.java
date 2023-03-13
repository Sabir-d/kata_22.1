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
        User user1 = new User("Sabir", "Dadashev", "Sabir_93d@mail.ru");
        user1.setCar(new Car("test", 1235));
        User user2 = new User("Sabir1", "Dadashev1", "Sabir_93d@mail.ru1");
        user2.setCar(new Car("test", 1235));
        User user3 = new User("Sabir2", "Dadashev2", "Sabir_93d@mail.ru2");
        user3.setCar(new Car("test", 235));
        User user4 = new User("Sabir3", "Dadashev3", "Sabir_93d@mail.ru3");
        user4.setCar(new Car("test3", 35));
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        users = userService.listUsersCar("test",1235);
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car.Model = " + user.getCar().getModel());
            System.out.println("Car.Series = " + user.getCar().getSeries());
            System.out.println();
        }

        context.close();
    }
}
