package br.ucsal.lista13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.ucsal.lista13.model.Livro;
import br.ucsal.lista13.repository.LivroRepository;

@Controller
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping("/livros")
	public String listarLivros(Model model) {
		Iterable<Livro> livros = livroRepository.findAll();
		model.addAttribute("livros", livros);
		return "listaLivros";
	}

	@GetMapping("/livros/novo")
	public String exibirFormulario(Model model) {
	    Livro livro = new Livro();
	    model.addAttribute("livro", livro);
	    return "cadastroLivro";
	}

	@PostMapping("/livros")
	public String cadastrarLivro(@ModelAttribute("livro") Livro livro) {
		livroRepository.save(livro);
	    return "redirect:/livros";
	}
	
	@GetMapping("/livros/delete/{id}")
	public String excluirLivro(@PathVariable("id") Long id) {
	    livroRepository.deleteById(id);
	    return "redirect:/livros";
	}

	
}