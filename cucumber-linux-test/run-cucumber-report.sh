#!/bin/bash

cd /lclhome/aadon004/automation/cucumber-linux-test || exit 1
# Set environment variables (email credentials)
export EMAIL_USER="youremail@gmail.com"
export EMAIL_PASS="your_app_password"

# Run Maven build
/usr/bin/mvn clean verify

