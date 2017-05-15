package com.sitejournal.controllers;


import com.sitejournal.data.Employee;
import com.sitejournal.services.AdminService;
import com.sitejournal.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String showEmployeePage() {
        return "employee";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee newEmployee, Model model) {
        employeeService.saveEmployee(newEmployee);
        model.addAttribute("newEmployee", newEmployee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String showEmployeesList(Model model) {
        getEmployees(model);
        return "view-employees";
    }

    private void getEmployees(Model model) {
        List<Employee> list = employeeService.getEmployees();
        model.addAttribute("employees", list);
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
    public String sendUpdatedEmployee(@ModelAttribute("editEmployee") Employee existingEmployee, Model model){
        employeeService.updateEmployee(existingEmployee);
        model.addAttribute("existingEmployee",existingEmployee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editEmployee(HttpServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        Employee newEmployee = employeeService.findEmployeeById(id);
        ModelAndView model = new ModelAndView("update-employee");
        model.addObject("existingEmployee", newEmployee);
        return model;
    }

//    @RequestMapping(value = "/updateEmployee/{employeeId}", method = RequestMethod.GET)
//    public String changeEmployee(@RequestParam long employeeId, @ModelAttribute("changedEmployee") Employee changedEmployee, Model model) {
//         updateEmployee(employeeId,changedEmployee,model);
//        return "redirect:update-employee";
//    }
//
//    public void updateEmployee(long employeeId, Employee changedEmployee, Model model){
//        Employee existingEmployee = null;
//        try {
//            existingEmployee = employeeService.findEmployeeById(employeeId);
//        }catch (NoResultException e){
//            e.printStackTrace();
//        }
//        changedEmployee.setId(existingEmployee.getId());
//        changedEmployee.setFirstName(existingEmployee.getFirstName());
//        changedEmployee.setLastName(existingEmployee.getLastName());
//        changedEmployee.setBirthDate(existingEmployee.getBirthDate());
//        changedEmployee.setEmail(existingEmployee.getEmail());
//        changedEmployee.setSalary(existingEmployee.getSalary());
//        changedEmployee.setJob(existingEmployee.getJob());
//        employeeService.saveEmployee(changedEmployee);
//        model.addAttribute("existingEmployee",changedEmployee);
//    }


    @RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return "redirect:/employees";
    }


}
