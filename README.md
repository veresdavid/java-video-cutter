# java-video-cutter

A small command line Java application for cutting video files into smaller parts, using **ffmpeg**.

## Requirements

To use the application, you must install **ffmpeg** to your computer, and add it to the PATH environment variable!

## Compilation

For compilation, you will need:
* Java 8
* Maven 3

on your computer! If you have these, you can use the `mvn clean package` command to generate the executable JAR file. You can find it under the `target/` folder.

## Usage

To use the application correctly, use the following command line arguments:
* -i / --input, for defining where the input file is
* -s / --split, for defining how long the output parts should be (in seconds)
* -o / --output, for defining the output folder
* -p / --prefix, for defining the output video files names