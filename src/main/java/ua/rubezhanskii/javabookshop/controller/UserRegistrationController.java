package ua.rubezhanskii.javabookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.rubezhanskii.javabookshop.security.beans.UserRegistrationDto;
import ua.rubezhanskii.javabookshop.security.model.User;
import ua.rubezhanskii.javabookshop.security.service.UserSecurityService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "")
public class UserRegistrationController {

   @Autowired
   private UserSecurityService userSecurityService;


//    @GetMapping(value={"/", "/login"})
//    public ModelAndView login(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }

    @GetMapping(value="/registration")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        UserRegistrationDto user = new UserRegistrationDto();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid UserRegistrationDto userData, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<User> userOptional = userSecurityService.findUserByEmail(userData.getEmail());
        userOptional.ifPresent(u ->  bindingResult.rejectValue("email","error.user","There is already a user registered with the email provided"));
        modelAndView.addObject("user", new UserRegistrationDto());
        System.out.println(userData.toString());
        User createdUser = userSecurityService.saveUser(userData);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
            modelAndView.addObject("user", new UserRegistrationDto());
        } else {

            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new UserRegistrationDto());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }

}
