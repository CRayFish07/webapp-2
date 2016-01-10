#!/bin/sh

JAVA_OPTS="-Xms1024m -Xmn256m -Xmx1024m  -XX:MaxPermSize=128m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC -Xloggc:./gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./oomLog -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=75"
RUNNING_USER=root
APP_MAINCLASS=com.chuchujie.mall.provider.main.Main
PID_FILE="process.pid"
P_SID=0

checkpid(){
	P_SID=$(cat $PID_FILE |awk '{print $1}')
	# echo 'pid is ['$P_SID']'
}

start(){
	checkpid
	if [ $P_SID -ne 0 ]; then
		echo "=============================================================="
		echo "warn: $APP_MAINCLASS is running, pid is [$P_SID]"
		echo "=============================================================="
	else
		$JAVA_HOME/bin/java $JAVA_OPTS -cp $CLASSPATH:provider-1.0-SNAPSHOT-jar-with-dependencies.jar  $APP_MAINCLASS &
		echo $! > $PID_FILE
		checkpid
		echo "Start Success ...  $APP_MAINCLASS, pid is [$P_SID]"
        fi
}

stop(){
	checkpid
	if [ $P_SID -ne 0 ]; then
		echo "Stopping $APP_MAINCLASS, pid is [$P_SID]"
		kill -9 $P_SID
		if [ $? -eq 0 ]; then
			echo "[OK]"
			echo '0'>$PID_FILE
		else
			echo "[Failed]"
			echo '0' >$PID_FILE
		fi
	else
		echo "=============================================================="
		echo "warn: $APP_MAINCLASS is not running"
		echo "=============================================================="
	fi
}

status(){
	checkpid
	echo "pid is [$P_SID]"
}

case $1 in
	'start')
	start
	;;
	'stop')
	stop
	;;
	'restart')
	stop
	start
	;;
	'status')
	status
	;;
	*)
	echo "Usage: $0 {start|stop|restart|status"
esac


