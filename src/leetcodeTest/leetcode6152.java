package leetcodeTest;

public class leetcode6152 {
    public static void main(String[] args) {
        System.out.println(minNumberOfHours(1,1,new int[]{1,1,1,1},new int[]{1,1,1,50}));
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int totalEnergy=0;
        for(int i=0; i<energy.length; i++){
            totalEnergy+=energy[i];
        }
        int energyDays=totalEnergy+1-initialEnergy;

        int experienceDays=0;

        for(int i=0; i<experience.length; i++){
            if(experience[i]+1>initialExperience){
                experienceDays+=experience[i]+1-initialExperience;
                initialExperience=experience[i]+1;
            }
            initialExperience+=experience[i];
        }
        return experienceDays+energyDays;
    }
}


