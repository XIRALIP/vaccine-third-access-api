#!/bin/bash
export JAVA_HOME=/opt/azero/jdk
export AZERO_HOME=/opt/azero
export SERVICE_NAME=vaccine-third-access-api
export SERVICE_HOME=/opt/azero/vaccine-third-access-api
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$CLASSPATH:$SERVICE_HOME/lib/vaccine-third-access-api.jar
export JAVA_OPTS="$JAVA_OPTS $JAVA_OPTS_ENV "
export JAVA_OPTS="$JAVA_OPTS -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$SERVICE_HOME/dump "
export JAVA_OPTS="$JAVA_OPTS -Djava.library.path=$SERVICE_HOME/lib -Djava.net.preferIPv4Stack=true"

java $JAVA_OPTS -cp $CLASSPATH -jar lib/vaccine-third-access-api.jar
