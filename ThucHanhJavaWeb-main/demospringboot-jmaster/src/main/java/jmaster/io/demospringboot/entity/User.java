package jmaster.io.demospringboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@NotEmpty(message = "{ValidationMessages.properties}")
@Size(max=3, message  = "fail")
private String name;
private String username;
private String password;
private String role;
}