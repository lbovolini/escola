CREATE TABLE IF NOT EXISTS `escola`.`Curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS escola.Aluno (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NULL,
  email VARCHAR(45) NULL,
  birthday DATE NULL,
  Curso_id INT NOT NULL,
  PRIMARY KEY (id), 
  FOREIGN KEY (Curso_id)
  REFERENCES escola.Curso (id));
  
  
ALTER TABLE Aluno ADD password VARCHAR(255);


CREATE TABLE IF NOT EXISTS `escola`.`Turma` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(45) NULL,
  `Curso_id` INT NOT NULL,
  PRIMARY KEY (`id`),
ENGINE = InnoDB

ALTER TABLE Turma ADD FOREIGN KEY (`Curso_id`)
REFERENCES `escola`.`Curso` (`id`)


CREATE TABLE IF NOT EXISTS `escola`.`AlunoTurma` (
  `Aluno_id` INT NOT NULL,
  `Turma_id` INT NOT NULL,
  PRIMARY KEY (`Aluno_id`, `Turma_id`),
  FOREIGN KEY (`Aluno_id`)
  REFERENCES `escola`.`Aluno` (`id`),
  FOREIGN KEY (`Turma_id`)
  REFERENCES `escola`.`Turma` (`id`)
);


CREATE TABLE IF NOT EXISTS `escola`.`Professor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `escola`.`Disciplina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `escola`.`Aula` (
  `Aluno_id` INT NOT NULL,
  `Disciplina_id` INT NOT NULL,
  `day` DATE NULL,
  PRIMARY KEY (`Aluno_id`, `Disciplina_id`),
  FOREIGN KEY (`Aluno_id`)
  REFERENCES `escola`.`Aluno` (`id`),
  FOREIGN KEY (`Disciplina_id`)
  REFERENCES `escola`.`Disciplina` (`id`)
);

CREATE TABLE IF NOT EXISTS `escola`.`Matricula` (
  `Aluno_id` INT NOT NULL,
  `Disciplina_id` INT NOT NULL,
  PRIMARY KEY (`Aluno_id`, `Disciplina_id`),
  FOREIGN KEY (`Aluno_id`)
  REFERENCES `escola`.`Aluno` (`id`),
  FOREIGN KEY (`Disciplina_id`)
  REFERENCES `escola`.`Disciplina` (`id`)
);

CREATE TABLE IF NOT EXISTS `escola`.`Ministra` (
  `Disciplina_id` INT NOT NULL,
  `Professor_id` INT NOT NULL,
  PRIMARY KEY (`Disciplina_id`, `Professor_id`),
  FOREIGN KEY (`Disciplina_id`)
  REFERENCES `escola`.`Disciplina` (`id`),
  FOREIGN KEY (`Professor_id`)
  REFERENCES `escola`.`Professor` (`id`)
);

ALTER TABLE Aula MODIFY day DATE NOT NULL;

ALTER TABLE Aula DROP PRIMARY KEY, ADD PRIMARY KEY (`Aluno_id`, `Disciplina_id`, `day`);

CREATE TABLE IF NOT EXISTS `escola`.`GradeCurricular` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `year` INT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `escola`.`DisciplinaGradeCurricular` (
  `Disciplina_id` INT NOT NULL,
  `GradeCurricular_id` INT NOT NULL,
  PRIMARY KEY (`Disciplina_id`, `GradeCurricular_id`),
  FOREIGN KEY (`Disciplina_id`)
  REFERENCES `escola`.`Disciplina` (`id`),
  FOREIGN KEY (`GradeCurricular_id`)
  REFERENCES `escola`.`GradeCurricular` (`id`)
);
  
