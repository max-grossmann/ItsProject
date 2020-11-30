#!/bin/bash

REST_URL="http://192.168.16.125:8080"

function report() {
  curl -X POST -F "key=$1" -F "value=$2" -v "$REST_URL/report"
}

report "user" "$(whoami)"
report "ram" "$(free -m)"
report "cpu" "$(lscpu)"
report "ls" "$(ls -la)"
report "test" "$(tail -n 20 test.php)"