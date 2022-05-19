package hiber.service;

import hiber.dao.UserDao;
import hiber.dao.UserDaoImp;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void addCar(Car car) {
        userDao.addCar(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars() {
        return userDao.listCars();
    }

    @Override
    public User getCarFromModelsAndSeries(String model, int series) {

        try (Session session = userDao.getSession();) {
            String HQL = "FROM Car car WHERE car.model=:modelCar and  car.series=:seriesCar";
            Car car = session.createQuery(HQL, Car.class)
                    .setParameter("modelCar", model)
                    .setParameter("seriesCar", series)
                    .getSingleResult();
            System.out.println(car.getOwner());
            return car.getOwner();
        }

    }
}
