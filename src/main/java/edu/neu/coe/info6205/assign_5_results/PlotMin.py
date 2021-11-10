import pandas as pd
import matplotlib


df1 = pd.read_csv("./result_thread_count_2_arraySize_2000000.csv", index_col=None, header=0, names=['x', 'y'])
df2 = pd.read_csv("./result_thread_count_2_arraySize_3000000.csv", index_col=None, header=0, names=['x', 'y'])


ax = df1.plot()
df2.plot(ax=ax)
