package com.github.lbovolini.escola.repository;

import com.github.lbovolini.escola.dto.AlunoDTO;
import com.github.lbovolini.escola.dto.AlunoProfileDTO;
import com.github.lbovolini.escola.dto.DisciplinaDTO;
import com.github.lbovolini.escola.dto.TurmaDTO;
import com.github.lbovolini.escola.model.Aluno;
import com.github.lbovolini.escola.model.Disciplina;
import com.github.lbovolini.escola.model.Turma;
import com.github.lbovolini.escola.util.AlunoUtil;
import com.github.lbovolini.escola.util.DisciplinaUtil;
import com.github.lbovolini.escola.util.TurmaUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlunoRepositoryImpl extends RepositoryBase<Aluno> implements AlunoRepository {

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Aluno a WHERE a.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        executeDelete(query, parameters);
    }

    @Override
    public AlunoDTO find(int id) {
        String query = "SELECT a FROM Aluno a WHERE a.id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        Aluno aluno = (Aluno)executeSingle(query, parameters);

        return AlunoUtil.toDTO(aluno);
    }

    @Override
    public AlunoDTO findByEmail(String email) {
        String query = "SELECT a FROM Aluno a WHERE a.email = ?1";
        List parameters = new ArrayList();
        parameters.add(email);

        Aluno aluno = (Aluno)executeSingle(query, parameters);

        return AlunoUtil.toDTO(aluno);
    }

    @Override
    public List<DisciplinaDTO> findDisciplinas(int alunoId) {
        String query = "SELECT d FROM Matricula m JOIN Disciplina d ON m.disciplineId = d.id JOIN Aluno a ON m.studentId = a.id WHERE a.id = ?1";

        List parameters = new ArrayList();
        parameters.add(alunoId);

        List<Disciplina> disciplinaList = execute(query, parameters);
        List<DisciplinaDTO> disciplinaDTOList = disciplinaList.stream().map(DisciplinaUtil::toDTO).collect(Collectors.toList());

        return disciplinaDTOList;
    }

    @Override
    public String findPassword(String email) {
        String query = "SELECT a.password FROM Aluno a WHERE a.email = ?1";

        List parameters = new ArrayList();
        parameters.add(email);

        String password = (String)executeSingle(query, parameters);

        return password;
    }

    @Override
    public List<TurmaDTO> findTurmas(int alunoId) {
        String query = "SELECT t FROM AlunoTurma at JOIN Turma t ON at.groupId = t.id JOIN Aluno a ON a.id = at.studentId WHERE a.id = ?1";

        List parameters = new ArrayList();
        parameters.add(alunoId);

        List<Turma> turmaList = execute(query, parameters);
        List<TurmaDTO> turmaDTOList = turmaList.stream().map(TurmaUtil::toDTO).collect(Collectors.toList());

        return turmaDTOList;
    }

    @Override
    public void save(AlunoDTO alunoDTO) {
        Aluno aluno = AlunoUtil.toModel(alunoDTO);
        super.save(aluno);
    }

    @Override
    public void update(AlunoDTO alunoDTO) {

        AlunoDTO alunoDTO1 = find(alunoDTO.getId());

        if (alunoDTO1 == null) {
            return;
        }

        Aluno aluno = AlunoUtil.toModel(alunoDTO);
        super.update(aluno);
    }

    @Override
    public void updateProfile(AlunoProfileDTO alunoProfileDTO) {
        String query = "UPDATE Aluno SET name = ?1, email = ?2, birthday = ?3 WHERE id = ?4";

        List parameters = new ArrayList();
        parameters.add(alunoProfileDTO.getName());
        parameters.add(alunoProfileDTO.getEmail());
        parameters.add(alunoProfileDTO.getBirthday());
        parameters.add(alunoProfileDTO.getId());

        executeUpdate(query, parameters);
    }

    @Override
    public void updateProfileAndPassword(AlunoProfileDTO alunoProfileDTO) {
        String query = "UPDATE Aluno SET name = ?1, email = ?2, birthday = ?3, password = ?4 WHERE id = ?5";

        List parameters = new ArrayList();
        parameters.add(alunoProfileDTO.getName());
        parameters.add(alunoProfileDTO.getEmail());
        parameters.add(alunoProfileDTO.getBirthday());
        parameters.add(alunoProfileDTO.getNewPassword());
        parameters.add(alunoProfileDTO.getId());

        executeUpdate(query, parameters);
    }

}
