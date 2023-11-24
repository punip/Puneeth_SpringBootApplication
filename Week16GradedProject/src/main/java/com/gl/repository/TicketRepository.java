package com.gl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	
	public Optional<Ticket> findById(int id);
	List<Ticket> findByTicketTitle(String ticketTitle);
	public String deleteById(int id);
}
