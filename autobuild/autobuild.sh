#!/bin/sh
exec 5<>/var/www/tictactoe/buildstatus.html

echo """
<html>
<head>
<meta http-equiv='refresh' content='5'>
<title>Autobuild system - status</title>
</head>
<body>
<pre>
""" >&5

BASEDIR=/home/cc/autobuild

cd $BASEDIR
echo -n "Automated build @ " >&5
date >&5
echo "BASEDIR: $BASEDIR" >&5
echo >&5

cd tictactoe
LASTBUILD=$(cat .lastbuild)
echo "Last built revision: $LASTBUILD" >&5
echo "Starting 'git pull'" >&5
git pull 2>&1 > /dev/null
git show | head -1 | awk '{print $2}' > .lastbuild
CURRENTBUILD=$(cat .lastbuild)
echo "Current revision: $CURRENTBUILD" >&5

if [ "$CURRENTBUILD" = "$LASTBUILD" ]
then
	echo "Already up to date, quitting..." >&5
else
	echo "New revision detected" >&5
	exec 6<>/var/www/tictactoe/buildlog.html
	echo """
<html>
<head>
<meta http-equiv='refresh' content='5'>
<title>Autobuild system - buildlog</title>
</head>
<body>
<pre>
""" >&6
	echo "Starting 'ant' building process for revision $CURRENTBUILD" >&6
	ant >&6
	BUILDRESULT=$?
	if [ $BUILDRESULT -eq 0 ]
	then
		echo "Copying JAR file" >&6
		cp deploy/tictactoe.jar /var/www/tictactoe/
	else
		echo "BUILD FAILED - quitting" >&6
	fi

echo """
</pre>
</body>
</html>
""" >&6
	
fi

echo """
</pre>
</body>
</html>
""" >&5
