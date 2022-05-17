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
        userService.add(new User(new Car("BMW",120),"name1","secondName1","mail1"));
        userService.add(new User(new Car("BMW",180),"name2","secondName2","mail2"));
        userService.add(new User(new Car("BMW",320),"name3","secondName3","mail3"));
        userService.add(new User(new Car("BMW",480),"name4","secondName4","mail4"));


        List<User> users = userService.listUsers();

        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("User car model = " + user.getCar().getModel() +
                    "\n" + "User car series = " + user.getCar().getSeries()
                    + "\n" + "User car id = " + user.getCar().getCarId());
            System.out.println("---------- ---------- ---------- --------- ");
        }

        userService.getCarFromModelsAndSeries("BMW", 180);

        context.close();
    }
}
