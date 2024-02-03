package com.game.maker.dto;

import com.game.maker.model.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAlternativeDTO {

    private Long id;
    private String alternative;
    private Boolean itsCorrect;
    private String reference;
    private QuestionDTO question;

    @Override
    public String toString() {
        return "QuestionAlternative: " +
                "---> id= " + id +
                "---> Reference= " + reference +
                "---> isCorrect= " + itsCorrect +
                "---> Alternative= " + alternative;
    }
    
}
