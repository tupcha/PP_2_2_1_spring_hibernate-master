package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.util.List;

public interface UserDao {
    void add(User user);

    void addCar(Car car);

    Session getSession();

    List<User> listUsers();

    List<Car> listCars();
}
