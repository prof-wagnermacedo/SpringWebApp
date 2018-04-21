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
public class CarController {
    @Autowired
    private CarDao carDao;

    @RequestMapping("/car/list")
    public void carList(Model model) {
        List<Car> carList = carDao.findAll();
        model.addAttribute("carList", carList);
    }

    @RequestMapping("/car/add")
    public void carAdd(@ModelAttribute("car") Car car) {
    }

    @RequestMapping(value = "/car/add", method = RequestMethod.POST)
    public String carAdd(@ModelAttribute("car") @Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            // mostra o formulário novamente, com os erros
            return "/car/add";
        }

        // validação bem sucedida
        carDao.add(car);
        return "redirect:/car/list";
    }

    @RequestMapping("/car/edit/{id}")
    public String carEdit(@PathVariable("id") Long id, Model model) {
        Car car = carDao.get(id);
        model.addAttribute("car", car);

        return "/car/add";
    }
}
