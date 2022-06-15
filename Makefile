output: classes/mlr_agent/agentMLR.class
	java -cp ~/Library/JADE/jade.jar:classes jade.Boot -gui -agents Felipe_Tlaxcala:mlr_agent.agentMLR


classes/mlr_agent/agentMLR.class:
	javac -classpath ~/librerias/jade.jar -d classes src/mlr_agent/*.java

clean:
	rm classes/mlr_agent/*.class
