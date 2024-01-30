package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SuggestionEngineTest {



    // Test 1 - Ensure words.txt exists.
    @Test
    public void testWordsFileExists() {
        Path wordsFile = Paths.get("src/main/resources/words.txt");
        Assertions.assertTrue(Files.exists(wordsFile));
    }

    // Test 2 - Ensure setSuggestionsDatabase() setter works as intended.
    @Test
    public void testSetSuggestionsDatabase() {
        SuggestionEngine testSuggestionEngine = new SuggestionEngine();

        SuggestionsDatabase testSuggestionsDatabase = new SuggestionsDatabase();
        testSuggestionsDatabase.getWordMap().put("test", 1);
        testSuggestionEngine.setWordSuggestionDB(testSuggestionsDatabase);
        Map<String, Integer> testMap = testSuggestionEngine.getWordSuggestionDB();

        Map<String, Integer> comparisonMap = new HashMap<>();
        comparisonMap.put("test", 1);

        assertEquals(comparisonMap, testMap);
    }

    // Test 3 - Ensure GenerateSuggestions() works as intended.
    @Test
    public void testGenerateSuggestions() {
        SuggestionEngine testSuggestionEngine = new SuggestionEngine();

        SuggestionsDatabase testSuggestionsDatabase = new SuggestionsDatabase();
        testSuggestionsDatabase.getWordMap().put("taste", 1);
        testSuggestionEngine.setWordSuggestionDB(testSuggestionsDatabase);

        String testString = testSuggestionEngine.generateSuggestions("taste");

        assertEquals("", testString);

    }}







