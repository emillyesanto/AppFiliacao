package com.psii.appfiliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.appfiliacao.model.Pai;
import com.psii.appfiliacao.service.PaiService;

@Controller
@RequestMapping("/pais")
public class PaiController {

    @Autowired
    private PaiService paiService;

    @GetMapping
    public String listaPai(Model model) {
        List<Pai> pai = paiService.listarPai();
        model.addAttribute("pai", pai);
        return "lista-pais";
    }

}
