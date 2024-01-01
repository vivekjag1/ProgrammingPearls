public class vectorShift {
    /**
     * a class for the problems relating to shifting vectors
     */
    String s; //the vector that will be shifted
    int howMuch; //the number of places that need to be shifted

    //constructor
    vectorShift(String s, int howMuch){
        this.s = s;
        this.howMuch = howMuch;
    }

    /**
     * rotate: a method to rote a vector. Uses an N^2 runtime due to nested loops
     * @return the rotated vector
     */
    String rotate(){
        char[] sArr = this.s.toCharArray(); //switch to character array
        while(sArr[0] != this.s.charAt(howMuch)){ //while the correct character is not at the front of the array
            char first  = sArr[0]; //store the first character in variable
            for(int i = 1; i < sArr.length; i++){ //go through the array moving characters to the left
                sArr[i-1] = sArr[i];
                if(i == this.s.length() - 1){
                    sArr[i] = first; //then add first character to the end.
                }
            }

        }


        System.out.println(sArr);
        return "";
    }

    /**
     * rotateBetter: a method to rotate a vector in linear time
     * @param aString the rotated vector
     * @return
     */
    public String rotateBetter(String aString){
        //create three separate strings: the characters being rotated, the next n chars, and then the remaining characters.
        String a = aString.substring(0, howMuch);
        String br = aString.substring(howMuch*2);
        String b = aString.substring(howMuch, howMuch*2);
        return b + br + a; //concatenate together in rotated order
    }

    /**
     * rotateThreeSections: a method to rotate a string around a middle portion
     * @param toRotate the string to be rotated
     * @param nOne the ending index of the first portion
     * @param nTwo the ending index of the second portion
     * @return a string in the form cba
     */
    public String rotateThreeSections(String toRotate, int nOne, int nTwo){
        String a = toRotate.substring(0, nOne);
        String b = toRotate.substring(nOne, nTwo);
        String c = toRotate.substring(nTwo);
        return c + b + a;
    }
}
