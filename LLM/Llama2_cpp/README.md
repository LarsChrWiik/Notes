
# Llama 2 cpp
https://github.com/ggerganov/llama.cpp

### Features
* A github library that for LlaMA inference in pure C/C++.
* 4-bit, 5-bit and 8-bit integer quantization support
* Support both x86 and Apple Silicon.
* Support bindings for other languages such as Python

### Important files
* main
* quantize
* convert.py

### How to convert the Llama models to the Llama.cpp format
We need to run the `convert.py` script to convert the Llama models to the Llama.cpp (ggml) format. So we need to install teh requirements to run the script:
```sh
python -m pip install -r requirements.txt
```

Then we can run:
```sh
python convert.py --outfile <orignal-llama-file-path> --outtype f16 <output-path>
```
For example:
```sh
python convert.py --outfile ./models/7B/ggml-model-f16.bin --outtype f16 ../meta_models/7B/llama-2-7b
```

### How to quantize
We can then quantize the ggml model.

Example with 8-bit quantization:
```sh
./quantize ./models/7B/ggml-model-f16.bin ./models/7B/ggml-model-q8_0.bin q8_0
```

 Example with 4-bit quantization:
```sh
./quantize ./models/7B/ggml-model-f16.bin ./models/7B/ggml-model-q4_0.bin q4_0
```
