FROM adoptopenjdk/openjdk11:alpine
EXPOSE 8080
ADD /target/electionblockchain-0.0.2.jar electionblockchain-0.0.2.jar
ENTRYPOINT ["java","-jar","electionblockchain-0.0.2.jar"]