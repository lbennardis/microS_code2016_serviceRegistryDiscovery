FROM java:8
MAINTAINER l.bennardis@email.it
VOLUME /tmp
RUN mkdir /temp
RUN git clone -b mvn-repo https://github.com/lbennardis/dockerAutomationTest.git /temp 
RUN bash -c 'touch /temp/01_spring_boot_rest_backing_services/01_spring_boot_rest_backing_services/1.2.1.RELEASE/01_spring_boot_rest_backing_services-1.2.1.RELEASE.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/temp/01_spring_boot_rest_backing_services/01_spring_boot_rest_backing_services/1.2.1.RELEASE/01_spring_boot_rest_backing_services-1.2.1.RELEASE.jar"]


 