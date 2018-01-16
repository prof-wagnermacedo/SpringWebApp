package com.wagnermacedo.controller;

import com.wagnermacedo.domain.Car;
import com.wagnermacedo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/car/list")
    public void carList(Model model) {
        List<Car> carList = carService.findAll();
        model.addAttribute("carList", carList);
    }

    @RequestMapping("/car/add")
    public void carAdd() {
    }

    @RequestMapping(value="/car/add", method=RequestMethod.POST)
    public String carAdd(@ModelAttribute Car car) {
        carService.add(car);
        return "redirect:/car/list";
    }
}
