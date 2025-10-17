package com.psii.appfiliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.psii.appfiliacao.model.Pai;
import com.psii.appfiliacao.service.PaiService;

@Controller
@RequestMapping("/pais")
public class PaiController {

    @Autowired
    private PaiService paiService;

    @GetMapping
    public String listarPai(Model model) {
        List<Pai> pai = paiService.listarPai();
        model.addAttribute("pai", pai);
        return "lista-pais";
    }

    @GetMapping("/novo")
    public String novoPai(Model model) {
        model.addAttribute("pai", new Pai());
        return "formulario_pai";
    }

    @PostMapping // ← Corrigido aqui!
    public String salvarPai(@ModelAttribute Pai pai) {
        paiService.salvarPai(pai);
        return "redirect:/pais";
    }

    @GetMapping("/{id}/editar")
    public String editarPai(@PathVariable Long id, Model model) {
        Pai pai = paiService.buscarPai(id);
        model.addAttribute("pai", pai);
        return "formulario_pai";
    }

    @GetMapping("/{id}/deletar")
    public String deletarPai(@PathVariable Long id) {
        paiService.deletarPai(id);
        return "redirect:/pais";
    }
}



