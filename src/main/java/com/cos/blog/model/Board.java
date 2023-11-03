package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;

	@Lob //대용량 데이터
	private String content;  //섬머노트 라이브러리 <html>태그가 섞여서 디자인됨
	
	@ColumnDefault("0")
	private int count ; //조회수
	
	//private int userId;
	@ManyToOne(fetch = FetchType.EAGER) // Board = Many,  User = One
	@JoinColumn(name="userId") //테이블에는 userId로 만들어진다. 
	private User user; //DB는 오브젝트를 저장할 수 없다. FK 자바는 오브젝트를 저장할 수 있다. 
	
	@OneToMany(mappedBy = "board") //mappedBy가 있으면 연관관계의 주인이 아니다.(FK가 아니다.)DB에 컬럼을 만들지 말아라.
	private List<Reply> reply;                   //하나의 게시글(한명의  유저)은 여러개의 답변을 가질수 있다.
	
	@CreationTimestamp
	private Timestamp createDate;
}
