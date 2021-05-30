package JavaForTesters.Lesson1.Homework01;

public class Human {
protected String name;
protected int maxRun;
protected float maxJump;

public Human(String name, int maxRun, float maxJump){
       this.name = name;
       this.maxRun = maxRun;
       this.maxJump = maxJump;
}

    public boolean run(Track track) {
        if (track.length <= maxRun) {
            System.out.println(this.name + " has run " + track.length + " m");
            return true;
        } else {
            System.out.println(this.name + " didn't manage run such a long distance and stopped the competition!");
            return false;
        }
    }

    public boolean jump(Wall wall) {
        if (wall.height <= maxJump) {
            System.out.println(this.name + " has jumped the wall of " + wall.height + " m");
            return true;
        } else {
            System.out.println(this.name + " didn't manage jump so high and stopped the competition!");
            return false;
        }
    }
}
