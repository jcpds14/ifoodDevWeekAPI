package me.dio.sacola.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor //Criar um constructor com todos os atributos
@Builder //Criar um objeto de uma forma simples
@Data //Para termos os Getters e Setters, além disso os métodos "Eco" e "Hashcode" para fazer comparações
@Embeddable
//Embeddable = De onde vai se originar a classe. Não será uma tabela no banco de dados, ela vai ser atribuida às outras classes que precisarem dela
@NoArgsConstructor//Criar um constructor vazio

public class ItemDto {
    private Long produtoId;
    private int quantidade;
    private Long idSacola;
}
