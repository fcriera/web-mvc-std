package com.keepcoding.web.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keepcoding.web.mvc.dao.ProyectoRepository;
import com.keepcoding.web.mvc.entity.Proyecto;


@Service
public class ProyectoServiceImpl implements ProyectoService{
	
	
		@Autowired
		ProyectoRepository proyectoRepository;
		@Override
		@Transactional(readOnly = true)
		public List<Proyecto> ListarProyectos() {
			return (List<Proyecto>) proyectoRepository.findAll();
		}
		@Override
		@Transactional(readOnly = true)
		public Proyecto buscarPorId(Long id) {
			return proyectoRepository.findById(id).orElse(null);
		}
		@Override
		@Transactional
		public Proyecto guardar(Proyecto proyecto) {
			return proyectoRepository.save(proyecto);
		}
		@Override
		@Transactional
		public Proyecto borrar(Long id) {
			Proyecto proyectoDelete= proyectoRepository.findById(id).orElse(null);
			proyectoRepository.deleteById(id);
			return proyectoDelete;
		}
		

}
