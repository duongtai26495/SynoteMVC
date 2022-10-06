package com.duongtai.syndiary.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name ="diary")
@Data
public class Diary {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String content;

	private boolean isDone;

	private boolean isDisplay;

	
}
