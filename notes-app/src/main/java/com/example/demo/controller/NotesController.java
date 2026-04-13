package com.example.demo.controller;

import com.example.demo.service.NotesService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Note;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(path = "/notes")
public class NotesController {
	@Autowired
	NotesService notesService;

	@GetMapping
	Iterable<Note> GetNotes() {
		return notesService.GetNotes();
	}

	@PostMapping
	Note addNote(@Valid @RequestBody Note note) {
		return notesService.createNote(note);
	}
}
