package com.gl.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@NotEmpty(message="Ticket title cannot be blank")
	@Size(min=3,message="Ticket title should have minimum 3 characters ")
	@Size(max=15,message="Ticket should have maximum 15 characters")
	String ticketTitle;
	@NotEmpty(message="Ticket description cannot be blank")
	String ticketDescription;
	LocalDate ticketCreated;
}
