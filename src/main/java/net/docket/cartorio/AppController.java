package net.docket.cartorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	private CartorioService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Cartorio> listCartorio = service.listAll();
		model.addAttribute("listCartorio", listCartorio);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String viewCartorioForm(Model model) {
		Cartorio cartorio = new Cartorio();
		model.addAttribute("cartorio", cartorio);
		
		return "novoCartorio";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCartorio(@ModelAttribute("cartorio") Cartorio cartorio) {
		service.save(cartorio);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView viewEditCartorioForm(@PathVariable(name = "id") Long car_id) {
		ModelAndView mav = new ModelAndView("edit_cartorio");
		
		Cartorio cartorio = service.get(car_id);
		mav.addObject("cartorio", cartorio);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCartorio(@PathVariable(name = "id") Long car_id){
		service.delete(car_id);
		
		return "redirect:/";
	}
}
