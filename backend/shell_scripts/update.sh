#!/bin/sh

echo **********************************************************************************
echo ==================================================================================
echo ---------------------------starting script by M@X---------------------------------
echo ==================================================================================
echo **********************************************************************************
echo
#access server
ssh -p 10922 user@gfapp.eu '
# git pull

cd Foxbook;
git pull;
cd frontend;

# removes old angular build
rm -rf ../backend/src/main/resources/static;

# makes new angular build
ng build;
cd ../backend;

# builds spring
sh gradlew;
sh gradlew build;
'

# as a sudo you still have to run: sudo systemctl restart Foxbook
# exit


