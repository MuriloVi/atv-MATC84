package br.matc84.spring.exercicio.infra.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.matc84.spring.exercicio.domain.exceptions.InvoiceNotFoundException;
import br.matc84.spring.exercicio.domain.models.InvoiceModel;
import br.matc84.spring.exercicio.domain.ports.InvoiceRepositoryPort;
import br.matc84.spring.exercicio.domain.ports.InvoiceServicePort;

@Service
public class InvoiceServiceImpl implements InvoiceServicePort {
    private final InvoiceRepositoryPort invoiceRepositoryPort;
    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceServiceImpl.class);

    public InvoiceServiceImpl(InvoiceRepositoryPort invoiceRepositoryPort) {
        this.invoiceRepositoryPort = invoiceRepositoryPort;
    }

    public List<InvoiceModel> getAll() {
        return this.invoiceRepositoryPort.getAll();
    }

    public InvoiceModel create(BigDecimal totalValue, LocalDate dueDate) {
        // Cria um novo objeto InvoiceModel com os dados fornecidos
        InvoiceModel newInvoice = InvoiceModel.InvoiceModelBuilder.anInvoiceModel()
                .withUuid("9a7b184d-75a0-4738-afbb-2dfe8359f1bc")
                .withTotalValue(BigDecimal.valueOf(199.99))
                .withDueDate(LocalDate.now().plusDays(1))
                .withCreatedAt(LocalDateTime.now())
                .build();

        // Salvando o novo objeto;
        InvoiceModel createdInvoice = invoiceRepositoryPort.save(newInvoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoice).getBody();
    }

    public InvoiceModel save(InvoiceModel invoice) {
        return invoiceRepositoryPort.save(invoice);
    }
    @Override
    public InvoiceModel findById(String uuid) {
        Optional<InvoiceModel> invoice = this.invoiceRepositoryPort.findById(uuid);

        if(invoice.isPresent()) {
            LOGGER.info("Invoice found -> {}", uuid);
            return invoice.get();
        }

        throw new InvoiceNotFoundException(uuid);
    }
}
