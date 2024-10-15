package com.example.device_predict.domain;

import jakarta.persistence.*;




@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int batteryPower;
    @Column(nullable = false)
    private int ram;
     @Column(nullable = false)
    private int pxWidth;
    @Column(nullable = false)
    private int pxHeight;
    @Column(nullable = false)
    private int blue;
    @Column(nullable = false)
    private double clockSpeed;
    @Column(nullable = false)
    private int dualSim;
    @Column(nullable = false)

    private int fc; // Front Camera
    @Column(nullable = false)
    private int fourG;
    @Column(nullable = false)
    private int intMemory;
    @Column(nullable = false)
    private double mDep; // Mobile Depth
    @Column(nullable = false)
    private int mobileWt; // Mobile Weight
    @Column(nullable = false)
    private int nCores; // Number of Cores
    @Column(nullable = false)
    private int pc; // Primary Camera
    @Column(nullable = false)
    private int scH; // Screen Height
    @Column(nullable = false)
    private int scW; // Screen Width
    @Column(nullable = false)
    private int talkTime;
    @Column(nullable = false)
    private int threeG;
    @Column(nullable = false)
    private int touchScreen;
    @Column(nullable = false)
    private int wifi;

    private String predictedPrice;

    // Default Constructor
    public Device() {}

    // Constructor with parameters
    public Device(int batteryPower, int ram, int pxWidth, int pxHeight, int blue, double clockSpeed, int dualSim, int fc, int fourG, int intMemory, double mDep, int mobileWt, int nCores, int pc, int scH, int scW, int talkTime, int threeG, int touchScreen, int wifi) {
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.pxWidth = pxWidth;
        this.pxHeight = pxHeight;
        this.blue = blue;
        this.clockSpeed = clockSpeed;
        this.dualSim = dualSim;
        this.fc = fc;
        this.fourG = fourG;
        this.intMemory = intMemory;
        this.mDep = mDep;
        this.mobileWt = mobileWt;
        this.nCores = nCores;
        this.pc = pc;
        this.scH = scH;
        this.scW = scW;
        this.talkTime = talkTime;
        this.threeG = threeG;
        this.touchScreen = touchScreen;
        this.wifi = wifi;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPxWidth() {
        return pxWidth;
    }

    public void setPxWidth(int pxWidth) {
        this.pxWidth = pxWidth;
    }

    public int getPxHeight() {
        return pxHeight;
    }

    public void setPxHeight(int pxHeight) {
        this.pxHeight = pxHeight;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int getDualSim() {
        return dualSim;
    }

    public void setDualSim(int dualSim) {
        this.dualSim = dualSim;
    }

    public int getFc() {
        return fc;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public int getFourG() {
        return fourG;
    }

    public void setFourG(int fourG) {
        this.fourG = fourG;
    }

    public int getIntMemory() {
        return intMemory;
    }

    public void setIntMemory(int intMemory) {
        this.intMemory = intMemory;
    }

    public double getMDep() {
        return mDep;
    }

    public void setMDep(double mDep) {
        this.mDep = mDep;
    }

    public int getMobileWt() {
        return mobileWt;
    }

    public void setMobileWt(int mobileWt) {
        this.mobileWt = mobileWt;
    }

    public int getNCores() {
        return nCores;
    }

    public void setNCores(int nCores) {
        this.nCores = nCores;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getScH() {
        return scH;
    }

    public void setScH(int scH) {
        this.scH = scH;
    }

    public int getScW() {
        return scW;
    }

    public void setScW(int scW) {
        this.scW = scW;
    }

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public int getThreeG() {
        return threeG;
    }

    public void setThreeG(int threeG) {
        this.threeG = threeG;
    }

    public int getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(int touchScreen) {
        this.touchScreen = touchScreen;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public String getPredictedPrice() {
        return predictedPrice;
    }

    public void setPredictedPrice(String predictedPrice) {
        this.predictedPrice = predictedPrice;
    }
}
