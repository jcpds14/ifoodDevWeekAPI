package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor //Criar um constructor com todos os atributos
@Builder //Criar um objeto de uma forma simples
@Data //Para termos os Getters e Setters, além disso os métodos "Eco" e "Hashcode" para fazer comparações
@Entity //Pra dizer que a Classe seja convertida em uma tabela no banco de dados
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//Para ignorar alguns erros do Hibernate
@NoArgsConstructor//Criar um constructor vazio
public class Restaurante {
    @Id //Identificador único de cada objeto
    @GeneratedValue(strategy = GenerationType.AUTO)//Forma que o Id será gerado, neste caso, auto incremento
    private Long id;
    private String nome;
    @OneToMany(cascade = CascadeType.ALL)//Se excluir ou fizer qualquer alteração em Restaurante o Produto será afetado
    private List<Produto> cardapio;//Um restaurante tem vários produtos
    @Embedded
    private Endereco endereco;
}
