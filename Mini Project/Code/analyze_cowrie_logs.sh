#!/bin/bash

LOG_FILE=~/cowrie8/var/log/cowrie/cowrie.log

echo "Total login attempts:"
grep "login attempt" "$LOG_FILE" | wc -l

echo
echo "Unique usernames:"
grep "login attempt" "$LOG_FILE" | sed -nE "s/.*login attempt \[b'([^']+)'.*/\1/p" | sort | uniq

echo
echo "Unique passwords:"
grep "login attempt" "$LOG_FILE" | sed -nE "s/.*login attempt \[b'[^']+'\/b'([^']+)'.*/\1/p" | sort | uniq

echo
echo "IP addresses of attackers:"
grep "login attempt" "$LOG_FILE" | sed -nE "s/.*HoneyPotSSHTransport,[0-9]+,([0-9]+\.[0-9]+\.[0-9]+\.[0-9]+)\].*/\1/p" | sort | uniq
