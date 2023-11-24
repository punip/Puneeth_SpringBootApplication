package com.gl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.entity.Ticket;
import com.gl.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository dao;

	@Override
	public void save(Ticket t) {

		dao.save(t);
	}

	@Override
	public List<Ticket> findAll() {

		return (List<Ticket>) dao.findAll();
	}

	

	@Override
	public List<Ticket> findByTicketTitle(String ticketTitle) {

		return dao.findByTicketTitle(ticketTitle);

	}

	@Override
	public String deleteById(int id) {

		return dao.deleteById(id);
	}

	@Override
	public Optional<Ticket> findById(int id) {
		return dao.findById(id);
	}

}
