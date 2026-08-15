package br.com.fiap.springmvc.controller;

import br.com.fiap.springmvc.dto.LivroRequest;
import br.com.fiap.springmvc.model.Genero;
import br.com.fiap.springmvc.model.Livro;
import br.com.fiap.springmvc.service.LivroService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model){
        model.addAttribute("livro", new Livro());
        model.addAttribute("genero", Arrays.asList(Genero.values()));
        return"livroCadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Model model, Livro livro){
        livroService.create(livro);
        return "livroLista";
    }

}
