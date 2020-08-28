package com.DnD.HappyFool.Domain.Entity;

import javax.persistence.*;


import lombok.Data;

@Entity
@Table(name = "t_user")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "status")
	private Status status;
	@Enumerated(value = EnumType.STRING)
	@Column
	private Role role;
	
	/*@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
	@Enumerated(EnumType.STRING)
	private Set<Role> roles;*/
	
}
