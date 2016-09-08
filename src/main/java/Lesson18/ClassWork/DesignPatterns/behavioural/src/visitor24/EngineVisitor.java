package Lesson18.ClassWork.DesignPatterns.behavioural.src.visitor24;

/*
 *  Java Design Pattern Essentials
 *  Copyright 2010, Ability First Limited
 *
 *  This source code is provided to accompany the book and is provided AS-IS without warranty of any kind.
 *  It is intended for educational and illustrative purposes only, and may not be re-published
 *  without the express written permission of the publisher.
 */

public interface EngineVisitor {

    public void visit(Camshaft p);
    public void visit(Engine e);
    public void visit(Piston p);
    public void visit(SparkPlug sp);

}