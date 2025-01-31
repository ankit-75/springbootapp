#!/bin/bash

for n in {1..10};
do
    curl http://localhost:8083/employee-app/api/employees/1 &
    echo $n
done