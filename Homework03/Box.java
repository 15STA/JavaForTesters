package JavaForTesters.Lesson3.Homework03;

import java.util.Arrays;

public class Box<T extends Fruit> {
        private T[] obj;

    public Box(T[] obj) {
            this.obj= obj;
        }

        public T[] getObj() {
            return obj;
        }


        public void setObj(T[] obj) {
            this.obj = obj;
        }

//        @Override
//        public String toString() {
//            StringBuffer s = new StringBuffer();
//            for (int i = 0; i < obj.length; i++) {
//                s.append(obj[i]);
//            }
//         return s.toString();
//        }

        public double getWeight(){
            double boxWeigh = 0.0;
            if (obj.length==0)  {
               return boxWeigh;
            }
            else {
                for (T itemArray:
                     obj) {
                  boxWeigh += itemArray.weight;
                }
            }
            return boxWeigh;
        }

        public boolean compareBox(Box<?> anyBox){
            if (Math.abs(this.getWeight() - anyBox.getWeight()) < 0.001) {
               return true;
            }
            else return false;
        }

        //quantity of anyBox's elements
        public int numberBoxObj(Box<?> anyBox){
            return anyBox.getObj().length;
        }

        // put fruit from this box to anyBox
        public void putFruitToAnotherBox(Box<T> anyBox){
            int sizeAuxiliaryBox = numberBoxObj(this) + numberBoxObj(anyBox);
            Fruit[] auxiliaryArr = new Fruit[sizeAuxiliaryBox];

            for (int i=0; i<sizeAuxiliaryBox; i++) {
                if (i < numberBoxObj(this)) {
                    auxiliaryArr[i] = obj[i];

                }
                else{
                   auxiliaryArr[i]=anyBox.getObj()[i-numberBoxObj(this)];
                }

               System.out.println(auxiliaryArr[i] + "ok");
            }

           anyBox.setObj((T[]) auxiliaryArr);

        }
    }


