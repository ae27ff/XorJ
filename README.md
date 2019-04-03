# XorJ
Java multi-file binary XOR utility with a Swing UI.

*[Bitwise XOR](https://en.wikipedia.org/wiki/Exclusive_or#Bitwise_operation) is a useful operation that can be used to, reversibly, combine two inputs into a third that represents their differences in binary.  Xor is commutative, associative, and given one of the inputs and the output, you can use the same operation to find the other input.  Considering this, XOR is extremely useful in steganography and cryptography.*

XorJ allows you to xor each corresponding byte from portions of multiple files, or to xor files against a constant value, to produce a new file with the properties discussed above. If you use only a single file, you can also use the program to extract a portion of a file.

# Downloading the Program pre-built
You can find released JARs which you can run on the [Releases tab](https://github.com/crashdemons/XorJ/releases) of this project.

If you want something a bit more shiny, you can check out our [development builds](https://ci.meme.tips/job/XorJ/) available through Jenkins CI.

# Running the Program
To run the program, you first need to have Java installed. You can do this through your system's package manager or by using [the official Java download page](https://www.java.com/en/download/).

On Windows, if you have Java SE/JRE installed, you can usually just double-click the JAR file to run it as a program.

On linux and Windows, if you have OpenJDK or your relevant java package installed, you can run `javaw -jar path-to-the-jarfile-here` in order to run the program.

*Note: Version 1.4+ requires Java 7 or higher, version 1.5+ requires Java 8.*

# Building the Project yourself
We've recently moved to using Maven! If you used build.xml or a Netbeans Project before, you may need to import the project again as a maven project / from existing POM.

[This document](https://github.com/crashdemons/Notes/blob/master/Importing_Maven_Projects.md) may help you import the project in your IDE.
