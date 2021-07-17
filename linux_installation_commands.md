# Steps to install java on Fedora 34

__NOTE:__ I'm using Fedora, so the steps I've listed are mainly for my purpose. For Windows or Mac, this won't work, but the way to do that is easily available on the internet.  

1. Download the tar.gz file, go to the file location where this was downloaded and un-compress it using the command:

    ```bash
    $tar -xvf jdk-11.0.11_linux-x64_bin.tar.gz
    ```  

2. This will give out a folder(`jdk-11.0.11`) which might be any other version in your case.  

3. Run the command for the java folder that was extracted.

    ```bash
    $sudo mkdir -p /usr/lib/jvm/jdk-11.0.11
    ```  

4. Run the command:

    ```bash
    $sudo mv jdk-11.0.11/* /usr/lib/jvm/jdk-11.0.11/
    ```

    This will copy all the contents of the directory to the lib folder, and thus the binaries are in linux system.  

5. Run the command to update the links to use `java` and `javac` commands in terminal or in any IDE:

    ```bash
    $sudo alternatives --install "/usr/bin/java" "java" "/usr'lib/jvm/jdk-11.0.11/bin/java" 20000

    $java -version
    java version "11.0.11" 2021-04-20 LTS
    Java(TM) SE Runtime Environment 18.9 (build 11.0.11+9-LTS-194)
    Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.11+9-LTS-194, mixed mode)

    $sudo alternatives --install "/usr/bin/javac" "javac" "/usr'lib/jvm/jdk-11.0.11/bin/javac" 20000

    $javac -version
    javac 11.0.11
    ```

With this, java is installed in your system.
