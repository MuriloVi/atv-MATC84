package br.matc84.spring.exercicio.infra.persistence.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ECOBINVOICE")
public class InvoiceEntity {
    @Id
    private String uuid;
    private BigDecimal totalValue;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private InvoiceEntity() { }

    public String getUuid() {
        return uuid;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static final class InvoiceEntityBuilder {
        private String uuid;
        private BigDecimal totalValue;
        private LocalDate dueDate;
        private LocalDateTime createdAt;
        private InvoiceEntityBuilder() { }

        public static InvoiceEntityBuilder anInvoiceEntity() {
            return new InvoiceEntityBuilder();
        }

        public InvoiceEntityBuilder withUuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public InvoiceEntityBuilder withTotalValue(BigDecimal totalValue) {
            this.totalValue = totalValue;
            return this;
        }

        public InvoiceEntityBuilder withDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public InvoiceEntityBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public InvoiceEntity build() {
            InvoiceEntity invoiceEntity = new InvoiceEntity();

            invoiceEntity.uuid = this.uuid;
            invoiceEntity.totalValue = this.totalValue;
            invoiceEntity.dueDate = this.dueDate;
            invoiceEntity.createdAt = this.createdAt;

            return invoiceEntity;
        }
    }
    
}
