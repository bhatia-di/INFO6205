package edu.neu.coe.info6205.util;

import io.cucumber.java.bs.A;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class ChineseStringUtilTest {
    @Test
    public void testConvertChineseToPinyinWithValidChineseInput() throws FileNotFoundException {
        String basePath = "D:\\PSA\\INFO6205\\src\\test\\java\\edu\\neu\\coe\\info6205\\util\\testFiles\\";

        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(basePath + "chineseTest.txt", new HashMap<String, String>());
        Assert.assertTrue(pinyin.length == 4);

    }

    @Test
    public void testConvertChineseToPinyinWithNullInput() {
        String basePath = "D:\\PSA\\INFO6205\\src\\test\\java\\edu\\neu\\coe\\info6205\\util\\testFiles\\";

        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(basePath + "emptyTest.txt", new HashMap<String, String>());
        Assert.assertTrue(pinyin.length == 0);

    }

    @Test
    public void testConvertChineseToPinyinWithNoInputFile() {
        String basePath = "D:\\PSA\\INFO6205\\src\\test\\java\\edu\\neu\\coe\\info6205\\util\\testFiles\\";
        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(basePath + "doesnotexist.txt", new HashMap<String, String>());

    }

    @Test
    public void testConvertChineseToPinyinWithNonChineseInputFile() {
        String basePath = "D:\\PSA\\INFO6205\\src\\test\\java\\edu\\neu\\coe\\info6205\\util\\testFiles\\";
        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(basePath + "hindiChineseTest.txt", new HashMap<String, String>());

        Assert.assertTrue(pinyin.length == 3);

   }
    @Test
    public void testPinyinToChinese() {
        String basePath = "D:\\PSA\\INFO6205\\src\\test\\java\\edu\\neu\\coe\\info6205\\util\\testFiles\\";
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(basePath + "hindiChineseTest.txt", hashMap);

        String[] output = ChineseStringUtil.convertPinyinToChinese(pinyin, hashMap);
        Assert.assertTrue(hashMap.size() == 3);
        Assert.assertTrue(output.length == 3);

    }

    @Test
    public void testWriteResult() throws IOException {
        String basePath = "D:\\PSA\\INFO6205\\src\\test\\java\\edu\\neu\\coe\\info6205\\util\\testFiles\\";

        ChineseStringUtil.writeResultFile(basePath + "result.txt", new String[]{"Test", "Test1"});

        Assert.assertTrue(new File(basePath + "result.txt").exists());
    }


}
