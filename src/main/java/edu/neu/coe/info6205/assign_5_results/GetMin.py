import pandas as pd
import glob

path = './' # use your path
all_files = glob.glob(path + "/*.csv")


for filename in all_files:
    df = pd.read_csv(filename, index_col=None, header=0, names=['x', 'y'])
    print("File Name: " , filename , " -- ",  df[df['y'] == df['y'].min()])
