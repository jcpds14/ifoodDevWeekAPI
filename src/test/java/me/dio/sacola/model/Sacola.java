package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.sacola.enumeration.FormaPagamento;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor //Criar um constructor com todos os atributos
@Builder //Criar um objeto de uma forma simples
@Data //Para termos os Getters e Setters, além disso os métodos "Eco" e "Hashcode" para fazer comparações
@Entity //Pra dizer que a Classe seja convertida em uma tabela no banco de dados
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//Para ignorar alguns erros do Hibernate
@NoArgsConstructor//Criar um constructor vazio
public class Sacola {
    @Id //Identificador único de cada objeto
    @GeneratedValue(strategy = GenerationType.AUTO)//Forma que o Id será gerado, neste caso, auto incremento
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) //Um cliente pode ter várias sacolas
    @JsonIgnore
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL)//Se excluir ou fizer qualquer alteração em Restaurante o Produto será afetado
    private List<Item> itens;//Uma sacola tem vários itens
    private Double valorTotal;
    @Enumerated
    private FormaPagamento FormaPagamento;
    private boolean fechada;

}
