package Lesson18.ClassWork.DesignPatterns.structural.src.facade11;

/*
 *  Java Design Pattern Essentials
 *  Copyright 2010, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

public class Registration {

    private Vehicle vehicle;

    public Registration(Vehicle v) {
        this.vehicle = v;
    }

    public void allocateLicensePlate() {
        // Code omitted...
    }

    public void allocateVehicleNumber() {
        // Code omitted...
    }

}