package task5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task5.models.CarEntity;
import task5.repositories.CarRepository;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public CarEntity findById(Long id) {
        CarEntity carEntity = (CarEntity) carRepository.getOne(id);
        return carEntity;
    }

    public CarEntity create(CarEntity carEntity) {
        return (CarEntity) carRepository.save(carEntity);
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    public CarEntity update(Long id, CarEntity carEntity) {
        carEntity.setId(id);
        return (CarEntity) carRepository.save(carEntity);
    }

    public Iterable<CarEntity> getAll() {
        return carRepository.findAll();
    }
}
