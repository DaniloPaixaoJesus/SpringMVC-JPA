package br.com.danilopaixao.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.danilopaixao.financas.modelo.Conta;
import br.com.danilopaixao.financas.util.JPAUtil;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteMovimentacaoConta {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();
        Query query = manager.createQuery("select distinct c from Conta c left join fetch c.movimentacoes");

        List<Conta> contas = query.getResultList();

        for (Conta conta : contas) {
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Número de movimentações ...: " + conta.getMovimentacoes().size());
        }
    }


}
