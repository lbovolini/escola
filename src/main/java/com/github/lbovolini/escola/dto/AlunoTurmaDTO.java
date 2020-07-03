package com.github.lbovolini.escola.dto;

public class AlunoTurmaDTO {

    private AlunoDTO alunoDTO;
    private TurmaDTO turmaDTO;

    public AlunoTurmaDTO() {
    }

    public AlunoTurmaDTO(AlunoDTO alunoDTO, TurmaDTO turmaDTO) {
        this.alunoDTO = alunoDTO;
        this.turmaDTO = turmaDTO;
    }

    public AlunoDTO getAlunoDTO() {
        return alunoDTO;
    }

    public void setAlunoDTO(AlunoDTO alunoDTO) {
        this.alunoDTO = alunoDTO;
    }

    public TurmaDTO getTurmaDTO() {
        return turmaDTO;
    }

    public void setTurmaDTO(TurmaDTO turmaDTO) {
        this.turmaDTO = turmaDTO;
    }
}
