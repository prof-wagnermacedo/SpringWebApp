package primavera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import primavera.dao.CarDao;
import primavera.domain.Car;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarDao carDao;

    @RequestMapping("/list")
    public void carList(Model model) {
        List<Car> carList = carDao.findAll();
        model.addAttribute("carList", carList);
    }

    @RequestMapping("/add")
    public void carAdd(@ModelAttribute("car") Car car) {
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String carAdd(@ModelAttribute("car") @Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            // mostra o formulário novamente, com os erros
            return "/car/add";
        }

        // validação bem sucedida
        carDao.add(car);
        return "redirect:/car/list";
    }

    @RequestMapping("/edit/{id}")
    public String carEdit(@PathVariable("id") Long id, Model model) {
        Car car = carDao.get(id);
        model.addAttribute("car", car);

        return "/car/add";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String carEdit(@ModelAttribute("car") @Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            // mostra o formulário novamente, com os erros
            return "/car/add";
        }

        // validação bem sucedida
        carDao.edit(car);
        return "redirect:/car/list";
    }
}
