package com.keepcoding.web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.keepcoding.web.mvc.entity.Alumno;
import com.keepcoding.web.mvc.service.AlumnoService;
import com.keepcoding.web.mvc.service.ProyectoService;

@Controller
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping({"/alumnos","/"})
	public String listarAlumnos(Model modelo ) {
		modelo.addAttribute("alumno", alumnoService.ListarAlumnos());
		return "alumno";
	}
	
	@GetMapping("/alumnos/new")
	public String formularioAlumno(Model modelo) {
		Alumno alumno = new Alumno();
		modelo.addAttribute("alumno",alumno);
		return "crear_alumno";
	}
	
	@PostMapping("/alumnos/new")
	public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		alumnoService.guardar(alumno);
		return "redirect:/alumnos";
	}
	
	@GetMapping("/alumno/edit/{id}")
	public String formularioEditarAlumno(@PathVariable Long id,Model modelo) {
		modelo.addAttribute("alumno",alumnoService.buscarPorId(id) );
		
		return "editar_alumno";
	}
	
	@PostMapping("/alumno/edit/{id}")
	public String actualizarEmpleado(@PathVariable Long id, @ModelAttribute("alumno") Alumno alumno) {
		Alumno alumnoUpdate = alumnoService.buscarPorId(id);
		
		alumnoUpdate.setNombre(alumno.getNombre());
		alumnoUpdate.setApellido(alumno.getApellido());
		alumnoUpdate.setEmail(alumno.getEmail());
		alumnoUpdate.setTelefono(alumno.getTelefono());
		alumnoUpdate.setDni(alumno.getDni());
		alumnoUpdate.setFechaNacimiento(alumno.getFechaNacimiento());
		
		alumnoService.guardar(alumnoUpdate);
		return "redirect:/alumnos";
	}
	
	@GetMapping("/alumno/eliminar/{id}")
	public String eliminarAlumno(@PathVariable Long id) {
		alumnoService.borrar(id);
		return "redirect:/alumnos";
	}
	@Autowired
	ProyectoService proyectoService;
	@GetMapping({"/alumnos/proyectos"})
	public String listarProyectos(Model modelo) {
		modelo.addAttribute("proyecto", proyectoService.ListarProyectos());
		return "proyectos";
	}
}
