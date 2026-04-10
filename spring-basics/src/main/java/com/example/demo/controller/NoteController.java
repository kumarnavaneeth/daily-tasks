package com.example.demo.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component if not create method and use @Bean
@Scope("prototype")// if not used,its singleton
public class NoteController {
public NoteController() {
	System.out.println("initital");
}
}
