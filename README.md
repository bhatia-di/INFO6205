###### **#INFO6205-project-sorting-Chinese-string**

1. Benchmark & Sort Chinese Characters Class File: [BenchmarkAndSortChineseText.java](https://github.com/bhatia-di/INFO6205/blob/final-project-sort-chinese/src/main/java/edu/neu/coe/info6205/finalProject/BenchmarkAndSortChineseText.java)
2. Inorder to run for different chinese text files, we update the value basePath & inputPath on line 22, 23 in [BenchmarkAndSortChineseText.java](https://github.com/bhatia-di/INFO6205/blob/final-project-sort-chinese/src/main/java/edu/neu/coe/info6205/finalProject/BenchmarkAndSortChineseText.java)
3. Experiment results are stored in [Sorting_results.xslx]([BenchmarkAndSortChineseText.java](https://github.com/bhatia-di/INFO6205/blob/final-project-sort-chinese/src/main/java/edu/neu/coe/info6205/finalProject/sortComparison.xlsx))
4. Sorted chinese names are stored in output folder [sortedChinese.txt](https://github.com/bhatia-di/INFO6205/blob/final-project-sort-chinese/src/main/java/edu/neu/coe/info6205/finalProject/sortedChinese.txt)
5. Different sorting methods are included in this repo:
   1. LSD radix sort 
   2. MSD radix sort 
   3. Dual-pivot quicksort
   4. HuskySort used as jar dependency for this project [link_here](https://github.com/rchillyard/The-repository-formerly-known-as)
   5. Reference: https://arxiv.org/abs/2012.00866 by R.C. Hillyard
   
6. Unit tests are located under [test folder](https://github.com/bhatia-di/INFO6205/blob/final-project-sort-chinese/src/test/java/edu/neu/coe/info6205/util/ChineseStringUtilTest.java)
7. Link to [report](https://github.com/bhatia-di/INFO6205/blob/final-project-sort-chinese/src/reports/PSA%20Final%20Group%20Report.pdf)
8. Link to [literature survey](https://github.com/bhatia-di/INFO6205/blob/final-project-sort-chinese/src/reports/PSA%20Final%20Group%20Report.pdf) 

**#Test case Explanation**
1. testConvertChineseToPinyinWithValidChineseInput:  Asserts that tests output produces array of pinyin size of 4 with valid Input
2. testConvertChineseToPinyinWithNullInput: Asserts that tests that output produces array of pinyin size of 0 with empty text file
3. testConvertChineseToPinyinWithNoInputFile: Asserts that it throws File Not found exception when incorrect file input to the system
4. testConvertChineseToPinyinWithNonChineseInputFile: Assert that the logic would ignore any characters that were added as non chinese characters in the input
5. testPinyinToChinese: Assert that all pinyin values are converted to Chinese string

