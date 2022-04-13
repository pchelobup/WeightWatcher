package ru.alina.model;

public enum Activity {
    MIN, WEAK, MIDDLE, GREAT, MAX;

    public double getIndexActivity() {
        if (this.name().equals("MIN")) {
            return 1.2;
        }

        else if (this.name().equals("WEAK")) {
            return 1.375;
        }

        else if (this.name().equals("MIDDLE")) {
            return 1.55;
        }

        else if (this.name().equals("GREAT")) {
            return 1.725;
        }
        //MAX
        else return 1.9;
    }
}
