
# BERT
* Bidirectional Encoder Representations from Transformers (BERT)
* Transformer based models in NLP
* Published in 2018 by Google


### Huggingface
* Ai community for building and sharing ML-models
* Contians NLP models such as transformer models


### Example: NorBERT Embeddings
https://huggingface.co/ltgoslo/norbert

```python
def padding(token_ids_list, max_num_tokens):
    """
    Pad according to maximum number of tokens.
    """
    x = []
    for token_ids in token_ids_list:
        num_extra_tokens_CLS_SEP = 2
        l = min(len(token_ids), max_num_tokens - num_extra_tokens_CLS_SEP)
        token_ids = token_ids[:l]
        token_ids = token_ids + [0] * (max_num_tokens - len(token_ids))
        x.append(np.array(token_ids))
    return np.array(x)


def preprocess(df, tokenizer, max_num_tokens):
    """
    * Convert tokens to ids
    * Add start (CLS) and stop (SEP) for BERT
    * Apply padding
    """
    x, y = [], []
    for _, row in tqdm(df.iterrows()):
        myText = row["myText"]
        tokens = tokenizer.tokenize(myText)
        # We need to specify start (CLS) and stop (SEP) for BERT.
        tokens = ["[CLS]"] + tokens + ["[SEP]"]
        token_ids = tokenizer.convert_tokens_to_ids(tokens)
        x.append(token_ids)
        # Capture the target column from the dataset.
        myTarget = row["myTarget"]
        y.append(myTarget)
    x = np.array(x)
    y = np.array(y)
    x_padded = padding(x, max_num_tokens)
    return x_padded, y


df_train = pd.read_csv("myTrainData.csv")
df_test = pd.read_csv("myTestData.csv")

# We need to define the "maximum number of tokens allowed".
MAX_NUM_TOKENS = 50

tokenizer = AutoTokenizer.from_pretrained("ltgoslo/norbert")
model = TFAutoModel.from_pretrained("ltgoslo/norbert")

np_train_x, np_train_y = preprocess(df_train, tokenizer, MAX_NUM_TOKENS)
np_test_x, np_test_y = preprocess(df_test, tokenizer, MAX_NUM_TOKENS)

# Train and Test embeddings.
X_train = model(np_train_x)["pooler_output"]
X_test = model(np_test_x)["pooler_output"]
```
