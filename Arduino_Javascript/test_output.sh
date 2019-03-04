#!/bin/bash
while :
do
    sleep 1
    echo $((10 + RANDOM % 4))
done