package ru.java5.problem.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "problem")
public class Problem implements Serializable {
  private Long id;
  private String json;

  public Problem() {}
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  @Lob
  @Column(name = "json", nullable = false)
  public String getJson() {
    return json;
  }
}
