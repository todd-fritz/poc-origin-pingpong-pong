#java:8 is the standard distro which is huge.
#FROM java:8
#
#Using the centos7 base image instead.
FROM centos:centos7
# Update the image with the latest packages (recommended)
RUN yum -y update && yum -y upgrade && yum clean all
RUN yum -y install wget && yum clean all
RUN wget -c -O /tmp/jdk-8u60-linux-x64.rpm --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u60-b27/jdk-8u60-linux-x64.rpm
RUN yum -y localinstall /tmp/jdk-8u60-linux-x64.rpm && yum clean all
RUN rm -f /tmp/jdk-8u60-linux-x64.rpm
#
#
VOLUME /tmp
RUN mkdir /app
ADD sample-pong-1.0.0-SNAPSHOT.jar /app/app.jar
ADD runboot.sh /app/
RUN bash -c 'touch /app/app.jar'
WORKDIR /app
RUN chmod a+x runboot.sh
EXPOSE 8080
CMD /app/runboot.sh