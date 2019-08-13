FROM openjdk:8-jre-alpine3.8

RUN \
    echo "http://mirrors.aliyun.com/alpine/v3.8/main" > /etc/apk/repositories && \
    apk add --no-cache procps curl bash && \
    ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone

RUN mkdir -p /opt/app/mbp
COPY target/mbp-zipkin-1.0.0.tar.gz /opt/app/mbp
RUN tar zxvf /opt/app/mbp/mbp-zipkin-1.0.0.tar.gz -C /opt/app/mbp &&\
    chmod a+x /opt/app/mbp/zipkin/bin/service.sh &&\
    rm /opt/app/mbp/mbp-zipkin-1.0.0.tar.gz

ENV env default

EXPOSE 8411

CMD ["/opt/app/mbp/zipkin/bin/service.sh", "start", "default"]