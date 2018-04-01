package br.com.danilopaixao.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.danilopaixao.financas.modelo.Categoria;
import br.com.danilopaixao.financas.modelo.Movimentacao;
import br.com.danilopaixao.financas.util.JPAUtil;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteMovimentacoesPorCategoria {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        Categoria categoria = new Categoria();
        categoria.setId(1);

        Query query = manager
                .createQuery("select m from Movimentacao m join m.categoria c where c = :pCategoria");

        query.setParameter("pCategoria", categoria);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao m : movimentacoes) {
            System.out.println("\nDescricao ..: " + m.getDescricao());
            System.out.println("Valor ......: R$ " + m.getValor());
        }

    }
}
