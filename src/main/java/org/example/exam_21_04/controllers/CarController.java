package org.example.exam_21_04.controllers;

import org.example.exam_21_04.entity.Car;
import org.example.exam_21_04.repository.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Car> cars = carRepository.findAll();
        model.addAttribute("listCars", cars);
        return "list";
    }

    @GetMapping("/add")
    public String showNewCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "form";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute("car") Car car) {
        carRepository.save(car);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        Car car = carRepository.findById(id).orElse(null);
        if (car != null) {
            model.addAttribute("car", car);
            return "form";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchCars(@RequestParam String keyword, Model model) {
        List<Car> cars = carRepository.findByBrand(keyword);
        model.addAttribute("listCars", cars);
        return "list";
    }

    @GetMapping("/filter")
    public String filterCars(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Double min,
            @RequestParam(required = false) Double max,
            Model model) {

        List<Car> cars;

        if (year != null && min != null && max != null) {
            cars = carRepository.findByYearGreaterThanEqualAndPriceBetween(year, min, max);
        } else if (year != null && min != null) {
            cars = carRepository.findByYearGreaterThanEqual(year)
                    .stream()
                    .filter(car -> car.getPrice() >= min)
                    .toList();
        } else if (year != null && max != null) {
            cars = carRepository.findByYearGreaterThanEqual(year)
                    .stream()
                    .filter(car -> car.getPrice() <= max)
                    .toList();
        } else if (min != null && max != null) {
            cars = carRepository.findByPriceBetween(min, max);
        } else if (year != null) {
            cars = carRepository.findByYearGreaterThanEqual(year);
        } else if (min != null) {
            cars = carRepository.findAll()
                    .stream()
                    .filter(car -> car.getPrice() >= min)
                    .toList();
        } else if (max != null) {
            cars = carRepository.findAll()
                    .stream()
                    .filter(car -> car.getPrice() <= max)
                    .toList();
        } else {
            cars = carRepository.findAll();
        }

        model.addAttribute("listCars", cars);
        return "list";
    }
}
