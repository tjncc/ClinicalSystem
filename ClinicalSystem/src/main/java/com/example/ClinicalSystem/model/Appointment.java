package com.example.ClinicalSystem.model;


import com.example.ClinicalSystem.DTO.OperationRoomDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.util.Date;


@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name" , nullable = false)
	private String name;

	@Column(name = "startdate" , nullable = false)
	private Date start;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	@Column(name = "starttime", nullable = false )
	private Time startTime;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	@Column(name = "endtime", nullable = false )
	private Time endTime;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ExamType type;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Patient patient;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private OR or;


	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Calendar calendar;


	@Column(name = "hasHappend", nullable = false)
	private boolean hasHappend;

	public Appointment() {
		super();
	}

	public Appointment(Long id, Date start, Time startTime, Time endTime, ExamType type, Patient patient, Doctor doctor,
					   boolean hasHappend, OR room, String name) {
		super();
		this.id = id;
		this.start = start;
		this.startTime = startTime;
		this.endTime = endTime;
		this.type = type;
		this.patient = patient;
		this.doctor = doctor;
		this.hasHappend = hasHappend;
		this.or = room;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExamType getType() {
		return type;
	}

	public void setType(ExamType type) {
		this.type = type;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}



	public boolean isHasHappend() {
		return hasHappend;
	}

	public void setHasHappend(boolean hasHappend) {
		this.hasHappend = hasHappend;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OR getOr() {
		return or;
	}

	public void setOr(OR or) {
		this.or = or;
	}

	public Calendar getCalendar() {
		return calendar;
	}
}
