#!/bin/bash


#JAR = `ls ./target | grep jar`
#echo $JAR
java -cp ./target/ComcastProblem-1.0-SNAPSHOT.jar SumProblem $@
