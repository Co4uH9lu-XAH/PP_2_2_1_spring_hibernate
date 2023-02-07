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

      userService.add(new User("Wooden", "Worm", "worm@mail.ru", new Car("Ford", 1)));
      userService.add(new User("Sweaty", "Beast", "beast@mail.ru", new Car("ZAZ", 2)));
      userService.add(new User("DobPbIu", "Beatle", "beatle@mail.ru", new Car("RussoBalt", 3)));
      userService.add(new User("Co4UH9IU-XAH", "unknown", "unknown", new Car("Pogonyay-arba", 4)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("User`s model of car = " + user.getCar().getModel());
         System.out.println("User`s series of car = " + user.getCar().getSeries());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println();
      }
      // В ТЗ требования на вывод нет, но на всякий случай
      System.out.println(userService.getUser("Ford", 1));
      context.close();
   }
}
