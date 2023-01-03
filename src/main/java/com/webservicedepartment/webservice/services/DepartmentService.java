package com.webservicedepartment.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservicedepartment.webservice.entities.Department;
import com.webservicedepartment.webservice.repositories.DepartmentRepository;
import com.webservicedepartment.webservice.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	public List<Department> findAll() {
		return repository.findAll();
	}

	public Department findById(Long id) {
		Optional<Department> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Department insert(Department obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Department update(Long id, Department obj) {
		try {
			Department entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Department entity, Department obj) {
		entity.setName(obj.getName());
	}
}