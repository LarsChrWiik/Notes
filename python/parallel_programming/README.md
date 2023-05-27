# Parallel programming in Pyhton
TODO


### Example using multiprocessing Pool
```py
import time

from tqdm import tqdm
from multiprocessing import Pool

from haystack.nodes import QuestionGenerator as HaystackQuestionGenerator


p = "Norway, officially the Kingdom of Norway, is a Nordic country in Northern Europe, the mainland territory of which comprises the western and northernmost portion of the Scandinavian Peninsula. The remote Arctic island of Jan Mayen and the archipelago of Svalbard also form part of Norway. Bouvet Island, located in the Subantarctic, is a dependency of Norway; it also lays claims to the Antarctic territories of Peter I Island and Queen Maud Land. The capital and largest city in Norway is Oslo."
paragraphs = [p] * 32


def sequential():
    # 32 paragraphs: 76.7 sec
    name = "sequential"
    print(f"*** Starting {name} ***")
    start = time.time()
    question_generator = HaystackQuestionGenerator(
        model_name_or_path="valhalla/t5-base-e2e-qg",
        prompt = "generate questions as a user:\n\n",
        progress_bar=False,
    )
    for paragraph in tqdm(paragraphs):
        results = question_generator.generate(paragraph)
    end = time.time()
    print("len results =", len(results))
    print(f"Time elapsed {name} = {round(end - start, 1)}")


def parallel():
    # 32 paragraphs: 32.2 sec
    name = "parallel"
    print(f"*** Starting {name} ***")
    start = time.time()
    question_generator = HaystackQuestionGenerator(
        model_name_or_path="valhalla/t5-base-e2e-qg",
        prompt = "generate questions as a user:\n\n",
        progress_bar=False,
    )
    with Pool(processes=10) as p:
        # Parallel code here...
        results = list(tqdm(p.imap(question_generator.generate, paragraphs), total=len(paragraphs), disable=True))
    print("len results =", len(results))
    print(results)
    end = time.time()
    print(f"Time elapsed {name} = {round(end - start, 1)}")


if __name__ == "__main__":
    sequential()
    parallel()
```
