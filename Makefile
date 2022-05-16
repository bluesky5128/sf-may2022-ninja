.PHONY: bootstrap setup update run console clean build test cibuild
.DEFAULT_GOAL := help

help:
	echo "Primary goals are build, run, test, verify. 'make run' to execute"

bootstrap:
	echo "'Bootstrap' currently has not steps"

run: build
	java -jar ./build/libs/LevelUpGame-0.0.1-SNAPSHOT.jar

clean:
	./gradlew clean

build: clean
	./gradlew build -x test

test: 
	echo "Running unit tests"
	./gradlew test

verify: 
	echo "Running cucumber tests"
	./gradlew cucumberCli
	mkdir -p ./output
	cp -R src/test/resources/images output

all-tests: test verify

cibuild: build all-tests
	
package:
	./gradlew assemble
