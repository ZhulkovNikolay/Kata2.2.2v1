package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarsController {

    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null) {
            model.addAttribute("cars", carService.getAllCars()); //При запросе /cars выводить весь список.
        } else
            model.addAttribute("cars", carService.getCars(count));


        return "cars";
    }

}
