#!/bin/bash


if [ $1 == "build" ]
then
   echo "Building Maven Project"
   echo -en "\n"
   echo -en "\n"
   echo -en "\n"
   mvn clean install
fi


if [ $1 == "test" ]
then
   echo "Testing Maven Project"
   echo -en "\n"
   echo -en "\n"
   echo -en "\n"
   mvn test
fi
