package com.validacao.fatura.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString

public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O numero do cartão não pode estar em branco")
    @Pattern(regexp = "\\d{16}", message = "Deve conter 16 dígitos numéricos")
    private String numeroCartao;

    @NotBlank(message = "O nome do titular não pode estar em branco")
    @Size(min = 3, max = 100, message = "Deve conter entre 3 e 100 caracteres")
    private String nomeTitular;

    @NotBlank(message = "O numero não pode estar em branco")
    @DecimalMin(value = "10.00", message = "No mínimo R$10,00")
    @DecimalMax(value = "5000.00", message = "No máximo R$5000,00")
    private Double valor;

    @NotNull(message = "A data de pagamento não pode ser nula")
    @FutureOrPresent(message = "Deve ser uma data presente ou futura")
    private LocalDate dataPagamento;

    @NotBlank(message = "O email de contato não pode estar em branco")
    @Email(message = "O email deve ser valido")
    private String emailContato;
}
