
# What is Pandas, Series, DataFrame and Panel?

**Pandas** offers flexible data structures such as Series, DataFrame and Panels that make data manipulation and analysis easy.
* https://pandas.pydata.org/
<br><br>

**Data Structures**: Read about the various data structures in Pandas.
* https://pandas.pydata.org/pandas-docs/stable/getting_started/dsintro.html
<br><br>

**Series**: is a <u>a 1D labelled data structure</u> (or just a column).
* https://pandas.pydata.org/pandas-docs/version/0.23.4/generated/pandas.Series.html
<br><br>

**DataFrame**: is a <u>2D labeled data structure</u>, usually containing <u>multiple Series</u> representing different columns.
* https://pandas.pydata.org/pandas-docs/version/0.23.4/generated/pandas.DataFrame.html
<br><br>

**Panel**: is a <u>3D labeled data structure</u> usually containing <u>multiple DataFrames</u>.
* https://pandas.pydata.org/pandas-docs/version/0.23.4/generated/pandas.Panel.html
<br><br>


# Pandas Conventions

```
import pandas as pd
df = pd.DataFrame()
```

* **pd** is short for pandas
* **df** is a variable name for a DataFrame


# DataFrame Format

|house_id   |day   |date |visits   |available   |income   |
|---|---|---|---|---|---|
|int|int|str|int|int|int|


# Create and Fill a DataFrame
```diff
df = pd.DataFrame()
df["myColumn"] = [5,3,4,6,7]
df["anotherColumn"] = [6,3,7,10,45]
```
* A DataFrame is normally constructed by reading a file, for example CSV, rather than manually.


# Read CSV

### Infer Schema
```
df = pd.read_csv('RegressionData1_10_000.csv', sep=';')
```
* It might lead to complications to infer the datatype schema.
* The parameters "**sep**" and "**delimiter**" is the same.


### Specfied Schema
```
schema = {
    'house_id': int,
    'date': str,
    'income': int
}

df = pd.read_csv('RegressionData1_10_000.csv', delimiter=';', encoding='utf-8',
                  header=0, dtype=schema, decimal='.')
```

* **delimiter**: (*str*) Separates columns using ' ; '.
* **encoding**: (*str*) specified encoding.
* **header**: (*int*) row number to use as header.
* **dtype**: (*dict*) Specifies datatypes for given columns. Other columns are inferred.
* **index_col**: (*int*) Column index to use as the row labels of the DataFrame.
* **decimal**: (*str*) Define decimal character (',' for Europe and '.' for USA).


# Read Parquet
```
df = pd.read_parquet('sample_data.parquet')
```


# Read ARFF
```
from scipy.io import arff

data_arff = arff.loadarff("another_dataset.arff")
df_arff = pd.DataFrame(data_arff[0])
```

# Read Excel
```
df = pd.read_excel('my_file.xlsx')
```


# Datatypes in DataFrame
```
df.dtypes
```


# Write / Save to CSV
```
df.to_csv('Small_DataFrame.csv', sep=';', index=False)
```


# Convert to JSON
```
my_json = df.to_json()
```


# Rename Columns
```
df_renamed = df.rename(
    columns={
        'house_id' : 'my_id',
        'day': 'day_new'
    }
)
```


# Statistics
```
df.describe()
```
This will calculate statistics about the DataFrame such as:
* count
* mean
* std
* min
* max


# Display / Show
```
print(df)
```

# Display all columns of DataFrame
```
pd.set_option('display.expand_frame_repr', False)
```

# Get First and Last rows
```
df.head(5)
```
```
df.tail(5)
```


# Get Row(s)
```
df_row = df.iloc[5]
```
```
df_multi_rows = df[4:9]
```

<br>

```
df_multi_rows = df[df.house_id < 100]
```
```
df_multi_rows = df[(df.house_id < 100) & (df.house_id > 50) | (df.house_id == 50)]
```


# Get column(s)
```
series_col = df["house_id"]
```
* series_col is a Series, <u>not a DataFrame</u>
```
my_col = "house_id"
series_col = df[my_col]
```
* get column using variable
```
df_multi_col = df[["house_id", "date", "income"]]
```


# Random Sampling
```
df_samples = df.sample(42, replace=False)
```
* **replace**: (*bool*) whether sampling with replacement. *False by default*.


# Delete Column(s)
```
df = df.drop('col1', axis=1)
```
* Drops column *col1*.

```
df = df.drop(columns=["day", "date", "available"])
```
* Drops *day*, *date* and *available*.

```
df = df[["col", "col2", "col3"]])
```
* Keep *col1*, *col2* and *col3*.


# Delete Row(s)
```
df = df.drop([1, 4, 5, 7])
```
```
df = df[df.house_id < 100]
```
```
df = df[(df.house_id < 100) & (df.house_id > 50) | (df.house_id == 50)]
```


# Add / Append Series / Row to DataFrame
```
df = df.append(my_series)
```


# Concatenate List of DataFrames
```
df = pd.concat([df1, df2])
```


# Remove Random Rows
```
indexes = df.sample(100).index
df = df.drop(indexes)
```


# Replace Value
```
df = df.replace(np.nan, 10)
```
```
df = df.replace([True, False], [1, 0])
```


# Iterate / Loop rows and cells in DataFrame
```
for row in df.itertuples():
    for cell in row:
        print(cell)
```
```
for index, row in df.iterrows():
    for cell in row:
        print(cell)
```


# Iterate / Loop columns and cells in DataFrame
```
for col in df.columns:
    col_series = df[col]
    df[col] = myFunction(col_series)
```


# NotNull vs IsNull
```
# Map the notnull function for each cell in df. 
df_bool_vals = df.notnull()
```
```
# Map the isnull function for each cell in df. 
df_bool_vals = df.isnull()
```


# All vs Any - Merge boolean values in DataFrame
```
# Merge bool columns using AND operator.
df2 = df.notnull().all(axis=1)
```
```
# Merge bool rows using OR operator. 
df2 = df.isnull().any(axis=1)
```


# Get DataFrame rows given a Series with boolean values
```
series_bool = df.notnull().all(axis=1)
df2 = df[series_bool]
```
* Returns rows from df that does not contain any NaN values. 


# DateTime
```
myDateTime = pd.to_datetime('13000101', format='%Y%m%d')
```
```
df['date'] = pd.to_datetime(df['date'], format='%d%m%Y')
```


# Sort / Order by
```
df_sorted = df.sort_values(["house_id", "income"], ascending=True)
```


# Filter with Condition(s)
```
df_filtred = df[df.house_id > 5]
```
```
df_filtred = df[
    (df.house_id > 5) &
    (df.house_id < 10) &
    (df.available == 1) &
    (df.income < 3500)
]
```
```
df[(df > 5).any(axis=1)]
```


# Query with Condition(s)
```
df_queried = df.query('house_id > 5')
```
```
df_queried = df.query('house_id > 5 & house_id < 10 | house_id == 1')
```


# Merge / Join DataFrames
```
df = df.merge(df2, how='inner', on='house_id')
```

* This line is similar to the following SQL statement:
```
SELECT *
FROM df INNER JOIN df2 ON df.house_id = df2.house_id
```

```
df = df.merge(
    right=df2,
    how='inner',
    left_on='house_id',
    right_on='house_id',
    suffixes=(_df1’, ‘_df2’)
)
```
* **right**: (*DataFrame*) the "right" DataFrame in the join.
* **how**: (*str*) supports "left", "right", "outer", "inner". *default=inner*
* **on**: (*str*) column to join on in both DataFrames.
* **left_on**: (*str*) column to join on for the <u>left</u> DataFrame.
* **right_on**: (*str*) column to join on for the <u>right</u> DataFrame.
* **suffixes**: (*(str, str)*) suffixes for columns with the same name. *default is (‘_x’, ‘_y’)*.


# Groupby
```
df_grouped_max = df.groupby(['house_id']).max()
```
```
df = df.groupby('house_id', as_index=False).agg({
    'myCol1': 'min',
    'myCol2': 'max',
    'myCol3': 'sum',
})
```
* **as_index**: (*bool*) if columns that are not used for aggregation should be used as index. *Default is True*.


# Popular Aggregation Functions
```
mean(), median(), sum(), size(), count(), min(), max(), std(), var()
```


# Conditional Cell Values
```
df2 = df.col1 > 5
```

```
df2 = (df.col1 > 5) & (df.col1 < 10)
```
* This produces a DataFrame containing cells with **True/False** indicating whether each cell fulfills the condition or not.

```
df2 = df > 5
```
* Can be used on an entire DataFrame


# Apply / Map with Lambda function
**Map** can only be used on Series, not a DataFrame. 
```
df['col1'] = df['col1'].map(lambda x: 1 if x > 10 else 0)
```
```
df['col1'] = df['col1'].map(lambda x: my_function(x))
```

<br>

**Apply** can be used on a Series or a DataFrame. 

It is similar to Map, but can be used on Dataframes. 

The parameter "axis" are used to spesify which axis to apply the map function. 

Axis=0 means apply the function on each column. 

Axsis=1 means apply the function on each row. 
```
df = df.apply(lambda df_row: my_function(df_row), axis=1)
```
```
df = df.apply(lambda df_row: my_function(a=df_row['col1'], df_row['col2']), axis=1)
```

<br>

A condition can be applied on the entire DataFrame, which will map the condition for each cell in the DataFrame. 
The result is a DataFrame containing boolean values that indicated wether the cell fulfils the condition. 

```
df_bool_vals = df == 5
```

# Loc modify with boolean condition
Changes all values in column *col* from *J* to *1*
```
df.loc[df[col] == 'J', col] = '1'
```

# Dummy Column
```
df = pd.get_dummies(df, columns=['col1'])
```
* This will produce additional columns for all unique values in the specified column *col1*. The additional columns will be one-hot-encoded for each row in the DataFrame indicating if the row has the unique value that each column represents.
* This process can be followed by a groupby function to aggregate the additional column values. These two operations function similarly as a pivot table.


# Pivot Table
```
df = pd.pivot_table(df, values='col3', index=['col1', 'col2'],
                    columns=['col4'], aggfunc=np.sum)
```
* This will pivot the dataframe on column *col3* and aggregate *col4* with *sum* and use *col1* and *col2* as indexes.
* Pivoting is the same as dummy-ing a column followed by a groupby.


# Fillna
Replaces NaN values with specified value (0 in these examples).
```
df = df.fillna(0)
```
```
df['col1'] = df['col1'].fillna(0)
```
```
df[['col1', 'col2', 'col3'] = df[['col1', 'col2', 'col3'].fillna(0)
```
```
df[['col1', 'col2', 'col3'].fillna(0, inplace==True)
```
* **inplace**:  (*bool*) if the DataFrame should be replaced.

# Reset Index
Resets the indexes of a DataFrame.
```
df = df.reset_index()
```
We can add *drop=True* to dop the old indexes.

# Remove Duplicates / Distinct
```
df = df.drop_duplicates()
```

# Examples
```
df2 = pd.DataFrame()
for index, row in df.iterrows():
    has_none = False
    for v in row:
        if pd.isnull(v):
            has_none = True
            break
    if not has_none:
        print(row)
        df2 = df2.append(row)
```
* This statement could be simplified and is just an ilustration of what is possible. 

```
df = pd.DataFrame()
df['A'] = [1,    7, 4,    2,    6]
df['B'] = [None, 3, None, 6,    8]
df['C'] = [4,    3, None, None, 1]

# Get rows with no NaN values.
df2 = df[df.notnull().all(axis=1)]

# Get rows with at least one column with NaN.
df3 = df[df.isnull().any(axis=1)]
```


# Usefull functions 

### Shuffle series
```
from random import shuffle
def shuffle_series(series):
    thelist = series.tolist()
    shuffle(thelist)
    return pd.Series(thelist)
```

### Shuffle columns in df
```
def shuffle_each_column_in_df(df):
    for col in df.columns:
        df[col] = shuffle_series(df[col])
    return df
```

### Check if a series contains unique values
```
def is_row_unique(my_series):
    for val in list(my_series):
        pos_is_equal = [1 for x in list(row) if x == val]
        if sum(pos_is_equal) > 1:
            # At least two column values are equal, so the row is not unique. 
            return False
    return True
```

### Check if each row in a DataFrame contains unique values
```
def is_rows_unique(df):
    for index, row in df.iterrows():
        if not is_row_unique(row.tolist()):
            return False
    return True
```

### Swap items in a Series
```
def swap_items_in_series(series, index1=None, index2=None):
    series_list = list(series)
    if index1 == None and index2 == None:
        index1 = random.choice(range(len(series_list)))
        index2 = index1
        while index2 == index1:
            index2 = random.choice(range(len(series_list)))
    # Swap items in list. 
    tmp = series_list[index1]
    series_list[index1] = series_list[index2]
    series_list[index2] = tmp
    return pd.Series(series_list)
```

### Swap random items in a Series
```
def swap_rnd_items_in_rnd_column(df):
    rnd_col = random.choice(df.columns)
    df[rnd_col] = swap_items_in_series(df[rnd_col])
    return df
```

