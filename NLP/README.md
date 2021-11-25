# NLP in Tensorflow


## NLP History
The first wave in NLP (syntactic wave) usually involves the **bag-of-words** approach, which includes techniques such as Part-of-speach (POS) tagging, stemming, Lemmatazation, n-grams, etc.

The second wave in NLP (semantic wave) involves extracting the meaning of the text using different techniques. This is known as the **Bag-of-concepts** approach.

The third wave in NLP (pragmatic wave) goes beyond just the meaning of the text, but rather tackles **contextual information**. This approach tries to decode sarcasm, personallity recognition, and more. But this is a field in the working.


## Some use cases for NLP (Supervised learning)
* Calculating peoples brand perception
* Text summarization (news, blogs, journals)
* Spam detection
* Audience segmentation on social media platform
* Chatbot


## Tokenization + Padding
Steps on how to represent a set of words in a sentence in numerical form using labvels and padding:
* **Tokenization**: split text into tokens/words/symbols. Removing punctuation, lowercasing, etc.
```python
from tensorflow.keras.preprocessing.text import Tokenizer
tokenizer = Tokentizer()
tokenizer.fit_of_text(sample_text)
# tokenizer.word_index = {'text': 1, 'processing': 2, 'tf': 3, 'this': 4, 'is': 5,'a': 6, 'chapter': 7, 'on': 8, 'using': 9, 'requires': 10, 'careful': 11, 'handling': 12}
```
* **Sequencing tokens**:
```python
token_seq = tokenizer.texts_to_sequences(sample_text)
# res:
#   [[4, 5, 6, 7, 8, 1, 2, 9, 3], 
#   [1, 2, 10, 11, 12], 
#   [3]]
```
* **Padding**: Convert vector representations into vectors of the same length. For example by padding the end (post) of short sentences with 0 at the end.
```python
from tensorflow.keras.preprocessing.sequence import pad_sequences
padded_token_seq = pad_sequences(token_seq, padding='post')
# Res:
#  [[ 4 5 6 7 8 1 2 9 3]
#  [ 1 2 10 11 12 0 0 0 0]
#  [ 3 0 0 0 0 0 0 0 0]]
```


## Word Embeddings
Embeddings are **numerical representations of text information**. Embedding are actually just the **weights of the hidden layer of a shallow neural network** that was trained on a certain set of text.

The goal is to capture the semantic meaning of the text. Embeddings can be generated using a pre-trained model and they will differ depending on which model we chose.
* So if you wish to use the embeddings for example sentiment analysis, you should use a embedding model that has been created for sentiment analsis purposes

Since the embedding in a vector of N, we can think of this as an N dimentional space. And words that are similar will appear close together in this space.

Some off-the-shelf methods for calculating embeddings are:
* **Word2Vec** (by Google)
* **GloVe** (by Standford)
* **fastText** (by Facebook)

In Tensorflow, we can use:
```python
from tensorflow.keras.layers import Embedding
```

We can divide embeddings into two categories:
* Frequency based
* Prediction based


### Frequency based word embeddings

#### TF-IDF
Term frequency-inverse document frequency (TF-IDF) is a technique that tried to capture the importance of words by measuring and factoring in how frequent the word usually occurs. TF-IDF is often used when ranking and scoring document relevance given a search query.

#### Vectorizer
TODO

### Prediction based word embeddings
The issue with prediction based word embeddings is *"How do you predict word embedding when you don’t have any labeled data i.e words and their corresponding word embedding?"*.

The solution is to **create labels** (a fake task) from the input data. And our goal is just to extract the embeddings from the hidden layer.

Here are two approaches of how we can create labels from the input data: 

#### Continuous bag-of-words (CBOW)
CBOW is the opposite of Skip-Gram, and is a word embedding approach that is trained by predicting each word based in its context.


#### Skip-Gram model
Skip-Gram is the opposit of CBOW, and is a word embedding approach that is trained to predict the context based on the word.



## Sentence Embeddings
TODO
