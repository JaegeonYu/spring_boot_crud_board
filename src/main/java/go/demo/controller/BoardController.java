package go.demo.controller;

import go.demo.domain.Board;
import go.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;
    @GetMapping("/hello")
    public String hello(){
        return "/boards/hello";
    }

    @GetMapping("/board/write")
    public String boardWriteForm(){
        return "/boards/writeForm";
    }
    @PostMapping("/board/write")
    public String board(@ModelAttribute Board board){
        boardService.write(board);

        return "redirect:/board/list";
    }
    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list",boardService.list());
        return "boards/list";
    }

    @GetMapping("/board/view")
    public String boardView(Model model, @RequestParam Long id){
        model.addAttribute("board",boardService.boardView(id));
        return "boards/boardView";
    }
    @GetMapping("/board/delete")
    public String boardDelete(Long id){
        boardService.delete(id);
        return "redirect:/board/list";
    }
    @GetMapping("/board/update/{id}")
    public String boardModify(@PathVariable Long id, Model model){
        model.addAttribute("board",boardService.boardView(id));
        return "boards/update";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable Long id, Board updateBoard){
        boardService.update(id, updateBoard);
        return "redirect:/board/list";
    }
}
