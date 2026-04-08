package com.passpass.passwordgenerator.utils.constants;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static com.passpass.passwordgenerator.utils.constants.CommonConstants.WORDLIST_ADJECTIVES_FILEPATH;
import static com.passpass.passwordgenerator.utils.constants.CommonConstants.WORDLIST_NOUNS_FILEPATH;

@Component
public class WordlistFileReader {

    private List<String> adjectives;
    private List<String> nouns;

    public WordlistFileReader() throws IOException {
        this.adjectives = readLines(CommonConstants.WORDLIST_ADJECTIVES_FILEPATH);
        this.nouns = readLines(CommonConstants.WORDLIST_NOUNS_FILEPATH);
    }

    private List<String> readLines(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new ClassPathResource(path).getInputStream()))) {
            return reader.lines().toList();
        }
    }

    public List<String> getAdjectives() {
        return adjectives;
    }

    public List<String> getNouns() {
        return nouns;
    }

}
