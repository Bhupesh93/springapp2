package backend.controller;

import backend.model.Question;
import backend.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping(path = "/surveys/{surveyId}/questions")
    public List<Question> getQuestions(@PathVariable String surveyId) {
        System.out.println("SurveyID " + surveyId);
        return surveyService.listQuestion(surveyId);
    }


    @GetMapping(path = "/surveys/{surveyId}/questions/{questionId}")
    public Question getQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
        System.out.println("SurveyID " + surveyId);
        return surveyService.retriveQuestion(surveyId, questionId);
    }

    @PostMapping("/surveys/{surveyId}/questions")
    ResponseEntity<?> add(@PathVariable String surveyId,
                          @RequestBody Question question) {

        Question createdTodo = surveyService.addQuestion(surveyId, question);

        if (createdTodo == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
