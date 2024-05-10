package com.keepcoding.web.mvc.service;

import java.util.List;

import com.keepcoding.web.mvc.entity.Proyecto;



public interface ProyectoService {
	//metodo para devolver todos los registros
			public List<Proyecto> ListarProyectos();
			//metodo para buscar un registro por id
			public Proyecto buscarPorId(Long id);
			//metodo para registro
			public Proyecto guardar(Proyecto proyecto);
			//metodo para eliminar
			public Proyecto borrar(Long id);
			
}
