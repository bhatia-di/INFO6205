package edu.neu.coe.info6205.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class ChineseStringUtilTest {
    @Test
    public void testConvertChineseToPinyinWithValidChineseInput() throws FileNotFoundException {
        String basePath = "D:\\PSA\\INFO6205\\src\\test\\java\\edu\\neu\\coe\\info6205\\util\\testFiles\\";

        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(basePath + "chineseTest.txt", new HashMap<String, String>());
        Assert.assertTrue(pinyin.length == 4);

    }

    @Test
    public void testConvertChineseToPinyinWithNullInput() throws FileNotFoundException {
        String basePath = "D:\\PSA\\INFO6205\\src\\test\\java\\edu\\neu\\coe\\info6205\\util\\testFiles\\";

        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(basePath + "emptyTest.txt", new HashMap<String, String>());
        Assert.assertTrue(pinyin.length == 0);

    }

    @Test(expected = FileNotFoundException.class)
    public void testConvertChineseToPinyinWithNoInputFile() throws FileNotFoundException {
        String basePath = "D:\\PSA\\INFO6205\\src\\test\\java\\edu\\neu\\coe\\info6205\\util\\testFiles\\";
        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(basePath + "doesnotexist.txt", new HashMap<String, String>());

    }

    @Test
    public void testConvertChineseToPinyinWithNonChineseInputFile() {
        String basePath = "D:\\PSA\\INFO6205\\src\\test\\java\\edu\\neu\\coe\\info6205\\util\\testFiles\\";
        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(basePath + "doesnotexist.txt", new HashMap<String, String>());

    }
}
