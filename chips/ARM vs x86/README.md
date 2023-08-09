# ARM vs x86 and more
**x86** and **ARM** are two types of chip architectures.

### x86
**x86** refers to a family of instruction set architectures based on the Intel 8086 CPU and its successors together with related instruction sets used by other manufacturers like AMD.


## x86 - 32bit vs. 64 bit
The terms "x86," "32-bit," and "64-bit" are often used in the context of computer processors and operating systems. x86 means the type of chip architecture (in contrast of ARM), while 32-bit and 64-bit refer to the size of the processor's memory address space. x86 processors have evolved to include both 32-bit and 64-bit versions.

* **32-bit**: processors have a memory address space of 4 GB, which is 2^32 bytes.
* **64-bit**: processors have a memory address space of 16 exabytes, which is 2^64 bytes.

Practially speaking, this means that the 2^32 unique address space limit that a 32-bit processor has directly limits how much RAM the processor can use, where 4 GB of RAM is the absolute maximum. If a system has more than 4 GB of RAM installed, the 32-bit processor will not be able to utilize it fully, as it simply doesn't have enough unique addresses.

64-bit systems can address an astronomically larger amount of memory (18.4 million TB).

### Why the jump from 32 all the way to 64?
* The increased address space virtually eliminates any foreseeable adress limit constraints. And by doubling the number of bits simplifies the process of extending the instruction set and ensures better compatibility with existing 32-bit instructions.
* A non-standard size like 40-bit might introduce complexities in instruction alignment and compatibility
* This even-numbered increase aligns well with existing data types, such as 64-bit floating-point numbers.
* There have been systems with non-standard word sizes (including 36-bit or 48-bit systems), particularly in earlier computing history. However, these often led to compatibility and standardization challenges.

In summary, the move to 64-bit was driven by a combination of technological needs, practical considerations, and long-term planning. It allowed the industry to overcome the limitations of 32-bit systems while setting a standard that would be viable for the foreseeable future.


## ARM
Stands for **Advanced RISC Machine** and is a family of *Reduced Instruction Set Computing (RISC)* architectures for computer processors.

### ARM holdings
**ARM Holdings** is the company behind the ARM architecture. They licenses the design to various manufacturers rather than producing the chips themselves.

### ARM competition
The biggest competitors to ARM is **IBM**, **Intel** and **AMD**.
ARM no longer has competitors in the mobile space.

### ARM Characteristics:
* **ARM uses RISC**: Run simplified instructions that can be executed in a single clock cycle. This is different than **Complex Instruction Set Computing (CISC)** architectures, that have more complex instructions that may require multiple clock cycles.
* **Energy Efficiency**: ARM processors are very energy efficient. Which makes the batteries ideal for smartphones, tablets, and laptops.
**Market Presence**: ARM architecture is predominant in mobile devices, IoT (Internet of Things) devices, and is increasingly being adopted in other areas, such as servers and personal computers (e.g., Apple's M1 chip).
* **Licensing Model**: ARM doesn't manufacture chips itself but rather licenses its designs to other companies like Qualcomm, Apple, Samsung, and others.
* **Scalability**: ARM processors are highly scalable. They can be used in small devices like smartwatches and smartphones, but also in large servers.
* **64≤-bit and 32-bit Support**: ARM architecture supports both 64-bit (ARMv8-A and later) and 32-bit (earlier versions) computing. The 64-bit architecture allows for more memory addressability and enhanced performance for certain workloads.
* **Instruction Sets**: ARM processors typically support various instruction sets like ARM, Thumb, and NEON.
* **Ecosystem**: ARM has fostered a large ecosystem of tools, operating systems, and applications designed for ARM-based devices. This includes popular operating systems like Android, iOS, and various Linux distributions.


### Companies and industries adopting ARM
**Mobile Device Manufacturers**:
* Qualcomm: Designs ARM-based Snapdragon processors used in many smartphones and tablets.
* Samsung: Utilizes ARM cores in its Exynos processors.
* MediaTek: Develops ARM-based processors for mobile devices and smart TVs.

**Computing and Server Industries**:
* NVIDIA: Uses ARM designs in various products, like the Tegra series for mobile computing.
* Marvell: Creates ARM-based processors for servers and embedded systems.
* Ampere Computing: Focuses on ARM-based processors for cloud and edge computing.

**Internet of Things (IoT) and Embedded Systems**:
* NXP Semiconductors: Offers a wide range of ARM-based microcontrollers.
* STMicroelectronics: Designs ARM-based microcontrollers for automotive, industrial, and consumer applications.
* Texas Instruments: Incorporates ARM cores in various embedded processors and microcontrollers.
* Consumer Electronics:

Sony: Uses ARM processors in various products, including gaming consoles like the PlayStation Vita.
Amazon: Employs ARM-based chips in Kindle devices and some Echo products.
Automotive Industry:

Many automotive companies use ARM-based chips for infotainment systems, Advanced Driver Assistance Systems (ADAS), and more.
Networking:

Companies like Cisco and Juniper may utilize ARM-based chips in networking equipment.
Other Technology Companies:

Microsoft: Has supported ARM in devices like the Surface Pro X and in server deployments.
Huawei: Develops its own Kirin ARM-based processors for smartphones.


# Apple M1 & ARM
Apple M1 is a **System on Chip** - meaning that it is a single chip that contains multiple components. The M1 chip contains the CPU, GPU, RAM, and other components. This is different from a traditional computer, where the CPU, GPU, RAM, and other components are separate chips.

* **M1 CPU**: The M1's CPU cores are based on ARM architecture.
* **M1 GPU**: The M1's GPU is Apple's own custom design. It is optimized for graphics processing and doesn't directly implement the ARM architecture in the way the CPU cores do. Instead, it's a design specifically tailored to Apple's needs for graphics rendering, machine learning, and related tasks.

### Issues with ML library support for ARM
The M1's GPU is a custom design, and support for this specific GPU might be limited or require additional configuration. The tight integration of CPU, GPU, and other components on the M1 SoC might create unique challenges or opportunities for optimization that differ from other ARM-based or x86 systems.

Many existing software packages, including some machine learning libraries, were optimized for x86. Adapting to a new architecture requires recompiling and potentially reoptimizing the code because hardware of different architectures interprets and executes code differently.

**Why recompiling is needed**:
* **Instruction Set**: This means that the M1 chip uses a different instruction set (the set of commands the hardware understands) than most other computers. Code compiled for one instruction set won't work directly on another because the underlying binary representation and the semantics of the instructions are different.
* **Binary Code**: Compiling translates high-level source code (e.g., C, C++, Python) into machine code (binary code) that can be executed directly by the processor. A binary compiled for an x86 CPU, for instance, contains a series of instructions that x86 hardware understands but that ARM hardware would not.
* **Registers and Memory**: Different architectures may have a different number of registers (fast storage locations within a CPU) with different sizes (like 32-bit vs. 64-bit), and different ways of managing memory and I/O. These differences impact how programs are compiled and how they run.
* **Optimizations**: Compilers often optimize code to take advantage of specific features or capabilities of an architecture.

In summary, when you compile code, you are translating the the source code into a set of instructions that a particular type of hardware can execute. Changing the hardware (i.e., the architecture) means you need a different set of instructions, hence the need to recompile.

### Rosetta 2
Apple's Rosetta 2 translation layer allows x86 applications to run on the M1, but this can introduce performance penalties and compatibility quirks. Using native ARM builds whenever possible is generally preferable.


## How to use Torch with M1
* PyTorch has introduced support for GPU acceleration on M1 MacOS devices.
* PyTorch, like Tensorflow, uses the Metal framework.
* For PyTorch v1.12+.
* The M1-GPU support feature is supported only in MacOS Monterey (12.3+).
* Accelerated GPU training is enabled using Apple’s Metal Performance Shaders (MPS) as a backend for PyTorch.
