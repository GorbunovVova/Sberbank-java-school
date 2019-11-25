package task5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task5.models.CarEntity;
import task5.services.CarService;

@RestController
public class Controller {

    @Autowired
    private CarService carService;

    @GetMapping("/{id}")
    public CarEntity get(@PathVariable("id") Long id) {
        return carService.findById(id);
    }

    @PostMapping
    public Iterable<CarEntity> create(@RequestParam String name, @RequestParam double price) {
        CarEntity carEntity = new CarEntity(name, price);
        carService.create(carEntity);
        return carService.getAll();
    }

    @PutMapping("/{id}")
    public Iterable<CarEntity> update(@RequestBody CarEntity carEntity, @PathVariable("id") Long id){
        carService.update(id, carEntity);
        return carService.getAll();
    }

    @GetMapping
    public Iterable<CarEntity> main() {
        return carService.getAll();
    }

    @DeleteMapping("/{id}")
    public Iterable<CarEntity> delete(@PathVariable("id") Long id){
        carService.deleteById(id);
        return carService.getAll();
    }
}
