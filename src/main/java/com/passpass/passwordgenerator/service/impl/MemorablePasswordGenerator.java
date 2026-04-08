package com.passpass.passwordgenerator.service.impl;

import com.passpass.passwordgenerator.dto.impl.MemorablePasswordRequest;
import com.passpass.passwordgenerator.service.PasswordGenerator;
import com.passpass.passwordgenerator.utils.constants.CommonConstants;
import com.passpass.passwordgenerator.utils.constants.WordlistFileReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Component
public class MemorablePasswordGenerator implements PasswordGenerator <MemorablePasswordRequest>{

    private static final SecureRandom RANDOM = new SecureRandom();
    private final WordlistFileReader wordList;

    public MemorablePasswordGenerator(WordlistFileReader wordList) {
        this.wordList = wordList;
    }

    @Override
    public String getType(){return "MEMORABLE";}

    @Override
    public Class<MemorablePasswordRequest> getRequestType(){
        return MemorablePasswordRequest.class;
    }

    @Override
    public String generatePassword(MemorablePasswordRequest request){
        validateRequest(request);

        int wordCount = request.getWordCount();
        String separator = request.getSeparator() == null ? "-" : request.getSeparator();

        List<String> selectedWords = new ArrayList<>();

        for(int i =0; i<wordCount;i++){
            String word = getRandomWord(i);
            if(request.isCapitalizeWords()){
                word = capitalize(word);
            }
            selectedWords.add(word);
        }
        String password = String.join(separator, selectedWords);

        if (request.isLeet()) {
            password = applyLeet(password);
        }

        if (request.isIncludeNumbers()) {
            password = insertAtRandomPosition(password,getRandomNumber());
        }

        if (request.isIncludeSymbols()) {
            password = insertAtRandomPosition(password,getRandomSymbol());
        }

        return password;
    }


    private String getRandomWord(int index){
        if(index % 2 ==0){
            return getRandomElement(wordList.getAdjectives());
        }
        return getRandomElement(wordList.getNouns());
    }

    private String capitalize(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    private String getRandomSymbol() {
        return String.valueOf(CommonConstants.SYMBOLS.charAt(RANDOM.nextInt(CommonConstants.SYMBOLS.length())));
    }

    private String getRandomElement (List<String> words){
        return words.get(RANDOM.nextInt(words.size()));
    }

    private String getRandomNumber() {
        return String.valueOf(RANDOM.nextInt(10));
    }

    private String insertAtRandomPosition(String text,String value){
        int index = RANDOM.nextInt(text.length()+1);
        return text.substring(0,index) + value + text.substring(index);
    }

    private String applyLeet(String word) {
        return word
                .replace('a', '@')
                .replace('e', '3')
                .replace('i', '1')
                .replace('o', '0')
                .replace('s', '$');
    }

    private void validateRequest(MemorablePasswordRequest request){
        if (request == null){
            throw new IllegalArgumentException("Request cannot be null");
        }
        if (request.getWordCount() <= 0){
            throw new IllegalArgumentException("Word count must be greater than 0");
        }
        if (wordList.getAdjectives() == null || wordList.getAdjectives().isEmpty()) {
            throw new IllegalStateException("Adjective word list is empty");
        }
        if (wordList.getNouns() == null || wordList.getNouns().isEmpty()) {
            throw new IllegalStateException("Noun word list is empty");
        }
    }
}
