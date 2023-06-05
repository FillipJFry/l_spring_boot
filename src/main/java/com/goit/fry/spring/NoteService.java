package com.goit.fry.spring;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {

	private final Map<Long, Note> data;

	public NoteService() {

		data = new HashMap<>();
	}

	public List<Note> listAll() {

		return data.values().stream().toList();
	}

	public Note add(Note note) {

		if (data.containsKey(note.getId()))
			throw new IllegalArgumentException("key already exists: " + note.getId());

		data.put(note.getId(), note);
		return note;
	}

	public void deleteById(long id) {

		if (!data.containsKey(id))
			throw new IllegalArgumentException("no such key: " + id);

		data.remove(id);
	}

	public void update(Note note) {

		if (!data.containsKey(note.getId()))
			throw new IllegalArgumentException("no such key: " + note.getId());

		data.put(note.getId(), note);
	}

	public Note getById(long id) {

		return data.get(id);
	}
}
