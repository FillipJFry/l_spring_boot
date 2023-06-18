package com.goit.fry.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

	@Autowired
	private NoteRepository repository;

	public List<Note> listAll() {

		return repository.findAll();
	}

	public void save(Note note) {

		repository.save(note);
	}

	public Note addWithNewId(Note note) {

		return repository.save(note);
	}

	public void deleteById(long id) {

		repository.deleteById(id);
	}

	public Note getById(long id) {

		return repository.getReferenceById(id);
	}
}
