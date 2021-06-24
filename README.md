# ComcastProblem

## Functionality:
This Java program is used to calculate the sum of the digits from the given input String.

## Assumptions:
I have made the following assumptions while designing the solution.
1. If the user uses file input option and the file contains strings in multiple lines, it will consider all the lines in the file.
2. When the program is run without any flag or with -x flag, input should be passed as STDIN and not arguments.
3. When the program is run with -f option, the filename should be passed in the argument and not as STDIN.

## How to Built the application:
This is a java program and can be build using maven. Below are the instructions to build the project.
1. Download the project.
2. Navigate to ComcastProblem directory in command line.
3. Run the script build.sh as below:
$ chmod 755 build.sh
$ ./build.sh build

## How to run the unit tests for the application:
$ ./build.sh test

## How to execute the program:
Once the project has been built in previous step, the jar file will be generated. Below script can be run in order to execute the jar files.
$ chmod 755 myProg.sh
$ ./myProg.sh

Below are some of the sample usages:
1. When default stdin needs to be passed:
$ echo "kritika123" | ./myProg.sh
6

2. When -x flag is passed:
$ echo "kritika123" | ./myProg.sh -x
16

3. When -f flag is passed:
$ echo "a9b9c0012" > file.tmp
$ ./myProg.sh -f file.tmp
21

$ ./myProg.sh -f
Invalid Usage! Below are the valid options:
Use "-f filename" for file input
Use "-x" for hexadecimal
Use "-x -f filename" for hexadecimal file input

3. When both -f flag is passed along with -x:
$ ./myProg.sh -x -f file.tmp
54

4. Incorrect options are passed:
$ ./myProg.sh -p -u
Invalid Usage! Below are the valid options:
Use "-f filename" for file input
Use "-x" for hexadecimal
Use "-x -f filename" for hexadecimal file input



