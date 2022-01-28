FROM fabric8/java-centos-openjdk11-jre
ADD target/Blog-it-1.0-SNAPSHOT.jar /home/Blog-it.jar
CMD ["java", "-jar", "/home/Blog-it.jar"]