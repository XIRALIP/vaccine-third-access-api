FROM azero/openjdk:8u212

#set service name
ARG SERVER_NAME=vaccine-third-access-api

#set work path
WORKDIR /opt/azero/${SERVER_NAME}

ADD ./target/${SERVER_NAME}.jar /opt/azero/${SERVER_NAME}/lib/
ADD config /opt/azero/${SERVER_NAME}/config
ADD scripts /opt/azero/${SERVER_NAME}/scripts
RUN dos2unix scripts/*
# dockerfile 中修改源,并安装git命令(还需要其他命令,自行添加)
RUN echo -e 'https://mirrors.aliyun.com/alpine/v3.7/main/\nhttps://mirrors.aliyun.com/alpine/v3.7/community/' > /etc/apk/repositories && \
    apk update && \
    apk upgrade && \
    apk add --no-cache git
RUN apk add --update ttf-dejavu fontconfig

EXPOSE 8301

CMD sh scripts/startdocker.sh
