package edu.neu.coe.info6205.util;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ChineseStringUtil {


    public static String[] convertChineseToPinyin(String filePath,  HashMap<String, String> pinyinToChineseMap) throws FileNotFoundException {
        List<String> output = new ArrayList<String>();
        try {
            File shuffledChinese = new File(filePath);
            BufferedReader shuffledChineseReader = new BufferedReader(new FileReader(shuffledChinese));
            HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
            format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
            String s;
            while ((s = shuffledChineseReader.readLine()) != null) {
                char[] ca = s.toCharArray();
                String[] pinyinOutput=new String[ca.length];
                for (int c=0; c<ca.length;c++){
                    String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(ca[c], format);
                    if(pinyinArray != null){
                        pinyinOutput[c]=pinyinArray[0];
                    }
                }
                StringBuilder builder = new StringBuilder();
                String finalOutput;
                for (String pinyinOutput1 : pinyinOutput) {
                    if (pinyinOutput1 == "null") {
                        continue;
                    }
                    builder.append(pinyinOutput1);
                    builder.append(" ");
                }
                finalOutput=builder.toString();
                output.add(finalOutput);
                pinyinToChineseMap.put(finalOutput, s);
            }
            String[] pinyinOutputArray = new String[ output.size() ];
            output.toArray( pinyinOutputArray );
            return pinyinOutputArray;
        } catch (FileNotFoundException exception) {
            System.out.println("File Not found error");
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String[] convertPinyinToChinese (String[] pinyin, HashMap<String, String> pinyinToChineseMap) {
        String[] chineseArray = new String[pinyin.length];
        for (int i = 0; i< pinyin.length; i++) {
            chineseArray[i] = pinyinToChineseMap.get(pinyin[i]);
        }

        return chineseArray;
    }

    public static void writeResultFile(String outputPath, String[] chineseArray) throws IOException {
        FileWriter sortedChineseWriter = new FileWriter(outputPath);
        for (String elem: chineseArray) {
            sortedChineseWriter.write(elem);
            sortedChineseWriter.write(System.getProperty( "line.separator" ));
        }

        sortedChineseWriter.close();
    }


}