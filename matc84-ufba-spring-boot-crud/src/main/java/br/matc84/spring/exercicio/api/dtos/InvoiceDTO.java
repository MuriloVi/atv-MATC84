package br.matc84.spring.exercicio.api.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;

public class InvoiceDTO {

    @NotNull
    public BigDecimal totalValue;

    @FutureOrPresent(message = "{property.dueDate.futureOrPresent}")
    public LocalDate dueDate;
}
