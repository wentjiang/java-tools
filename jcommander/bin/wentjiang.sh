#!/usr/bin/env bash

PROJECT_HOME=$(dirname $(dirname "$PWD"))
JCOMMANDER_JAR=${PROJECT_HOME}/jcommander/target/jcommander-jar-with-dependencies.jar
function printUsage() {
    echo "Usage: wentjiang.sh COMMAND [args]"
    echo -e "  runner \t test runner"
}
function runJavaClass {
  CLASS_ARGS=()
  for arg in "$@"; do
    CLASS_ARGS+=("${arg}")
  done

  java -cp ${CLASSPATH} ${CLASS} "${CLASS_ARGS[@]}"
}

function main {
    if [[ $# == 0 ]]; then
      printUsage
      exit 1
    fi

    COMMAND=$1
    shift

    case ${COMMAND} in
    "runner")
      echo "use runner command!"
      CLASS="com.wentjiang.jcommander.WentjiangRunner"
      CLASSPATH=${JCOMMANDER_JAR}

     runJavaClass "$@"
    ;;
    *)
      echo "Unsupported command ${COMMAND}" >&2
    ;;
    esac
}

main "$@"

#run this for test
#sh wentjiang.sh runner  --name hahaha