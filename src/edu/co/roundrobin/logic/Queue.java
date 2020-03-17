package edu.co.roundrobin.logic;

import edu.co.roundrobin.UI.GUI;
import edu.co.roundrobin.models.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author juancamilo
 */
public class Queue {

    private final String ALPHABETH[] = {"A", "B", "C", "D", "E", "F", "G", "H",
        "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V",
        "W", "X", "Y", "Z"};

    private final GUI gui;
    private int numberOfProcesses;
    private int totalTime;

    private List<Process> processes;

    public Queue() {
        this.gui = new GUI();
        gui.btnStart.addActionListener(new java.awt.event.ActionListener() {      //Metodo implementado provisional para el actionperformed 
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
    }

    public void initProcesses() {
        Process newProcess;
        int executionTime;
        totalTime = 0;
        Random ran = new Random();
        numberOfProcesses = ran.nextInt(3) + 1;
        processes = new ArrayList<>();

        for (int i = 0; i < numberOfProcesses; i++) {
            executionTime = ran.nextInt(6) + 1;
            newProcess = new Process(ALPHABETH[i], i, executionTime);
            totalTime += executionTime;
            newProcess.setColor(gui.getRandomColor());
            processes.add(newProcess);
        }
    }

    void btnStartActionPerformed(java.awt.event.ActionEvent evt) {
        initProcesses();
        gui.drawTable(processes);
        gui.drawDiagram(processes, totalTime);

        Thread waitThread;
        waitThread = new Thread() {
            @Override
            public void run() {
                int quantumTime = 4; // time to execute process
                int startTime = 0;
                Process actualProcess, remainingProcess;

                try {
                    gui.btnStart.setEnabled(false);
                    for (int i = 0; i < processes.size(); i++) {
                        actualProcess = processes.get(i);
                        actualProcess.setStartTime(startTime);
                        
                        if (actualProcess.getExecutionTime() > quantumTime) {
                            actualProcess.setAcumulateExecTime(actualProcess.getAcumulateExecTime()+quantumTime);
                            
                            remainingProcess = new Process(
                                    actualProcess.getProcessName() + i,
                                    actualProcess.getArriveTime(),
                                    actualProcess.getExecutionTime() - quantumTime
                            );

                            if (remainingProcess.getExecutionTime() >= quantumTime) {
                                remainingProcess.setAcumulateExecTime(actualProcess.getAcumulateExecTime() + quantumTime);
                            } else {
                                remainingProcess.setAcumulateExecTime(actualProcess.getExecutionTime());
                            }

                            remainingProcess.setColor(actualProcess.getColor());
                            processes.add(remainingProcess);

                            gui.addTableRow(remainingProcess.getProcessName(),
                                    actualProcess.getArriveTime(),
                                    remainingProcess.getExecutionTime()
                            );
                            gui.addDiagramRow(remainingProcess.getProcessName());
                        } else {
                            if (i < numberOfProcesses) {
                                actualProcess.setAcumulateExecTime(actualProcess.getExecutionTime());
                            }
                        }

                        System.out.println("actual process: " + actualProcess.getProcessName());

                        actualProcess.calculateTimes(quantumTime);

                        gui.editDiagramCell(actualProcess.getProcessName(), i, 0);

                        for (int j = startTime; j < actualProcess.getEndTime(); j++) {
                            gui.paintCell(j + 1, i, actualProcess.getColor());
                            this.sleep(1000);
                        }

                        startTime = actualProcess.getEndTime();

                        gui.addTableInfo(actualProcess.getStartTime(),
                                actualProcess.getEndTime(), actualProcess.getReturnTime(),
                                actualProcess.getWaitTime(), i);
                    }

                } catch (Exception e) {
                    System.out.println("Error en waitThread.run(): " + e);
                } finally {
                    gui.btnStart.setEnabled(true);
                }
            }
        };
        waitThread.start();
    }

}
