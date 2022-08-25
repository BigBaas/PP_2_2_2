package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;


@Controller
public class CarController {

    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }


    @GetMapping("/cars")
    public String cars(@RequestParam(value = "count", defaultValue = "5") int number, Model model) {
        model.addAttribute("cars", carService.carsCount(number));
        return "cars";

    }
}
