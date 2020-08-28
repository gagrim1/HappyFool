package com.DnD.HappyFool.Domain.Entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "t_message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String text;
	private String tag;
}
