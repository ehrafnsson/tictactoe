#!/bin/sh

if [ -d "src" ]; then
	echo "Deleting..."
	rm -rf src
fi

javac src/HelloWorld.java

