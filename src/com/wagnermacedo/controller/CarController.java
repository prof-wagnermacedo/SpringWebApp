package com.wagnermacedo.controller;

import com.wagnermacedo.domain.Car;
import com.wagnermacedo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/list")
    public void carList(Model model) {
        List<Car> carList = carService.findAll();
        model.addAttribute("carList", carList);
    }

    @RequestMapping("/add")
    public void carAdd(@ModelAttribute("car") Car car) {
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String carAdd(@ModelAttribute("car") @Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            // mostra o formulário novamente, com os erros
            return "/car/add";
        }

        // validação foi bem sucedida
        carService.add(car);
        return "redirect:/car/list";
    }

    @RequestMapping("/{id}/{field}")
    @ResponseBody
    public String showCarField(@PathVariable("id") Long carId,
                                @PathVariable("field") String field) {
        switch (field) {
            case "name":
                return carService.find(carId).getName();
            case "price":
                return carService.find(carId).getPrice().toString();
        }

        throw new IllegalArgumentException(field);
    }
}
