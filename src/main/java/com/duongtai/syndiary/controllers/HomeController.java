package com.duongtai.syndiary.controllers;

import com.duongtai.syndiary.configs.Snippets;
import com.duongtai.syndiary.entities.User;
import com.duongtai.syndiary.services.impl.StorageServiceImpl;
import com.duongtai.syndiary.services.impl.UserServiceImpl;
import static com.duongtai.syndiary.configs.MyUserDetail.getUsernameLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private StorageServiceImpl storageService;
    
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("")
    public ModelAndView homePage(ModelMap model){
        model.addAttribute(Snippets.TITLE, Snippets.APP_NAME+" "+Snippets.TITLE_HOME_PAGE);
        model.addAttribute("user", userService.getUserByUsername(getUsernameLogin()));
        return new ModelAndView("home",model);
    }
    @GetMapping("authen")
    public ModelAndView createUser (ModelMap model,
                                    @ModelAttribute User user){
        model.addAttribute("user",user);
        model.addAttribute(Snippets.TITLE,Snippets.AUTHENTICATE+" "+Snippets.APP_NAME);
        return new ModelAndView("authen",model);
    }

    @PostMapping("save_user")
    public String save_user(@ModelAttribute User user, ModelMap model){
        if(user != null ){
            if(userService.saveUser(user)!= null){
                System.out.println("New user register: "+user.getUsername());
                return "redirect:/authen?register=true";
            }
        }
        model.addAttribute("user",model);
        return "redirect:/authen?register=false";
    }

    @GetMapping("images/{fileName:.+}")
    public ResponseEntity<byte[]> readFile (@PathVariable String fileName){
        return storageService.readFile(fileName);
    }


}
