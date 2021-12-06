#INFO6205-project-sorting-Chinese-string

1. Benchmark & Sort Chinese Characters Class File: [BenchmarkAndSortChineseText.java](https://github.com/bhatia-di/INFO6205/blob/final-project-sort-chinese/src/main/java/edu/neu/coe/info6205/finalProject/BenchmarkAndSortChineseText.java)
2. Inorder to run for different chinese text files, we update the value basePath & inputPath on line 22, 23 in [BenchmarkAndSortChineseText.java](https://github.com/bhatia-di/INFO6205/blob/final-project-sort-chinese/src/main/java/edu/neu/coe/info6205/finalProject/BenchmarkAndSortChineseText.java)
3. Experiment results are stored in [Sorting_results.xslx]([BenchmarkAndSortChineseText.java](https://github.com/bhatia-di/INFO6205/blob/final-project-sort-chinese/src/main/java/edu/neu/coe/info6205/finalProject/sortComparison.xlsx))
4. Sorted chinese names are stored in output folder [sortedChinese.txt]()
6 different sorting methods are included in this repo
LSD radix sort
MSD radix sort
MSD radix sort with 8 bits bucket
MSD radix sort with 16 bits bucket
MSD radix sort with cache improvement (8 bits)
Quicksort
Dual-pivot quicksort
Timsort
HuskySort
Code copied from HuskySort original repo with slight modification
Paper: https://arxiv.org/abs/2012.00866 by R.C. Hillyard
Benchmark class copied from INFO6205 repo for assignment 2
Unit tests are located under test folder

