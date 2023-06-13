package com.goit.fry.spring;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeMap;

@Service
public class NoteService {

	private final TreeMap<Long, Note> data;

	public NoteService() {

		data = new TreeMap<>();
	}

	public List<Note> listAll() {

		return data.values().stream().toList();
	}

	public void add(Note note) {

		if (data.containsKey(note.getId())) {
			throw new IllegalArgumentException("key already exists: " + note.getId());
		}

		data.put(note.getId(), note);
	}

	public Note addWithNewId(Note note) {

		long newId = data.isEmpty() ? 1 : data.lastKey() + 1;
		note.setId(newId);

		data.put(newId, note);
		return note;
	}

	public void deleteById(long id) {

		if (!data.containsKey(id)) {
			throw new IllegalArgumentException("no such key: " + id);
		}

		data.remove(id);
	}

	public void update(Note note) {

		if (!data.containsKey(note.getId())) {
			throw new IllegalArgumentException("no such key: " + note.getId());
		}

		data.put(note.getId(), note);
	}

	public Note getById(long id) {

		return data.get(id);
	}
}
