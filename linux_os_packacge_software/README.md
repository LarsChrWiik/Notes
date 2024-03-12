# Linux - OS, Package Management, and Software


## Popular package managers
* **apt-get**: the traditional package manager for Debian and Debian-based systems.
* **apt**:
    * a newer, more user-friendly package manager for Debian and Debian-based systems.
    * For example, it provides a progress bar for downloads.
    * apt also includes the apt-cache tool for searching for packages.
    * Allows serching for packages by name with `apt search <package-name>`.
    * Easy access to upgradable list of packages with `apt list --upgradable`.
* **DNF**: Dandified YUM, the package manager for Fedora, CentOS, and other Red Hat-based systems.
* **YUM**: Yellowdog Updater Modified, the traditional package manager for Fedora, CentOS, and other Red Hat-based systems.
* **Pacman**: the package manager for Arch Linux and Arch-based systems.




## Popular Linux Distro's


### Debian
* Known for stability and security
* Is the base os for many other Linux distributions, some examples are:
    * Ubuntu
    * Linux Mint
    * Kali Linux
* Community-driven project
* Uses `apt-get` package manager
* Has a strong focus on free software
* Is updated less frequently than Ubuntu
* Often recommended for servers because of its stability, security, long-term support, and minimalistic nature


### Elementary OS
* Based on Ubuntu
* Focuses on user-friendliness and ease of use
* Comes with the Pantheon desktop environment
* Uses `apt` / `apt-get` package managers
* Often recommended for Linux beginners
* Has a familiar look and feel for macOS users


### Ubuntu
* One of the most popular Linux distributions
* Based on Debian
* Developed and maintained by **Canonical Ltd** and the ubuntu community
* Focuses on user friendliness and ease of use
* Is updated very frequently
* Uses `apt` / `apt-get` package managers
* Often recommended for Linux beginners


### Linux Mint
* Based on Ubuntu, which is based on Debian again
* Focuses on user friendliness and ease of use
* Comes with a variety of desktop environments such as Cinnamon, MATE, and Xfce
* Uses `apt` / `apt-get` package managers
* Often recommended for Linux beginners
* Has familiar look and feel for Windows users


### Alpine
* Independent Linux distribution
* A security-oriented, lightweight Linux distribution
* Is often used in embedded systems, Docker containers, and virtual machines
* Uses `apk` package manager
* Is known for its simplicity and minimalism


### Arch
* A rolling release distribution instead of a fixed release distribution like Ubuntu
* Is known for its simplicity and minimalism
* Is often used by advanced users and developers
* Uses `pacman` package manager
* Has a strong focus on documentation and community support
* Is often used by people who want to learn more about Linux and how it works
* Is the base for many other Linux distributions, such as Manjaro and ArchLabs
* Known for its performance, efficiency, and lightweight nature


### Manjaro
* Based on Arch
* Is known for its user-friendliness and ease of use
* Uses `pacman` package manager, similar to Arch
* Is often used by people who want to use Arch but find it too difficult to install and configure
* Is often recommended for Linux beginners who want to use Arch


### CentOS
* Based on Red Hat Enterprise Linux
* Community Enterprise Operating System
* A free, open-source, community-driven project
* Is often used in enterprise environments and data centers because of its stability and long-term support
* CentOS 8 and above uses `dnf` package manager, while CentOS 7 and below uses `yum` package manager


### Fedora
* Fedora is a community-driven project that is based on Red Hat Enterprise Linux
* A community-driven project sponsored by Red Hat
* Is often used as a testing ground for new technologies that will eventually be included in Red Hat Enterprise Linux
* Uses `dnf` package manager (which is an improved version of `yum`)
* Has short release cycles (about every 6 months)
* Is often used by developers and system administrators
* Is known for its focus on innovation and cutting-edge technologies
* Ships with the GNOME desktop environment by default


### Red Hat Enterprise Linux (RHEL)
* Is a base distro
* A commercial Linux distribution
* Developed by Red Hat
* Is often used in enterprise environments and data centers because of its stability and long-term support
* It is a paid distribution, but it is free for development purposes
* RHEL 8 and above uses `dnf` package manager, while RHEL 7 and below uses `yum` package manager
* It focuses on security and stability


### Oracle Linux
* Based on Red Hat Enterprise Linux
* A commercial Linux distribution
* Developed by Oracle
* Is often used in enterprise environments and data centers because of its stability and long-term support
* It is a paid distribution, but it is free for development purposes
* Oracle Linux 8 and above uses `dnf` package manager, while Oracle Linux 7 and below uses `yum` package manager
* It focuses on security and stability
* Is often used in Oracle Database environments


### AWS Linux
* Based on Red Hat Enterprise Linux
* A commercial Linux distribution
* Developed by Amazon Web Services
* Is often used in cloud environments and data centers because of its stability and long-term support
* It is a paid distribution, but it is free for development purposes
* AWS Linux 2 uses `yum` package manager


### Android
* A mobile operating system based on the Linux kernel, but it is not a traditional Linux distribution
* Developed by Google
* Is often used in smartphones, tablets, smartwatches, and other devices
* Is known for its user-friendliness and ease of use


### Kali Linux
* Based on Debian
* A Linux distribution that is focused on security and penetration testing
* Developed and maintained by Offensive Security
* Is often used by security professionals, ethical hackers, and penetration testers
* Comes with a variety of security and forensics tools
* Uses `apt` / `apt-get` package managers
* Is known for its user-friendliness and ease of use
* Often updated with the latest security tools and features


### SUSE Linux
* A commercial Linux distribution
* SUSE
    * SUSE is a leading provider of enterprise-grade, open-source Linux operating system software and services
    * SUSE Linux Enterprise Server was developed for SAP Applications
    * SAP SE is a German multinational software corporation that makes enterprise software to manage business operations and customer relations
    * In the late 1990s and early 2000s, SUSE gained significant traction in Europe and gradually expanded its presence globally
    * SUSE was focusing on Europe while Red Hat in USA
* Is often used in enterprise environments and data centers because of its stability and long-term support
* It is a paid distribution, but it is free for development purposes
* SUSE Linux uses `zypper` package manager
* It focuses on security and stability
* SUSE Linux is known for its focus on enterprise-grade features and support


## The Popular Linux Software - GNU
Initiated by Richard Stallman in 1983 with the goal of creating a completely free Unix-like operating system, the GNU Project has developed a comprehensive suite of free software that, when combined with the Linux kernel, forms a fully functional operating system.

Info:
* Stands for GNU's Not Unix!
* GNU is a collection of free software
* Commonly seen as a package of low-level system software for Linux, including:
* Contians compilers, core utils, shell, bootloader, text editor, etc
* GNU includes an operating system kernel, libraries, and tools. Some of which are:
    * GCC: GNU Compiler Collection
    * GNU Emacs
    * GNU Debugger
    * GNU Core Utilities
    * GNU Bash
    * GNU Make
    * GNU GRUB (GRand Unified Bootloader)
    * GNU C Library (glibc)
    * GNU Network Object Model Environment (GNOME)
    * etc
