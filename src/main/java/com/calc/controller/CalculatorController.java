package com.calc.controller;

import com.calc.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String showCalculator() {
        return "calculator"; // return the Thymeleaf template
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("num1") double num1,
                            @RequestParam("num2") double num2,
                            @RequestParam("operation") String operation,
                            Model model) {
        double result = 0;

        switch (operation) {
            case "add":
                result = calculatorService.add(num1, num2);
                break;
            case "subtract":
                result = calculatorService.subtract(num1, num2);
                break;
            case "multiply":
                result = calculatorService.multiply(num1, num2);
                break;
            case "divide":
                result = calculatorService.divide(num1, num2);
                break;
        }

        model.addAttribute("result", result);
        return "calculator"; // return the same template to show the result
    }
}