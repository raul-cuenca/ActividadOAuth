package actS9.raulcuenca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import actS9.raulcuenca.model.Estudiante;
import actS9.raulcuenca.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	@Autowired
	private EstudianteRepository repository;

	@Override
	public void save(Estudiante e) {
		repository.save(e);
	}

	@Override
	public void update(Estudiante e) {
		repository.saveAndFlush(e);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Estudiante> get() {
		return repository.findAll();
	}

	@Override
	public Estudiante getId(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
