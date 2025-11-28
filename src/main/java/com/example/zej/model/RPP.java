package com.example.zej.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("rpp")
public class RPP {

  @Id
  private String id;

  private String kelas;

  private String mapel;

  private String topik;

  private String mingguKe;

  private String kegiatanPembelajaran;

  private String metode;

}
