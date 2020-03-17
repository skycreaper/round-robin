package edu.co.roundrobin.models;

import java.awt.Color;

/**
 *
 * @author juancsr
 */
public class Process {
    private String processName;
    private boolean isRemaining;
    private int timeWasBlocked;
    private int arriveTime;
    private int frontArriveTime; // tiempo de llegada en front
    private int executionTime; // tiempo de rafaga
    private int acumulateExecTime; // tiempo de rafaga acumulado
    private int startTime;
    private int endTime;
    private int returnTime;
    private int waitTime;
    private Color color;

    /*
    * Processes's constructor 
    * @param name Name of the process
    * @param arriveTime Time it takes to the process arrive into the critial section
    * @param exectionTime: Time it takes for the process to be executed
    */
    public Process(String name, int arriveTime, int executionTime) {
        isRemaining = false;
        this.processName = name;
        this.arriveTime = arriveTime;
        this.executionTime = executionTime;
    }
    
    public void calculateTimes(int quantum) {
        if (executionTime > quantum) {
            endTime = startTime + quantum;
        } else {
            endTime = startTime + executionTime;
        }
        returnTime = endTime - arriveTime;
        waitTime = returnTime - acumulateExecTime;
    }
    
    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(int arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public boolean isIsRemaining() {
        return isRemaining;
    }

    public void setIsRemaining(boolean isRemaining) {
        this.isRemaining = isRemaining;
    }

    public int getEndTime() {
        return this.endTime; 
    }
    
    public int getReturnTime() {
        return this.returnTime;
    }
    
    public int getWaitTime() {
        return this.waitTime;
    }

    public int getTimeWasBlocked() {
        return timeWasBlocked;
    }

    public void setTimeWasBlocked(int timeWasBlocked) {
        this.timeWasBlocked = timeWasBlocked;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getFrontArriveTime() {
        return frontArriveTime;
    }

    public void setFrontArriveTime(int frontArriveTime) {
        this.frontArriveTime = frontArriveTime;
    }

    public int getAcumulateExecTime() {
        return acumulateExecTime;
    }

    public void setAcumulateExecTime(int acumulateExecTime) {
        this.acumulateExecTime += acumulateExecTime;
    }

}
