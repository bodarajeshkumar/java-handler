export PATH=/home/user/apache-maven-3.9.6/bin:$PATH
cd java-handler
mvn clean;
mvn install;
mvn exec:java -Dexec.mainClass="ConfigReader"