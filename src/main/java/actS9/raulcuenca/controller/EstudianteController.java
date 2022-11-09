package actS9.raulcuenca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import actS9.raulcuenca.model.Estudiante;
import actS9.raulcuenca.service.EstudianteService;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
	
	@Autowired
	private EstudianteService service;
	
	@RequestMapping(path="/listar",method=RequestMethod.GET)
	public ResponseEntity<List<Estudiante>> get(){		
		return new ResponseEntity<List<Estudiante>>(service.get(),HttpStatus.OK);		
	}
	
	
	@RequestMapping(path="/guardar",method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Estudiante estudiante){
		
		service.save(estudiante);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path="/listar/{id}",method=RequestMethod.GET)
	public ResponseEntity<Estudiante> getId(@PathVariable Integer id){
		
		Estudiante objestudiante = service.getId(id);
		
		if(objestudiante != null) {
			return new ResponseEntity<Estudiante>(objestudiante,HttpStatus.OK);
		}else {
			return new ResponseEntity<Estudiante>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path="/actualizar",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Estudiante cliente){
		
		Estudiante objestudiante = service.getId(cliente.getIdEstudiante());
		
		if(objestudiante != null) {
			service.update(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path="/eliminar/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		Estudiante objestudiante = service.getId(id);
		
		if(objestudiante != null) {
			service.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	

}
