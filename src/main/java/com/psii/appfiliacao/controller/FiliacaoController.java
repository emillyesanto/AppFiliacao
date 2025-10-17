package com.psii.appfiliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.appfiliacao.model.Filiacao;
import com.psii.appfiliacao.service.FiliacaoService;
import com.psii.appfiliacao.service.MaeService;
import com.psii.appfiliacao.service.PaiService;

@Controller
@RequestMapping("/filiacao")
public class FiliacaoController {

    @Autowired
    private FiliacaoService filiacaoService;

    @Autowired
    private MaeService maeService;

    @Autowired
    private PaiService paiService;

    @GetMapping
    public String listarFiliacao(Model model) {
        List<Filiacao> filiacao = filiacaoService.listarFiliacao();
        model.addAttribute("filiacao", filiacao);
        return "lista_filiacoes";
    }

    @GetMapping("/novo")
    public String novaFiliacao(Model model) {
        model.addAttribute("filiacao", new Filiacao());
        model.addAttribute("mae", maeService.listarMae());
        model.addAttribute("pai", paiService.listarPai());
        return "form_filiacao";
    }

    @PostMapping
    public String salvarFiliacao(@ModelAttribute Filiacao filiacao) {
        filiacaoService.salvarFiliacao(filiacao);
        return "redirect:/filiacao";
    }

    @GetMapping("/{id}/editar")
    public String editarFiliacao(@PathVariable Long id, Model model) {
        Filiacao filiacao = filiacaoService.buscarFiliacao(id);
        model.addAttribute("filiacao", filiacao);
        model.addAttribute("mae", maeService.listarMae());
        model.addAttribute("pai", paiService.listarPai());
        return "form_filiacao";
    }

    @GetMapping("/{id}/deletar")
    public String deletarConsulta(@PathVariable Long id) {
        filiacaoService.deletarFiliacao(id);
        return "redirect:/filiacao";
    }
}
