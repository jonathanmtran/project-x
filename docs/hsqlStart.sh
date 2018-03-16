#!/bin/sh

if [ ! -n "$1" ]; then
  echo "Usage: $0 <classpath to hsqldb-*.jar>"
  exit 1
fi

java -cp $1 org.hsqldb.server.Server -database.0 'file:./.gradle/hsqldb/projectX' --dbname.0 projectX
