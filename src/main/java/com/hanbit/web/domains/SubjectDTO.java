package com.hanbit.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Component
@Data
public class SubjectDTO implements Serializable {
   private static final long serialVersionUID = 1L;

   @Getter @Setter private String category;   
   @Getter @Setter private String title;
   @Getter @Setter private String regDate;
   @Getter @Setter private String content;
   @Getter @Setter int artSeq;

}