package com.duongtai.syndiary.controllers;

import com.duongtai.syndiary.configs.Snippets;
import com.duongtai.syndiary.entities.Diary;
import com.duongtai.syndiary.services.impl.DiaryServiceImpl;
import com.duongtai.syndiary.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.duongtai.syndiary.configs.MyUserDetail.getUsernameLogin;

@Controller
@RequestMapping("/diary/")
public class DiaryController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private DiaryServiceImpl diaryService;


    @PostMapping("save")
    public ModelAndView save_new (ModelMap model, @ModelAttribute Diary diary){
        if(diary != null){
            diaryService.save_diary(diary);
            return new ModelAndView("redirect:/",model);
        }
        model.addAttribute(diary);
        return new ModelAndView("redirect:/diary/new",model);

    }

    @GetMapping("new")
    public ModelAndView new_diary (ModelMap model, Diary diary){
        model.addAttribute("title", Snippets.NEW_DIARY);
        model.addAttribute("diary",diary);
        return new ModelAndView("/diary/new",model);
    }


}
