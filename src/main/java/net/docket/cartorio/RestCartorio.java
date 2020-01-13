package net.docket.cartorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCartorio {
	@Autowired
	private CartorioRepository cartorioRepository;
	
	@GetMapping("/cartorios")
	public List<Cartorio> findAllCartorios() {
		return cartorioRepository.findAll();
	}
}
