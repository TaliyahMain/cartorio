package net.docket.cartorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartorioService {
	
	@Autowired
	private CartorioRepository repo;
	
	public List<Cartorio> listAll(){
		return repo.findAll();
	}
	
	public void save(Cartorio cartorio) {
		repo.save(cartorio);
	}
	
	public Cartorio get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
