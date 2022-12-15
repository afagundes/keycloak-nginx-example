#!/bin/bash

ip_address="127.0.0.1"
host_name="keycloak-nginx-proxy"

matches_in_hosts="$(grep -n $host_name /etc/hosts | cut -f1 -d:)"
host_entry="${ip_address} ${host_name}"

if [ -z "$matches_in_hosts" ]
then
    echo "$host_entry" | sudo tee -a /etc/hosts > /dev/null
fi
