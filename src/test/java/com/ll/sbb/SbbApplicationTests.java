package com.ll.sbb;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
		Question q1 = new Question();
		q1.setSubject("이즈리얼은 원딜인가요?");
		q1.setContent("이즈리얼에 대해 알고싶습니다");
		q1.setCreatedDate(LocalDateTime.now());
		this.questionRepository.save(q1);  // 첫번째 질문 저장

		Question q2 = new Question();
		q2.setSubject("케이틀린은 원딜인가요?");
		q2.setContent("케이틀린에 대해 알고싶습니다");
		q2.setCreatedDate(LocalDateTime.now());
		this.questionRepository.save(q2); // 두번째 질문 저장
	}

}
