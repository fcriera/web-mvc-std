package com.keepcoding.web.mvc.service;

import java.util.List;

import com.keepcoding.web.mvc.entity.Alumno;


public interface AlumnoService {
	//metodo para devolver todos los registros
		public List<Alumno> ListarAlumnos();
		//metodo para buscar un registro por id
		public Alumno buscarPorId(Long id);
		//metodo para registro
		public Alumno guardar(Alumno alumno);
		//metodo para eliminar
		public Alumno borrar(Long id);
		
}
