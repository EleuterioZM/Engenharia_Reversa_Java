package eng;

import Model.Avaliacao;
import Util.HibernateUtil;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Eng {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int opcao;
        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Adicionar Avaliação");
            System.out.println("2. Listar Avaliações");
            System.out.println("3. Remover Avaliação");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    adicionarAvaliacao();
                    break;
                case 2:
                    listarAvaliacoes();
                    break;
                case 3:
                    removerAvaliacao();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
        
        scanner.close();
    }
    
    private static void adicionarAvaliacao() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Adicionar Avaliação ===");
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Peso: ");
        BigDecimal peso = scanner.nextBigDecimal();
        
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setDescricao(descricao);
        avaliacao.setPeso(peso);
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            
            session.save(avaliacao);
            
            transaction.commit();
            System.out.println("Avaliação adicionada com sucesso.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    
    private static void removerAvaliacao() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Remover Avaliação ===");
        System.out.print("ID da Avaliação a ser removida: ");
        int id = scanner.nextInt();
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            
            Avaliacao avaliacao = (Avaliacao) session.get(Avaliacao.class, id);
            if (avaliacao != null) {
                session.delete(avaliacao);
                System.out.println("Avaliação removida com sucesso.");
            } else {
                System.out.println("Avaliação não encontrada.");
            }
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
 public static void listarAvaliacoes() {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    try {
        String hql = "FROM Avaliacao";
        Query query = session.createQuery(hql);
        List<Avaliacao> avaliacoes = query.list();

        System.out.println("Avaliações cadastradas:");
        for (Avaliacao avaliacao : avaliacoes) {
            System.out.println("ID: " + avaliacao.getId());
            System.out.println("Descrição: " + avaliacao.getDescricao());
            System.out.println("Peso: " + avaliacao.getPeso());
            System.out.println("------------------------------------");
        }

        session.getTransaction().commit();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }
}



}
