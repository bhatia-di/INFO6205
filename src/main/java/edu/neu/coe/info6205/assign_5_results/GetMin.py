import pandas as pd

df=pd.read_csv('./result_thread_count_2_arraySize_2000000.csv', names = ['x', 'y'])
print(df.columns)

#FINDING MAX AND MIN
p=df['y'].max()
q=df['y'].min()


print(q)