package com.gl.controller;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.entity.Ticket;
import com.gl.repository.TicketRepository;
import com.gl.service.TicketService;

import jakarta.validation.Valid;

@Controller
public class TicketController {
	
	
	@Autowired
	TicketService service;

	@RequestMapping("/")
	public String welcome(Model m) {
		m.addAttribute("tickets", (List<Ticket>) service.findAll());
		return "welcome";
	}

	@RequestMapping("/showForm")
	public String showForm(Model m) {
		m.addAttribute("ticket", new Ticket());
		m.addAttribute("title", "Add Ticket");
		return "showForm";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id, Model m) {

		service.deleteById(id);
		m.addAttribute("tickets", service.findAll());
		return "welcome";
	}

	@RequestMapping("/edit/{id}")
	public String update(@PathVariable("id") int id, Model m) {
		m.addAttribute("ticket",service.findById(id));
		m.addAttribute("title", "Update Ticket");
		return "showForm";
	}

	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") int id, Model m) {
		Ticket ticket = service.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Ticket not found with id: " + id));
		m.addAttribute("ticketList", Collections.singletonList(ticket));
		return "view";
	}

	@PostMapping("/save")
	public String save(@Valid Ticket ticket, BindingResult br, Model m) {

		if (br.hasErrors()) {
			return "showForm";
		}
		ticket.setTicketCreated(LocalDate.now());
		service.save(ticket);
		m.addAttribute("tickets", (List<Ticket>) service.findAll());
		return "welcome";
	}

	@RequestMapping("/view")
	public String view(@RequestParam String search, Model m) {
		List<Ticket> ticketList = null;

		if (search != null && !search.isEmpty()) {
			ticketList = service.findByTicketTitle(search);
		}
		m.addAttribute("ticketList", ticketList);
		return "view";
	}

}
