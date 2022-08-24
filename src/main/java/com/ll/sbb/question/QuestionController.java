package com.ll.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

  private final QuestionService questionService;
  
  @RequestMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<Question> paging = this.questionService.getPageList(page);
        model.addAttribute("paging", paging);
        return "question_list";
    }

  @RequestMapping(value = "/detail/{id}")
  public String detail(Model model, @PathVariable("id") Integer id){
    Question question = this.questionService.getQuestion(id);
    model.addAttribute("question", question);

    return "question_detail";
  }
  @GetMapping("/create")
  public String create(){
    return "question_form";
  }
  @PostMapping("/create")
  public String questionCreate(@RequestParam String subject, @RequestParam String content) {
    // TODO 질문을 저장한다.
    this.questionService.create(subject, content);
    return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
}
}
