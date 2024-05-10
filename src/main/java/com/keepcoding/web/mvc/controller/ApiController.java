package com.keepcoding.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keepcoding.web.mvc.entity.Proyecto;
import com.keepcoding.web.mvc.service.ProyectoService;



@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private ProyectoService service;
	
	@GetMapping("/proyectos")
	public List<Proyecto> index(){
		return service.ListarProyectos();
	}
	
	//metodo get que devuelve un solo registro dado el id
		@GetMapping("/proyectos/{id}")
		public Proyecto show(@PathVariable Long id) {
			return service.buscarPorId(id);
		}
		//metodo post para guardar un nuevo alumno
		@PostMapping("/proyectos")
		public Proyecto create(@RequestBody Proyecto proyecto) {
			return service.guardar(proyecto);
		}
		
		//metodo put para actualizar un registro de alumno existente
		@PutMapping("/proyectos/{id}")
		public Proyecto update(@PathVariable Long id, @RequestBody Proyecto proyecto) {
			
			Proyecto proyectoUpdate = service.buscarPorId(id); 
			proyectoUpdate.setNombre(proyecto.getNombre());
			proyectoUpdate.setDescripcion(proyecto.getDescripcion());
			proyectoUpdate.setFechaInicio(proyecto.getFechaInicio());
			proyectoUpdate.setFechaFin(proyecto.getFechaFin());
			proyectoUpdate.setActivo(proyecto.getActivo());
			
			return service.guardar(proyectoUpdate);
		}
		
		//metodo delete para borrar
		@DeleteMapping("/proyectos/{id}")
		public Proyecto delete(@PathVariable Long id) {
			return service.borrar(id);
		}
		

}
