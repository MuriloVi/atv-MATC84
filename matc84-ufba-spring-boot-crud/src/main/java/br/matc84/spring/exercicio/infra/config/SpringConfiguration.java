package br.matc84.spring.exercicio.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.matc84.spring.exercicio.domain.ports.InvoiceRepositoryPort;
import br.matc84.spring.exercicio.domain.ports.InvoiceServicePort;
import br.matc84.spring.exercicio.infra.persistence.adapters.InvoiceRepositoryAdapter;
import br.matc84.spring.exercicio.infra.persistence.repositories.InvoiceRepository;
import br.matc84.spring.exercicio.infra.services.InvoiceServiceImpl;

@Configuration
public class SpringConfiguration {

    private final InvoiceRepository invoiceRepository;

    public SpringConfiguration(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Bean
    public InvoiceRepositoryPort invoiceRepositoryPort() {
        return new InvoiceRepositoryAdapter(this.invoiceRepository);
    }
    
    @Bean
    public InvoiceServicePort invoiceServicePort() {
        return new InvoiceServiceImpl(this.invoiceRepositoryPort());
    }
}
