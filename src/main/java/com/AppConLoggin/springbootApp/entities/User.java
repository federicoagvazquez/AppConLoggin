package com.AppConLoggin.springbootApp.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Data
@NoArgsConstructor
public class User implements Serializable {

  private static final long serialVersionUID = -6833167247953613395L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private Long id;

  @Column
  private String firstName;
  @Column
  private String lastName;
  @Column(unique = true)
  private String email;
  @Column(unique = true)
  private String username;
  @Column
  private String password;


  @Transient
  private String confirmPassword;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles"
      , joinColumns = @JoinColumn(name = "user_id")
      , inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

}
