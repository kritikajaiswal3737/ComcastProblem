#!/bin/bash


if [[ $# -eq 0 ]]
then
	echo "pass build or test as argument"
	exit 0
fi

if [[ $1 == "build" ]]
then
   echo "Building Maven Project"
   echo -en "\n"
   echo -en "\n"
   echo -en "\n"
   mvn clean install
fi


if [[ $1 == "test" ]]
then
   echo "Testing Maven Project"
   echo -en "\n"
   echo -en "\n"
   echo -en "\n"
   mvn test
fi
