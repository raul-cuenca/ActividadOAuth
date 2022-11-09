package actS9.raulcuenca.service;

import java.util.List;

import actS9.raulcuenca.model.Estudiante;



public interface EstudianteService {
	
	void save(Estudiante e);

	void update(Estudiante e);

	void delete(Integer id);

	List<Estudiante> get();

	Estudiante getId(Integer id);

}
