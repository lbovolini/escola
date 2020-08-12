package com.github.lbovolini.escola.service;

import com.github.lbovolini.escola.auth.Credentials;
import com.github.lbovolini.escola.auth.Role;
import com.github.lbovolini.escola.dto.StudentDTO;
import com.github.lbovolini.escola.exception.InvalidCredentialsException;
import com.github.lbovolini.escola.repository.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import javax.xml.bind.DatatypeConverter;
import java.util.Calendar;
import java.util.Date;

public class AuthenticationService {

    public static final int VALID_DAYS = 30;
    public static final String BEARER_PREFIX = "Bearer";
    public static String HASH_SHA512 = "D31F9BB81B68134704060B4EE6FC772CF98F69D699A8456B296BD2D69AAF276E4AF927D0E5C62A8A4C85EC463B30ECB18D96D994A1B72D07A5D8503A9206080B";

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final AdministratorRepository administratorRepository;

    @Inject
    public AuthenticationService(StudentRepository studentRepository, TeacherRepository teacherRepository, AdministratorRepository administratorRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.administratorRepository = administratorRepository;
    }

    public void validateAdministrator(Credentials credentials) throws InvalidCredentialsException {

        if (!credentials.getRole().equals(Role.administrator())) {
            throw new InvalidCredentialsException();
        }

        String hashPassword = administratorRepository.findPassword(credentials.getEmail());

        boolean valid = BCrypt.checkpw(credentials.getPassword(), hashPassword);

        if (!valid) {
            throw new InvalidCredentialsException();
        }
    }

    public StudentDTO validateStudent(Credentials credentials) throws InvalidCredentialsException {

        if (!credentials.getRole().equals(Role.student())) {
            throw new InvalidCredentialsException();
        }

        StudentDTO studentDTO = studentRepository.findByEmail(credentials.getEmail());

        boolean valid = BCrypt.checkpw(credentials.getPassword(), studentDTO.getPassword());

        if (!valid) {
            throw new InvalidCredentialsException();
        }

        return studentDTO;
    }

    public void validateTeacher(Credentials credentials) throws InvalidCredentialsException {

        if (!credentials.getRole().equals(Role.teacher())) {
            throw new InvalidCredentialsException();
        }

        String hashPassword = teacherRepository.findPassword(credentials.getEmail());

        boolean valid = BCrypt.checkpw(credentials.getPassword(), hashPassword);

        if (!valid) {
            throw new InvalidCredentialsException();
        }
    }

    public String generateToken(String subject, String role) {

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(HASH_SHA512);

        SecretKeySpec key = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.getJcaName());

        Calendar expira = Calendar.getInstance();
        expira.add(Calendar.DAY_OF_MONTH, VALID_DAYS);

        return Jwts.builder()
                .setSubject(subject)
                .claim("role", role)
                .setIssuedAt(new Date()) // gerado em
                .setExpiration(expira.getTime()) // expira em
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public static Jws<Claims> decode(String token, String role) {
        String tokenString = extract(token);
        return Jwts.parserBuilder().setSigningKey(HASH_SHA512).require("role", role).build().parseClaimsJws(tokenString);
    }

    private static String extract(String token) {
        String tokenString = token;

        if (tokenString.startsWith(BEARER_PREFIX)) {
            tokenString = tokenString.replace(BEARER_PREFIX, "");
        }

        return tokenString;
    }

}
