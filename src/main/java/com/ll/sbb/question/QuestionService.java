package com.ll.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
  
  private final QuestionRepository questionRepository;

  public List<Question> getList(){
    return this.questionRepository.findAll();
  }

  public Question getQuestion(Integer id){
    Optional<Question> question = this.questionRepository.findById(id);
    if (question.isPresent()) {
      return question.get();
  } else {
    throw new DataNotFoundException("Question not found");
  }
}
  public void create(String subject, String content) {
    Question q = new Question();
    q.setSubject(subject);
    q.setContent(content);
    q.setCreatedDate(LocalDateTime.now());
    this.questionRepository.save(q);
  }
  public Page<Question> getPageList(int page) {
    Pageable pageable = PageRequest.of(page, 10);
    return this.questionRepository.findAll(pageable);
}
}
