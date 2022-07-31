package com.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class BracketCheckerTest {
    @Test
    public void checkBracket() {
        BracketChecker bracketChecker = new BracketChecker("{a[sss(dddddddd)sss]bc}");
        bracketChecker.checkBracket();
        bracketChecker = new BracketChecker("{a[sss(ddddddddsss]bc)eeeee}");
        bracketChecker.checkBracket();
    }
}