package com.p2prototype.b217.moodprototype;

public class VisualObject extends HistorikActivity {
    private int mood;
    private int anxiety;
    private int sleepHours;
    private int sleepMinutes;
    private int weightK;
    private int weightG;
    private String note;
    private String date;
    /*private ArrayList<Event> events = new ArrayList<>(0);
    private ArrayList<Medicine> meds = new ArrayList<>(0);*/
    public VisualObject(int mo, int anxi, int sleepH, int sleepM, int wK, int wG,
                       String no, /*ArrayList<Event> even, ArrayList<Medicine> med, */String dat/*+ medicin og begivenhed array, samt dato*/) {
        this.mood = mo;
        this.anxiety = anxi;
        this.sleepHours = sleepH;
        this.sleepMinutes = sleepM;
        this.weightK = wK;
        this.weightG = wG;
        this.note = no;
        /*this.events = even;
        this.meds = med;*/
        this.date = dat;
    }

    public String getDate() {
        return date;
    }

    public int getMood() {
        return mood;
    }

    public int getAnxiety() {
        return anxiety;
    }

    public String getSleep() {
        return sleepHours+":"+String.format("%02d", sleepMinutes);
    }

    public String getWeight() {
        return weightK+","+weightG+"kg";
    }

    public String getNote(){
        return note;
    }
    public boolean getNoteBoolean() {
        return !note.trim().equals("");
    }

    /*public ArrayList<Event> getEvents() {
        return events;
    }
    public boolean getEventsBoolean(){
        return events.size()!=0;
    }
    public ArrayList<Medicine> getMeds() {
        return meds;
    }
    public boolean getMedsBoolean(){
        return meds.size()!=0;
    }*/
}
