package by.perevertkin.mobile;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Users implements Cloneable {
    private String name;
    private String surname;
    private String mail;
    private Number age;
 
    protected Object clone() throws CloneNotSupportedException {
       return super.clone();
     }
    
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        propertyChangeSupport.firePropertyChange("name", oldName, name);
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        String oldSurname = this.surname;
        this.surname = surname;
        propertyChangeSupport.firePropertyChange("surname", oldSurname, surname);
    }

    public String getSurname() {
        return surname;
    }

    public void setMail(String mail) {
        String oldMail = this.mail;
        this.mail = mail;
        propertyChangeSupport.firePropertyChange("mail", oldMail, mail);
    }

    public String getMail() {
        return mail;
    }

    public void setAge(Number age) {
        Number oldAge = this.age;
        this.age = age;
        propertyChangeSupport.firePropertyChange("age", oldAge, age);
    }

    public Number getAge() {
        return age;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
