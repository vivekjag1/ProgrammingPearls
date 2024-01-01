public class main {
    public static void main(String[] args){
        vectorShift shift = new vectorShift("Hello", 2);
        System.out.println(shift.rotate()); //rotate in polynomial time
        System.out.println(shift.rotateBetter(shift.s));  //rotate in linear time
        System.out.println(shift.rotateThreeSections(shift.s, 2, 3)); //rotate in 3 parts

    }
}
