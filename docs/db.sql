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
