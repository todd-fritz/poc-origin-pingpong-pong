FROM java:7
MAINTAINER todd-fritz

VOLUME /tmp
RUN mkdir /app
ADD poc-origin-pingpong-pong-1.0.0-SNAPSHOT.jar /app/app.jar
ADD runboot.sh /app/
RUN bash -c 'touch /app/app.jar'
WORKDIR /app
RUN chmod a+x runboot.sh
EXPOSE 8080
CMD /app/runboot.sh