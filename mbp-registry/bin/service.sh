#!/bin/bash

echo "Start service"

MBP_CONTENT_HOME=/opt/app/mbp
APP_NAME=registry
APP_HOME=${MBP_CONTENT_HOME}/${APP_NAME}
APP_VERSION=1.0.0

LOG_HOME=${MBP_CONTENT_HOME}/logs
LOG_PATH=${LOG_HOME}/${APP_NAME}
ENV_LIST=("default" "dev" "test" "prod")

REMOTE_PORT=6761

SERVICE_LIB=${APP_HOME}/lib
SERVICE_CONF=${APP_HOME}/conf
SERVICE_RESOURCES=${APP_HOME}/resources

if [[ -n "$2" ]]; then
  PROJECT_ENV=$2
else
  PROJECT_ENV="dev"
fi

safemkdir(){
  if [[ ! -d $1 ]] ; then
    mkdir -p $1
  fi
}

# Production config
if [[ "$PROJECT_ENV" == "prod" ]]; then
    JAVA_OPTIONS="-server -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$LOG_PATH -Xms8G -Xmx8G -Xmn3G -XX:MetaspaceSize=256M -XX:MaxMetaspaceSize=512M -XX:+DisableExplicitGC -XX:SurvivorRatio=8 -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -XX:+CMSClassUnloadingEnabled -XX:LargePageSizeInBytes=128M -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=80 -XX:SoftRefLRUPolicyMSPerMB=0"
else
    JAVA_OPTIONS="-server -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$LOG_PATH -Xms512M -Xmx2G -Xmn256M -XX:MetaspaceSize=128M -XX:MaxMetaspaceSize=256M -XX:+DisableExplicitGC -XX:SurvivorRatio=8 -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -XX:+CMSClassUnloadingEnabled -XX:LargePageSizeInBytes=128M -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=80 -XX:SoftRefLRUPolicyMSPerMB=0"
fi

if [[ "$PROJECT_ENV" == "dev" || "$PROJECT_ENV" == "test" ]]; then
  JAVA_OPTIONS="-Xdebug -Xrunjdwp:transport=dt_socket,address=$REMOTE_PORT,server=y,suspend=n $JAVA_OPTIONS"
fi

JAVA_OPTIONS="-XX:ErrorFile=$LOG_PATH/hs_err_pid%p.log $JAVA_OPTIONS -Dspring.config.additional-location=$SERVICE_CONF/ -Dspring.profiles.active=$PROJECT_ENV -Dapp.name=$APP_NAME -Dlog.home=$LOG_HOME -Denv=$PROJECT_ENV -Djava.security.egd=file:/dev/./urandom"

export CLASSPATH=${CLASSPATH}:${SERVICE_CONF}:${SERVICE_RESOURCES}
export JAVA_OPTIONS
export PID_FILE=${APP_HOME}/.pid/${APP_NAME}.pid
dateFormat=$(date '+%Y-%m-%d')

safemkdir ${APP_HOME}/.pid/
safemkdir ${LOG_PATH}/

ACCESS_LOG=${LOG_PATH}/${dateFormat}.info.log
ERROR_LOG=${LOG_PATH}/${dateFormat}.error.log

hint="Usage: "
hasEnv=0

checkEnvParam(){
  for env_name in ${ENV_LIST[@]};do
    if [[ "${env_name}" == "$1" ]] ; then
        hasEnv=1
    fi
  done
}

getUsageHint(){
  for env_name in ${ENV_LIST[@]};do
    hint=${hint}${env_name}
  done
}

checkEnvParam $2
getUsageHint

started="#################################################################################\n
           Application [${APP_NAME}] for environment [${PROJECT_ENV}] Started At  $(date) \n
        ##################################################################################\n"

stopped="#################################################################################\n
                Application [${APP_NAME}] Stopped At  $(date)                             \n
        ##################################################################################\n"

if [[ "${hasEnv}" == 0 ]]; then
    echo ${hint}
    exit 0
else
    echo -e ${started}
    java ${JAVA_OPTIONS} -jar ${APP_HOME}/lib/mbp-${APP_NAME}-${APP_VERSION}.jar
fi