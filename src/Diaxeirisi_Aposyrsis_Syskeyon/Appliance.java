/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diaxeirisi_Aposyrsis_Syskeyon;

/**
 *
 * @author Iliana
 */
public class Appliance {

    private String type; //είδος συσκευής
    private double height; //ύψος
    private double length; //μήκος
    private double width; //πλάτος
    private double volume; //όγκος
    private double weight; //βάρος

    //constructor που αρχικοποιεί τα πεδία type, volume, weight.
    //Τα πεδία height, length, width δεν θα αρχικοποιηθούν 
    //απλά δηλώνονται στη κλαση ως πεδία της, απο διαγραμμα κλάσεων
    public Appliance(String type, double volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }
    
    //getters
    public String getType() {
        return type;
    }
        
    public double getHeight() {
        return height;
    }
    
    public double getLength() {
        return length;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getVolume() {
        return volume;
    }
    public double getWeight() {
        return weight;
    }
     
    //setters
    public void setType(String type) {
        this.type = type;
    }
         
    public void setHeight(double height) {
        this.height = height;
    }
    
    public void setLength(double length) {
        this.length = length;
    }
    
    public void setWidth(double width) {
        this.width = width;
    }
    
    public void setVolume(double volume) {
       this.volume = volume;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ΣΥΣΚΕΥΗ{" + "είδος_συσκευής=" + type + ", όγκος=" + volume + ", βάρος=" + weight + '}';
    }
   
}
