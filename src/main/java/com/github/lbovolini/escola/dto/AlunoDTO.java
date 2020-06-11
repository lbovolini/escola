package com.github.lbovolini.escola.dto;

import com.github.lbovolini.escola.model.Curso;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class AlunoDTO {
    @XmlElement
    public int id;
    @XmlElement
    public String name;
    @XmlElement
    public String email;
    @XmlElement
    public String password;
    @XmlElement
    public Date birthday;
    @XmlElement
    public Curso curso;
}
