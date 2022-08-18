package com.ll.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
		// <findAll>

		// List<Question> all = this.questionRepository.findAll();
		// assertEquals(2, all.size());
		// Question q = all.get(0);
		// assertEquals("이즈리얼은 원딜인가요?",q.getSubject());


			// <findById>
		Optional<Question> oq = this.questionRepository.findById(1);
		if (oq.isPresent()) {
			Question q = oq.get();
			assertEquals("이즈리얼은 원딜인가요?",q.getSubject());
}
}