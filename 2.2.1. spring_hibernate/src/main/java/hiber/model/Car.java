package hiber.model;

import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Column(name = "model_cars")
    private String model;
    @Column(name = "series_cars")
    private int series;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @OneToOne(mappedBy = "car")
    private User Owner;

    public User getOwner() {
        return Owner;
    }

    @Autowired
    public Car(String model, int series) {

        this.model = model;
        this.series = series;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public Long getCarId() {
        return Id;
    }

    public void setCarId(Long carId) {
        this.Id = carId;
    }

    @Override
    public String toString() {
        return "Car - " +
                "model='" + model + '\'' +
                ", series - " + series +
                ", Id - " + Id +
                ", Owner - " + Owner.toString() +
                '}';
    }
}
