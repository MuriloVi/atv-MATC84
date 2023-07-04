package br.matc84.spring.exercicio.domain.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class InvoiceModel {
    private String uuid;
    private BigDecimal totalValue;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private InvoiceModel() { }

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

    public static final class InvoiceModelBuilder {
        private String uuid;
        private BigDecimal totalValue;
        private LocalDate dueDate;
        private LocalDateTime createdAt;
        private InvoiceModelBuilder() { }

        public static InvoiceModelBuilder anInvoiceModel() {
            return new InvoiceModelBuilder();
        }

        public InvoiceModelBuilder withUuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public InvoiceModelBuilder withTotalValue(BigDecimal totalValue) {
            this.totalValue = totalValue;
            return this;
        }

        public InvoiceModelBuilder withDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public InvoiceModelBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public InvoiceModel build() {
            InvoiceModel invoiceModel = new InvoiceModel();
            
            invoiceModel.uuid = this.uuid;
            invoiceModel.totalValue = this.totalValue;
            invoiceModel.dueDate = this.dueDate;
            invoiceModel.createdAt = this.createdAt;

            return invoiceModel;
        }
    }
}
