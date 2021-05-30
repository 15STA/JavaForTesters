package JavaForTesters.Lesson1.Homework01;

import java.util.Arrays;

public class Competition {
    public Human human1 = new Human ("Nick", 40000, 1.3f);
    public Human human2 = new Human ("Ivan", 50000, 2.5f);
    public Robot robot1 = new Robot ("Robotic", 100000, 2.5f);
    public Cat cat1 = new Cat ("Bars", 1500, 2.1f);


    public Track track1 = new Track (1000);
    public Wall wall1 = new Wall (0.3f);
    public Track track2 = new Track (5000);
    public Wall wall2 = new Wall (2.0f);
    public Track track3 = new Track (45000);
    Object[] participants = {human1, human2, robot1, cat1};
    Object[] challenges = {track1, wall1, track2, wall2, track3};
    boolean[] checkParticipant = new boolean[participants.length]; // true- participant continues the race, false - stop


    Competition() {
        Arrays.fill(checkParticipant, true);
               for (int j=0; j<challenges.length; j++) {
                for (int i = 0; i < participants.length; i++) {
                    if (checkParticipant[i]) {
                        checkParticipant[i] = ifContinueRace(participants[i], challenges[j]);
                    }
                }
        }
    }

    public boolean ifContinueRace(Object participant, Object challenge){
        if (challenge instanceof Track) {
            Track trackLink = (Track) challenge;
            if (participant instanceof Human) {
                Human humanLink = (Human) participant;
                return humanLink.run(trackLink);
            } else if (participant instanceof Robot) {
                Robot robotLink = (Robot) participant;
                return robotLink.run(trackLink);
            } else {
                Cat catLink = (Cat) participant;
                return catLink.run(trackLink);
            }
        }
        else {
            Wall wallLink = (Wall) challenge;
            if (participant instanceof Human) {
                Human humanLink = (Human) participant;
                return humanLink.jump(wallLink);
            } else if (participant instanceof Robot) {
                Robot robotLink = (Robot) participant;
                return robotLink.jump(wallLink);
            } else {
                Cat catLink = (Cat) participant;
                return catLink.jump(wallLink);
            }
        }


    }
}

