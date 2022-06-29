package org.orthologyapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmptyUrlController {


    @RequestMapping("/docs")
    public ModelAndView index () {
        return getModelAndView();
    }

    @RequestMapping("")
    public ModelAndView emptyUrl() {
        return getModelAndView();
    }

    @RequestMapping("/api")
    public ModelAndView onlyApiUrl() {
        return getModelAndView();
    }

    @RequestMapping("/api/ortholog")
    public ModelAndView onlyApiAndOrthologyUrl() {
        return getModelAndView();
    }


    private ModelAndView getModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restapi.html");
        return modelAndView;
    }

}
