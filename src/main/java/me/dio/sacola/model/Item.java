package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//Para ignorar alguns erros de serialização do Hibernate
@NoArgsConstructor//Criar um constructor vazio
public class Item {
    @Id//Identificador único de cada objeto
    @GeneratedValue(strategy = GenerationType.AUTO)//Forma que o Id será gerado, neste caso, auto incremento
    private Long id;
    @OneToOne//Um item só tem um produto
    private Produto produto;
    private int quantidade;
    @ManyToOne//Dentro de uma sacola vou ter vários produtos
    @JsonIgnore
    private Sacola sacola;
}
