#!/bin/bash

for i in {1..60} ; do
    curl --location 'localhost:8080' \
    --header 'Content-Type: text/plain' \
    --data "$i"
done
