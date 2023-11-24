package com.gl.service;

import java.util.List;
import java.util.Optional;

import com.gl.entity.Ticket;

public interface TicketService {

	public void save(Ticket t);
	public List<Ticket> findAll();
	public Optional<Ticket> findById(int id);
	List<Ticket> findByTicketTitle(String ticketTitle);
	public String deleteById(int id);
}
