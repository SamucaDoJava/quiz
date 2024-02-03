package com.game.maker.builder;

import com.game.maker.dto.QuestionDTO;
import com.game.maker.model.Question;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionMapper {

    private final ModelMapper modelMapper;

    public QuestionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuestionDTO toDTO(Question model) {
        return modelMapper.map(model, QuestionDTO.class);
    }

    public Question toEntity(QuestionDTO dto) {
        return modelMapper.map(dto, Question.class);
    }

    public List<QuestionDTO> toListDTO(List<Question> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Question> toList(List<QuestionDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toCollection(ArrayList::new));
    }

}
