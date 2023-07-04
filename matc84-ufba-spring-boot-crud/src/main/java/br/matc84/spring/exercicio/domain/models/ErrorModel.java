package br.matc84.spring.exercicio.domain.models;

public record ErrorModel(String message, String field, Object content) { }
