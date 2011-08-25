#!/bin/sh

CLASSPATH="$HOME/.m2/repository/com/melexis/th01-example/1.0.0-SNAPSHOT/th01-example-1.0.0-SNAPSHOT.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/com/melexis/libth01/1.0.3-SNAPSHOT/libth01-1.0.3-SNAPSHOT.jar"
CLASSPATH="$CLASSPATH:$HOME/.m2/repository/commons-lang/commons-lang/2.5/commons-lang-2.5.jar"

export CLASSPATH

echo $CLASSPATH

java com.melexis.Th01Example $@