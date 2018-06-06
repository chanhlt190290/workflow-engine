#!/bin/sh

ps auxw | grep workflow-engine.jar | grep -v grep 

if [ $? != 0 ]
then
        java -jar /home/chanhlt/workflow-engine/target/workflow-engine.jar > /dev/null
fi

