# How to enable GPU acceleration on M1 Macs


### Install Miniconda
You need to use Conda to install PyTorch on M1 Macs. And install the arm64 version of Miniconda.
See: https://docs.conda.io/en/latest/miniconda.html
```bash
Miniconda3 macOS Apple M1 64-bit pkg
# OR
Miniconda3 macOS Apple M1 64-bit bash
```


### Install XCode-select
(If is it installed already, then you can skip this).
```
xcode-select --install
```


### Creating environment and installing dependenices
```sh
conda create -n myenv3.9.17 python=3.9.17
```

Make sure to enable the followign channels in the `.condarc`:
```
channels:
  - conda-forge
  - apple
channel_priority: flexible
```

Deactivate and activate again to enable the channels.

Then run:
```sh
conda install tensorflow-deps
pip install tensorflow-macos
pip install tensorflow-metal
```


### Anternative installation with `.condarc`
Anternativly, we could define dependencies directly in the `.condarc` and then install from `.condarc` when we create the envrioment. We call the file `tf-metal.yml`:
```yaml
name: tf-metal
channels:
  - apple
  - conda-forge
dependencies:
  - python=3.9.17  ## specify desired version
  - tensorflow-deps
  - pip:
    - tensorflow-macos
    - tensorflow-metal
```

Install from `.condarc` with:
```sh
conda create -n myenv3.9.17 python=3.9.17 -f tf-metal.yml
```

After the installation, we can confirm the installed packages with:
```
conda list
```


### Confirming that GPU is available
Run Python and then:
```py
import tensorflow as tf
print("GPU is", "avalaible" if tf.config.list_physical_devices('GPU') else "NOT AVAILABLE")

print(tf.config.list_physical_devices('GPU'))
# Expected output:
#     [PhysicalDevice(name='/physical_device:GPU:0', device_type='GPU')]
```
