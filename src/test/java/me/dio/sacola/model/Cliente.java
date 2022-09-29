package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor //Criar um constructor com todos os atributos
@Builder //Criar um objeto de uma forma simples
@Data //Para termos os Getters e Setters, além disso os métodos "Eco" e "Hashcode" para fazer comparações
@Entity //Pra dizer que a Classe seja convertida em uma tabela no banco de dados
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//Para ignorar alguns erros do Hibernate
@NoArgsConstructor//Criar um constructor vazio
public class Cliente {
    @Id //Identificador único de cada objeto
    @GeneratedValue(strategy = GenerationType.AUTO)//Forma que o Id será gerado, neste caso, auto incremento
    private Long id;
    private String nome;
    @Embedded//Embedded = De onde vou pegar a classe.
    private Endereco endereco;
}
