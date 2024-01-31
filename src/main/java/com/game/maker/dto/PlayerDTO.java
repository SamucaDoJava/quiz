package com.game.maker.dto;

import java.util.ArrayList;

public class PlayerDTO {

    private Long id;
    private String nickName;
    private Integer score;
    private String theme;
    private UserDTO userDTO;
    private QuestionDTO currentPlayerQuestionDTO;
    private Long currentQuestionID;
    private QuestionAlternativeDTO selectedQuestionAlternative;

    private Long selectedQuestionAlternativeID;

    private ArrayList<QuestionDTO> playerQuestionsDTOList;


    public PlayerDTO(){

    }

    public PlayerDTO(String nickName, Integer score, UserDTO userDTO) {
        this.nickName = nickName;
        this.score = score;
        this.userDTO = userDTO;
    }

    public PlayerDTO(String nickName, Integer score, String theme, UserDTO userDTO) {
        this.nickName = nickName;
        this.score = score;
        this.userDTO = userDTO;
        this.theme = theme;
    }

    public PlayerDTO(Long id, String nickName, Integer score, String theme, UserDTO userDTO) {
        this.id = id;
        this.nickName = nickName;
        this.score = score;
        this.theme = theme;
        this.userDTO = userDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public UserDTO getUser() {
        return userDTO;
    }

    public void setUser(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


    public ArrayList<QuestionDTO> getPlayerQuestionsDTOList() {
        return playerQuestionsDTOList;
    }

    public void setPlayerQuestionsDTOList(ArrayList<QuestionDTO> playerQuestionsDTOList) {
        this.playerQuestionsDTOList = playerQuestionsDTOList;
    }

    public QuestionDTO getCurrentPlayerQuestionDTO() {
        return currentPlayerQuestionDTO;
    }

    public QuestionAlternativeDTO getSelectedQuestionAlternative() {
        return selectedQuestionAlternative;
    }

    public void setSelectedQuestionAlternative(QuestionAlternativeDTO selectedQuestionAlternative) {
        this.selectedQuestionAlternative = selectedQuestionAlternative;
    }


    public void setCurrentPlayerQuestion(QuestionDTO currentPlayerQuestionDTO) {
        this.currentPlayerQuestionDTO = currentPlayerQuestionDTO;
    }

    public void setCurrentPlayerQuestionDTO(QuestionDTO currentPlayerQuestionDTO) {
        this.currentPlayerQuestionDTO = currentPlayerQuestionDTO;
    }

    public Long getCurrentQuestionID() {
        return currentQuestionID;
    }

    public void setCurrentQuestionID(Long currentQuestionID) {
        this.currentQuestionID = currentQuestionID;
    }

    public Long getSelectedQuestionAlternativeID() {
        return selectedQuestionAlternativeID;
    }

    public void setSelectedQuestionAlternativeID(Long selectedQuestionAlternativeID) {
        this.selectedQuestionAlternativeID = selectedQuestionAlternativeID;
    }

    @Override
    public String toString() {
        return "\n\nPlayerDTO - id: " + id +
                "\nNickName='" + nickName +
                "\nScore=" + score +
                "\nUserDTO=" + userDTO +
                "\nTheme=" + theme +
                "\nCurrent Question: " + currentPlayerQuestionDTO +
                "\nSelectedQuestionAlternative: " + selectedQuestionAlternative +
                "\ncurrentQuestionID: " + currentQuestionID +
                "\nselectedQuestionAlternativeID = " + selectedQuestionAlternativeID;
    }
}
