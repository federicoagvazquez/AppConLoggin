package com.AppConLoggin.springbootApp.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@Entity
public class Role implements Serializable {

  private static final long SerialVersionUID = 2969524610059270447L;

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
  @GenericGenerator(name="native",strategy="native")
  private Long id;

  @Column
  private String name;

  @Column
  private String description;

}
