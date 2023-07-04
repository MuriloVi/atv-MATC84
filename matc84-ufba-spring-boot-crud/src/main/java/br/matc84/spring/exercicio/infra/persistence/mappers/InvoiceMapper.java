package br.matc84.spring.exercicio.infra.persistence.mappers;

import br.matc84.spring.exercicio.domain.models.InvoiceModel;
import br.matc84.spring.exercicio.infra.persistence.entities.InvoiceEntity;

public class InvoiceMapper {
    private InvoiceMapper() { }

    public static InvoiceEntity toEntity(InvoiceModel invoiceModel) {
        return InvoiceEntity.InvoiceEntityBuilder.anInvoiceEntity().withUuid(invoiceModel.getUuid()).withTotalValue(invoiceModel.getTotalValue()).withDueDate(invoiceModel.getDueDate()).withCreatedAt(invoiceModel.getCreatedAt()).build();
    }

    public static InvoiceModel toModel(InvoiceEntity invoiceEntity) {
        return InvoiceModel.InvoiceModelBuilder.anInvoiceModel().withUuid(invoiceEntity.getUuid()).withTotalValue(invoiceEntity.getTotalValue()).withDueDate(invoiceEntity.getDueDate()).withCreatedAt(invoiceEntity.getCreatedAt()).build();
    }
}
