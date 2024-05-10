package com.keepcoding.web.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keepcoding.web.mvc.dao.AlumnoRepository;
import com.keepcoding.web.mvc.entity.Alumno;



@Service
public class AlumnoServiceImpl implements AlumnoService{
	@Autowired
	AlumnoRepository alumnoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> ListarAlumnos() {
		return (List<Alumno>) alumnoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno buscarPorId(Long id) {
		return alumnoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Alumno guardar(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	@Transactional
	public Alumno borrar(Long id) {
		Alumno alumnoDelete= alumnoRepository.findById(id).orElse(null);
		alumnoRepository.deleteById(id);
		return alumnoDelete;
	}
	
	

}
