package com.relation.relationmanytomany.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name = "roles")
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 20, unique = true)
  private String roleName;
  @Column(name="description")
  private String desc;

  @ManyToMany(fetch = FetchType.EAGER)

  @ToString.Exclude
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<User> users=new ArrayList<>();  
}
