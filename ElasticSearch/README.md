# ElasticSearch


### Elasticsearch Query DSL (Domain Specific Language)
* Elasticsearch Query DSL is a language provided by Elasticsearch for writing queries.
* JSON-based query.


### ElaticSearch Query types
* **bool**: boolean query
* **term**: Matches exact terms. The relevance score of a document is typically binary, indicating either a match (score of 1) or no match (score of 0).
* **match**: Full-text query match using TF/IDF scoring algorithm by default.
* **multi-match**: search for terms across multiple fields simultaneously. Can control the relevance score of each field with field weights.
* **range**: search for documents within a specific range of values in a numeric or date field. Resulting in binary relevance scores (1 for a match, 0 for no match).
* **match_phrase**: The "exists" query is a simple query that matches documents where the specified field exists.
* **match_phrase_prefix**: matches documents that have a field starting with a specified prefix.
* **fuzzy**: Find documents that contain terms similar to the search term based on a custom distance function.
* **wildcard**: pattern matching using wildcard characters (* and ?) in the search terms.


### Bool query
* **must**:
    * Condition `must` be satisfied.
    * Mandatory filter.
    * Similar to the AND operator.
* **should**:
    * Desirable condition, but not mandatory.
    * Similar to the OR operator.
    * A document that matches a should caluse is a valid match.
    * Documents matching more `should` conditions will have a higher relevance score and are likely to appear higher in the search results.
    * The order of the items in the causes does not change the number of document matches, however the scores for each document might differ due to the term frequency algorithm in use.
    * You should have the most important should clauses first.
* **must_not**:
    * Opposite of `must`.
    * Condition where matches are filtered out.
    * Similar to the NOT operator.

**Example**:
```json
{
  "query": {
    "bool": {
      "must": [
        { "term": { "category": "electronics" } }
      ],
      "should": [
        { "term": { "color": "blue" } },
        { "term": { "size": "large" } }
      ],
      "must_not": [
        { "term": { "brand": "Apple" } }
      ]
    }
  }
}
```

### Boost
* Allows you to control the relevance score of a document.
* The higher the boost factor, the more relevant the term will be.

**example**
```json
{
  "query": {
    "bool": {
      "should": [
        { "match": { "title": { "query": "elasticsearch", "boost": 2.0 } } },
        { "match": { "description": "search engine" } }
      ]
    }
  }
}
```
