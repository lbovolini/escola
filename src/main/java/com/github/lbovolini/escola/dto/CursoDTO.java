package com.github.lbovolini.escola.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CursoDTO {

    @XmlElement
    public int id;
    @XmlElement
    public String name;
}
