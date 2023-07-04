package br.matc84.spring.exercicio.domain.models;

import java.util.List;

public class ApplicationErrorModel {
    private Integer statusCode;
    private String statusDescription;
    private String clientMessage;
    private String developerMessage;
    private List<ErrorModel> errors;
    private ApplicationErrorModel() { }

    public Integer getStatusCode() {
        return statusCode;
    }
    
    public String getStatusDescription() {
        return statusDescription;
    }

    public String getClientMessage() {
        return clientMessage;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public List<ErrorModel> getErrors() {
        return errors;
    }

    public static final class ApplicationErrorModelBuilder {
        private Integer statusCode;
        private String statusDescription;
        private String clientMessage;
        private String developerMessage;
        private List<ErrorModel> errors;
        private ApplicationErrorModelBuilder() { }

        public static ApplicationErrorModelBuilder anApplicationErrorModelBuilder() {
            return new ApplicationErrorModelBuilder();
        }

        public ApplicationErrorModelBuilder withStatusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public ApplicationErrorModelBuilder withStatusDescription(String statusDescription) {
            this.statusDescription = statusDescription;
            return this;
        }

        public ApplicationErrorModelBuilder withClientMessage(String clientMessage) {
            this.clientMessage = clientMessage;
            return this;
        }

        public ApplicationErrorModelBuilder withDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ApplicationErrorModelBuilder withErrors(List<ErrorModel> errors) {
            this.errors = errors;
            return this;
        }

        public ApplicationErrorModel build() {
            ApplicationErrorModel applicationErrorModel = new ApplicationErrorModel();

            applicationErrorModel.statusCode = this.statusCode;
            applicationErrorModel.statusDescription = this.statusDescription;
            applicationErrorModel.clientMessage = this.clientMessage;
            applicationErrorModel.developerMessage = this.developerMessage;
            applicationErrorModel.errors = this.errors;

            return applicationErrorModel;
        }
    }



   
}
