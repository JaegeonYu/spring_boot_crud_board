package go.demo.repository;

import go.demo.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BoardRepository {
    @PersistenceContext
    private EntityManager em;

    public Long save(Board board){
        em.persist(board);
        return board.getId();
    }

    public Board find(Long id){
       return em.find(Board.class, id);
    }

    public List<Board> findAll(){
        return em.createQuery("select m from Board m", Board.class).getResultList();
    }

    public void delete(Long id){
        Board board = find(id);
        em.remove(board);
    }

    public void update(Long id, Board board) {
        Board update = find(id);
        update.setTitle(board.getTitle());
        update.setContent(board.getContent());
    }
}
