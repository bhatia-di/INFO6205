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
import org.ini4j.Ini;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class BenchmarkAndSortChineseText {

    private static Ini ini = new Ini();
    private static Config config = new Config(ini);
    private static edu.neu.coe.huskySort.util.Config con = new edu.neu.coe.huskySort.util.Config(ini);
    private static String basePath = "D:\\PSA\\PSA Final Project\\Sorted Chinese Text\\";
    private static String fileInputPath  = "shuffledChinese.txt";
    private static String fileOutputPath  = "sortedChinese.txt";

    public static void sortChineseArrayWithMSDSort() throws FileNotFoundException {
        HashMap<String, String>  pinyinToChineseMap= new HashMap<String, String>();
        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(basePath + fileInputPath, pinyinToChineseMap);
        MSDStringSort.sort(pinyin);
        String[] output = ChineseStringUtil.convertPinyinToChinese(pinyin, pinyinToChineseMap);
    }


    public static void sortChineseArrayWithLSDSort() throws FileNotFoundException {
        LSDStringSort lsd = new LSDStringSort();
        HashMap<String, String>  pinyinToChineseMap= new HashMap<String, String>();
        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(basePath + fileInputPath,pinyinToChineseMap);
        lsd.sort(pinyin);
        String[] output = ChineseStringUtil.convertPinyinToChinese(pinyin, pinyinToChineseMap);
    }

    public static void sortChineseArrayWithDualPivotSort() throws FileNotFoundException {
        HashMap<String, String>  pinyinToChineseMap= new HashMap<String, String>();
        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(basePath + fileInputPath, pinyinToChineseMap);
        Helper help = new BaseHelper<>("Dual-Pivot quicksort", pinyin.length, new Config(ini));
        QuickSort_DualPivot<String> quickSort = new QuickSort_DualPivot<>(help);
        quickSort.sort(pinyin,true);
        String[] output = ChineseStringUtil.convertPinyinToChinese(pinyin, pinyinToChineseMap);
    }


    public static void sortChineseArrayWithHuskySort() throws FileNotFoundException {
        HashMap<String, String>  pinyinToChineseMap= new HashMap<String, String>();
        String[] pinyin = ChineseStringUtil.convertChineseToPinyin(basePath + fileInputPath, pinyinToChineseMap);
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

        Benchmark_Timer LSDbenchmark = new Benchmark_Timer("LSDsort", b -> {
            try {
                sortChineseArrayWithLSDSort();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        double LSDSortRunTime = LSDbenchmark.run(null, 1);
        System.out.println("Run time for LSDRadixsort  :  " + LSDSortRunTime);

        Benchmark_Timer QuickSortDualPivot = new Benchmark_Timer("QuickSortDualPivot", b -> {
            try {
                sortChineseArrayWithDualPivotSort();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        double QSDPRunTime = QuickSortDualPivot.run(null, 1);
        System.out.println("Run time for QuickSortDualPivot  :  " + QSDPRunTime);

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


}
