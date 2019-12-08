##
## EPITECH PROJECT, 2018
## make
## File description:
## make
##

SRC		= ctrad.c

NAME	=	trantorian

all: #package
#	rm -rf dist
#	mkdir dist
	#cp target/*.jar dist/.
	#cp target/*jar trantorian
	#chmod +x dist/*
	javac AI.java main.java
	gcc $(SRC) -o $(NAME)

clean:
#	mvn clean
	rm -rf dist/*.jar

package:
	mvn package

build:
	mvn compile

test:
	mvn test

deps:
	mvn dependency:resolve
run:
	mvn exec:java -Dexec.mainClass="main"

runflag:
	mvn exec:java -Dexec.mainClass="main" -Dexec.args="-p 2323 -x 232 -y 55 -n team1 team2 epic2 -c 23 -f 42"

fclean: clean
	rm -f *#
	rm -f *~
	rm -f *.class

re: clean all
