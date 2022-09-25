package go.demo.service;

import go.demo.domain.Board;
import go.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BoardService {
    @Autowired
    BoardRepository boardRepository;
    @Transactional
    public void write(Board board){
        boardRepository.save(board);
    }

    public List<Board> list(){
        return boardRepository.findAll();
    }

    public Board boardView(Long id){
        return boardRepository.find(id);
    }
    @Transactional
    public void delete(Long id){
        boardRepository.delete(id);
    }
    @Transactional
    public void update(Long id, Board board) {
        boardRepository.update(id,board);
    }
}
