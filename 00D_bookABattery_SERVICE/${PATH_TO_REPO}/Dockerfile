FROM java:8
MAINTAINER l.bennardis@email.it
VOLUME /tmp
RUN mkdir /temp
RUN git clone -b qualityassurance https://github.com/lbennardis/bookabatteryservice.git /temp 
RUN bash -c 'touch /temp/qualityassurance/00D-bookABattery_SERVICE/00D-bookABattery_SERVICE/1.0.0.BUILD-SNAPSHOT/00D_bookABattery_SERVICE-1.0.0.BUILD-SNAPSHOT.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/temp/00D-bookABattery_SERVICE/00D-bookABattery_SERVICE/1.0.0.BUILD-SNAPSHOT/00D_bookABattery_SERVICE-1.0.0.BUILD-SNAPSHOT.jar"]


 