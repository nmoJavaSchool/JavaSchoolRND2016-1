package Lesson18.HomeWork.Decorator;

/**
 * Created by user on 12.09.16.
 */
public abstract class Doctor implements ISickCondition {
    ISickCondition sickPerson;


    public void setSickPerson(ISickCondition sickPerson) {
        this.sickPerson = sickPerson;
    }


    @Override
    public void doHealthCare() {
        if(sickPerson!=null) {
            sickPerson.doHealthCare();
            System.out.println( "Doctor treats.");
        }
    }
}
