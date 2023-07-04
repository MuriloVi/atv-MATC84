package br.matc84.spring.exercicio.api.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.matc84.spring.exercicio.domain.models.InvoiceModel;
import br.matc84.spring.exercicio.domain.ports.InvoiceServicePort;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = InvoiceController.class)
@AutoConfigureMockMvc(addFilters = false)
public class InvoiceControllerTest {

    private String MOCKED_UUID = "9a7b184d-75a0-4738-afbb-2dfe8359f1bc";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InvoiceServicePort invoiceServicePort;

    @Test
    @DisplayName("Deve cadastrar uma cobrança com sucesso e retornar o status CREATED, além do conteúdo em seu body.")
    void returnStatusCreatedWhenInvoiceCreateIsSuccessfuly() throws Exception {
        when(invoiceServicePort.create(any(BigDecimal.class), any(LocalDate.class))).thenReturn(this.getValidInvoice());

        ObjectMapper om = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).registerModule(new JavaTimeModule());
        ObjectWriter ow = om.writer().withDefaultPrettyPrinter();

        MvcResult postResult = mockMvc.perform(post(InvoiceController.API_URL)
            .contentType(APPLICATION_JSON)
            .characterEncoding("UTF-8")
            .content(ow.writeValueAsString(this.getValidInvoice()))
        ).andReturn();

        MockHttpServletResponse response = postResult.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        assertTrue(response.getContentAsString().contains(MOCKED_UUID));
    }

    private InvoiceModel getValidInvoice() {
        return InvoiceModel.InvoiceModelBuilder.anInvoiceModel()
        .withUuid(MOCKED_UUID)
        .withTotalValue(BigDecimal.valueOf(199.99))
        .withDueDate(LocalDate.now().plusDays(1))
        .withCreatedAt(LocalDateTime.now())
        .build();
    }
}