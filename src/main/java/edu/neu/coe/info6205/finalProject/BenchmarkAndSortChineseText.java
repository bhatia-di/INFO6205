package edu.neu.coe.info6205.finalProject;

import edu.neu.coe.huskySort.sort.huskySort.PureHuskySort;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.counting.LSDStringSort;
import edu.neu.coe.info6205.sort.counting.MSDStringSort;
import edu.neu.coe.info6205.sort.linearithmic.QuickSort_DualPivot;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.ChineseStringUtil;
import edu.neu.coe.info6205.util.Config;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import org.ini4j.Ini;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BenchmarkAndSortChineseText {
    static HashMap<String, String>  both= new HashMap<String, String>();

    private static Ini ini = new Ini();
    private static Config config = new Config(ini);
    private static edu.neu.coe.huskySort.util.Config con = new edu.neu.coe.huskySort.util.Config(ini);
    public static Integer cnt = 0;
    public static String names = "";

    public static void sortChineseArrayWithMSDSort() throws FileNotFoundException {
        HashMap<String, String>  pinyinToChineseMap= new HashMap<String, String>();
        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(pinyinToChineseMap);
        MSDStringSort.sort(pinyin);
        String[] output = ChineseStringUtil.convertPinyinToChinese(pinyin, pinyinToChineseMap);
    }


    public static void sortChineseArrayWithLSDSort() throws FileNotFoundException {
        LSDStringSort lsd = new LSDStringSort();
        HashMap<String, String>  pinyinToChineseMap= new HashMap<String, String>();
        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(pinyinToChineseMap);
        lsd.sort(pinyin);
        String[] output = ChineseStringUtil.convertPinyinToChinese(pinyin, pinyinToChineseMap);
    }

    public static void sortChineseArrayWithDualPivotSort() throws FileNotFoundException {
        HashMap<String, String>  pinyinToChineseMap= new HashMap<String, String>();
        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(pinyinToChineseMap);
        Helper help = new BaseHelper<>("Dual-Pivot quicksort", pinyin.length, new Config(ini));
        QuickSort_DualPivot<String> quickSort = new QuickSort_DualPivot<>(help);
        quickSort.sort(pinyin,true);
        String[] output = ChineseStringUtil.convertPinyinToChinese(pinyin, pinyinToChineseMap);
    }


    public static void sortChineseArrayWithHuskySort() throws FileNotFoundException {
        HashMap<String, String>  pinyinToChineseMap= new HashMap<String, String>();
        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(pinyinToChineseMap);
        PureHuskySort<String> sorter = new PureHuskySort<>(HuskyCoderFactory.unicodeCoder, false, false);
        sorter.sort(pinyin);
        String[] output = ChineseStringUtil.convertPinyinToChinese(pinyin, pinyinToChineseMap);
    }



    public static void main(String[] args) {

        Benchmark_Timer MSDbenchmark = new Benchmark_Timer("MSDsort", b -> {
            try {
                sortChineseArrayWithMSDSort();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        double MSDSortRunTime = MSDbenchmark.run(null, 1);
        System.out.println("Run time for MSDRadixsort  :  " + MSDSortRunTime);

        cnt=1;
        Benchmark_Timer LSDbenchmark = new Benchmark_Timer("LSDsort", b -> {
            try {
                sortChineseArrayWithLSDSort();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        double LSDSortRunTime = LSDbenchmark.run(null, 1);
        System.out.println("Run time for LSDRadixsort  :  " + LSDSortRunTime);

        cnt=2;
        Benchmark_Timer QuickSortDualPivot = new Benchmark_Timer("QuickSortDualPivot", b -> {
            try {
                sortChineseArrayWithDualPivotSort();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        double QSDPRunTime = QuickSortDualPivot.run(null, 1);
        System.out.println("Run time for QuickSortDualPivot  :  " + QSDPRunTime);

        cnt=3;
        Benchmark_Timer PureHuskySort = new Benchmark_Timer("PureHuskySort", b -> {
            try {
                sortChineseArrayWithHuskySort();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        double PHSRunTime = PureHuskySort.run(null, 1);
        System.out.println("Run time for PureHuskySort  :  " + PHSRunTime);
    }


    public HashMap<String, String> getChineseMap() {
        return both;
    }
}
