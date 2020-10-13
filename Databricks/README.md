
# Databricks
DataBricks is an organization and big data processing platform founded by the creators of Apache Spark. The Databricks platform was created for data scientist, data engineers and data anlyssts to help them more easily analyze, experiment, preprocess, prepare and store data, create data pipelines, and deploy machine learning applications using Big Data. 

# What does Databricks solve
- ACID transactions of data by using Delta Lake
- Versoning and automatic deployment and versioning with Azure DevOps (no need for Jenkins or Nexus)
- Integrated database for Secrets
- Automatic scheduling of Spark jobs
- Easy deployment and sharing of notebooks
- Automatic compiling of notebooks
- Automatic cluster scaling
- Provides sandbox environment
- Provide updates of data in data lake

# Delta Lake 
Delta-Lake is an open-source storage layer that brings ACID transactions to Apache Spark. All data in Delta Lake is stored in Apache Parquet format enabling Delta Lake to leverage the efficient compression and encoding schemes that are native to Parquet. 

Delta Lake provides:
* ACID Transactions
* Allow Updates and Deletes
* Provide Data snapshots, which allow users to do data time travel
* Unifies Batch and Streaming logic
* Allow Schema Enforcement to prevent bad data from entering the data lake
* Allow Schema Evolution to allow schema changes to be done if needed
* Logs all changes done to the data

# Databricks Cost (full cloud solution)
Cost related to using Databricks with full cloud support involves:
* Databricks workbench subscription fee (based on DBU) https://databricks.com/product/pricing
* Cluster processing fee https://azure.microsoft.com/en-us/pricing/details/databricks/
* Storage of data (eks: Azure Data Lake 2gen) + Read and Write operations https://azure.microsoft.com/en-in/pricing/details/storage/data-lake/

There are currently (in 2019) three types of Databricks payment plans (*Data Engineering Light*, *Data Engineering*, and *Data Analytics*) that provides different tools for Databricks users. 

It is also possible to *pre-purchase* DBUs instead of the traditional *pay-as-you-go* payment. 
