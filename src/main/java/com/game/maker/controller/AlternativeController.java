package com.game.maker.controller;

import com.game.maker.dto.AlternativeDTO;
import com.game.maker.dto.ValidateAlternativeDTO;
import com.game.maker.service.AlternativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alternative")
public class AlternativeController {

  @Autowired
  private AlternativeService alternativeService;

  @GetMapping
  public List<AlternativeDTO> findAllQuestionsAlternatives() {
    return alternativeService.findAll();
  }

  @GetMapping("/{id}")
  public AlternativeDTO findById(@PathVariable Long id) {
    return alternativeService.findById(id);
  }

  @PostMapping("save")
  public AlternativeDTO save(@RequestBody AlternativeDTO alternativeDTO) {
    return alternativeService.save(alternativeDTO);
  }

  @PostMapping("save/list")
  public List<AlternativeDTO> save(@RequestBody List<AlternativeDTO> alternativeDTOList) {
    return alternativeService.saveAll(alternativeDTOList);
  }

  @GetMapping("/question-id/{id}")
  public List<AlternativeDTO> findQuestionAlternativesByQuestionId(@PathVariable Long id) {
    return alternativeService.findByQuestionId(id);
  }

  @PostMapping("/validate-alternative")
  public AlternativeDTO validateAlternative(ValidateAlternativeDTO validateAlternativeDTO) {
    return alternativeService.findByQuestionIdAndItsCorrect(validateAlternativeDTO.getId(), validateAlternativeDTO.getAlternativeStatus());
  }

}