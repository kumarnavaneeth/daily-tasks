package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Note;

@Service
public class NotesService {
	public Note GetNotes() {
		Note note = new Note();
		note.setId(124);
		note.setTitle("Java");
		note.setContent("spring");
		return note;
	}

	public void createNote(Note note) {
		System.out.println(note.getId());
		System.out.println(note.getTitle());
		System.out.println(note.getContent());

	}
}
