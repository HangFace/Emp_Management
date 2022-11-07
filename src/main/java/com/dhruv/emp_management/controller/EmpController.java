package com.dhruv.emp_management.controller;

import com.dhruv.emp_management.entity.Employee;
import com.dhruv.emp_management.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public String home(Model model) {
        List<Employee> emp = empService.getAllEmployee();
        model.addAttribute("emp", emp);
        return "index";
    }

    @GetMapping("/addemp")
    public String addEmp() {
        return "Add_Emp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee e, HttpSession session) {
        System.out.println(e);
        empService.addEmp(e);
        session.setAttribute("msg", "Employee Added Successfully..!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Employee e = empService.edit(id);
        model.addAttribute("emp", e);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Employee e, HttpSession session){
        empService.addEmp(e);
        session.setAttribute("msg","Employee Data Updated Successfully..!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, HttpSession session){
        empService.delete(id);
        session.setAttribute("msg","Employee Data Deleted Successfully...!");
        return "redirect:/";
    }
}
